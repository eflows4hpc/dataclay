"""Management of Python Classes.

This module is responsible of management of the Class Objects. A central Python
Metaclass is responsible of Class (not object) instantiation.

Note that this managers also includes most serialization/deserialization code
related to classes and function call parameters.
"""

from __future__ import annotations

import functools
import logging
import traceback
from collections import ChainMap
from inspect import get_annotations
from typing import TYPE_CHECKING

from dataclay.exceptions import *
from dataclay.metadata.kvdata import ObjectMetadata
from dataclay.runtime import LockManager, get_runtime
from dataclay.utils.telemetry import trace

if TYPE_CHECKING:
    from uuid import UUID

DC_PROPERTY_PREFIX = "_dc_property_"


tracer = trace.get_tracer(__name__)
logger = logging.getLogger(__name__)


def activemethod(func):
    """Decorator for DataClayObject active methods."""

    @functools.wraps(func)
    def wrapper_activemethod(self: DataClayObject, *args, **kwargs):
        logger.debug(f"({self._dc_meta.id}) Calling active method {func.__name__}")
        try:
            # If the object is local executes the method locally,
            # else, executes the method in the backend
            if self._dc_is_local:
                # TODO: Use active_counter only if inside backend
                with LockManager.read(self._dc_meta.id):
                    result = func(self, *args, **kwargs)
                return result
            else:
                return get_runtime().call_remote_method(self, func.__name__, args, kwargs)
        except Exception:
            traceback.print_exc()
            raise

    # wrapper_activemethod.is_activemethod = True
    return wrapper_activemethod


class DataClayProperty:
    __slots__ = "property_name", "dc_property_name"

    def __init__(self, property_name: str):
        self.property_name = property_name
        self.dc_property_name = DC_PROPERTY_PREFIX + property_name

    def __get__(self, instance: DataClayObject, owner):
        """
        | is_local | is_load |
        | True     | True    |  B (heap) or C (not persistent)
        | True     | False   |  B (stored)
        | False    | True    |  -
        | False    | False   |  B (remote) or C (persistent)
        """
        logger.debug(
            f"({instance._dc_meta.id}) Getting property {instance.__class__.__name__}.{self.property_name}"
        )

        if instance._dc_is_local:
            try:
                if not instance._dc_is_loaded:
                    get_runtime().load_object_from_db(instance)

                return getattr(instance, self.dc_property_name)
            except AttributeError as e:
                e.args = (e.args[0].replace(self.dc_property_name, self.property_name),)
                raise e
        else:
            return get_runtime().call_remote_method(
                instance, "__getattribute__", (self.property_name,), {}
            )

    def __set__(self, instance: DataClayObject, value):
        """Setter for the dataClay property

        See the __get__ method for the basic behavioural explanation.
        """
        logger.debug(
            f"({instance._dc_meta.id}) Setting property {instance.__class__.__name__}.{self.property_name}={value}"
        )

        if instance._dc_is_local:
            if not instance._dc_is_loaded:
                get_runtime().load_object_from_db(instance)

            setattr(instance, self.dc_property_name, value)
        else:
            get_runtime().call_remote_method(
                instance, "__setattr__", (self.property_name, value), {}
            )


class DataClayObject:
    """Main class for Persistent Objects.

    Objects that has to be made persistent should derive this class (either
    directly, through the StorageObject alias, or through a derived class).
    """

    _dc_meta: ObjectMetadata

    _dc_is_local: bool = True
    _dc_is_loaded: bool = True
    _dc_is_registered: bool = False
    _dc_is_replica: bool = False

    def __init_subclass__(cls) -> None:
        """Defines a @property for each annotatted attribute"""
        for property_name in ChainMap(*(get_annotations(c) for c in cls.__mro__)):
            if not property_name.startswith("_dc_"):
                setattr(cls, property_name, DataClayProperty(property_name))

    def __new__(cls, *args, **kwargs):
        obj = super().__new__(cls)
        obj._dc_meta = ObjectMetadata(class_name=cls.__module__ + "." + cls.__name__)
        if get_runtime() and get_runtime().is_backend:
            obj.make_persistent()

        logger.debug(
            f"({obj._dc_meta.id}) New instance {cls.__name__} args={args}, kwargs={kwargs}"
        )
        return obj

    @classmethod
    def new_proxy_object(cls):
        obj = super().__new__(cls)
        obj._dc_meta = ObjectMetadata(class_name=cls.__module__ + "." + cls.__name__)
        return obj

    @property
    def _dc_dict(self):
        """Returns __dict__ with only _dc_ attributes"""
        return {k: v for k, v in vars(self).items() if k.startswith("_dc_")}

    @property
    def _dc_properties(self):
        """Returns __dict__ with only _dc_property_ attributes"""
        return {k: v for k, v in vars(self).items() if k.startswith(DC_PROPERTY_PREFIX)}

    @property
    def _dc_state(self):
        """Returns the object state"""
        state = self._dc_properties | {"_dc_meta": self._dc_meta}
        if hasattr(self, "__getstate__") and hasattr(self, "__setstate__"):
            state["_dc_getstate"] = self.__getstate__()
        return state

    @property
    def _dc_all_backend_ids(self) -> set[UUID]:
        """Returns a set with all the backend ids where the object is stored"""
        if self._dc_meta.master_backend_id is None:
            return set()
        return self._dc_meta.replica_backend_ids | {self._dc_meta.master_backend_id}

    @property
    def is_persistent(self) -> bool:
        """Whether the object is registered in the dataClay system or not."""
        return self._dc_is_registered

    @property
    def backends(self) -> set[UUID]:
        """Returns a set with all the backend ids where the object is stored"""
        return self._dc_all_backend_ids

    def sync(self):
        """Synchronizes the object metadata

        It will always retrieve the current metadata from the kv database.
        It won't update local changes to the database.

        Raises:
            ObjectNotRegisteredError: If the object is not registered.
            ObjectIsMasterError: If the object is the master.
        """
        if not self._dc_is_registered:
            raise ObjectNotRegisteredError(self._dc_meta.id)
        if self._dc_is_local and not self._dc_is_replica:
            raise ObjectIsMasterError(self._dc_meta.id)
        get_runtime().sync_object_metadata(self)

    def _clean_dc_properties(self):
        """
        Used to free up space when the client or backend lose ownership of the objects;
        or the object is being stored and unloaded
        """
        self.__dict__ = {
            k: v for k, v in vars(self).items() if not k.startswith(DC_PROPERTY_PREFIX)
        }

    ###########################
    # Object Oriented Methods #
    ###########################

    @tracer.start_as_current_span("make_persistent")
    def make_persistent(self, alias: str | None = None, backend_id: UUID | None = None):
        """Makes the object persistent.

        Args:
            alias: Alias of the object. If None, the object will not have an alias.
            backend_id: ID of the backend where the object will be stored. If None, the object
                will be stored in a random backend.

        Raises:
            KeyError: If the backend_id is not registered in dataClay.
        """
        if self._dc_is_registered:
            if backend_id:
                self.move(backend_id)
            if alias:
                self.add_alias(alias)
        else:
            get_runtime().make_persistent(self, alias=alias, backend_id=backend_id)

    @classmethod
    @tracer.start_as_current_span("get_by_id")
    def get_by_id(cls, object_id: UUID) -> DataClayObject:
        """Returns the object with the given id.

        Args:
            object_id: ID of the object.

        Returns:
            The object with the given id.

        Raises:
            DoesNotExistError: If the object does not exist.
        """
        return get_runtime().get_object_by_id(object_id)

    @classmethod
    @tracer.start_as_current_span("get_by_alias")
    def get_by_alias(cls, alias: str, dataset_name: str = None) -> DataClayObject:
        """Returns the object with the given alias.

        Args:
            alias: Alias of the object.
            dataset_name: Name of the dataset where the alias is stored. If None, the session's dataset is used.

        Returns:
            The object with the given alias.

        Raises:
            DoesNotExistError: If the alias does not exist.
            DatasetIsNotAccessibleError: If the dataset is not accessible.
        """
        return get_runtime().get_object_by_alias(alias, dataset_name)

    def add_alias(self, alias: str):
        """Adds an alias to the object.

        Args:
            alias: Alias to be added.

        Raises:
            ObjectNotRegisteredError: If the object is not registered.
            AttributeError: If the alias is an empty string.
            DataClayException: If the alias already exists.
        """
        get_runtime().add_alias(self, alias)

    def get_aliases(self) -> set[str]:
        """Returns a set with all the aliases of the object."""
        aliases = get_runtime().get_all_alias(self._dc_meta.dataset_name, self._dc_meta.id)
        return set(aliases)

    @classmethod
    @tracer.start_as_current_span("delete_alias")
    def delete_alias(cls, alias: str, dataset_name: str = None):
        """Removes the alias linked to an object.

        If this object is not referenced starting from a root object and no active session is
        accessing it, the garbage collector will remove it from the system.

        Args:
            alias: Alias to be removed.
            dataset_name: Name of the dataset where the alias is stored. If None, the session's dataset is used.

        Raises:
            DoesNotExistError: If the alias does not exist.
            DatasetIsNotAccessibleError: If the dataset is not accessible.
        """
        get_runtime().delete_alias(alias, dataset_name=dataset_name)

    @tracer.start_as_current_span("move")
    def move(self, backend_id: UUID, recursive: bool = False, remotes: bool = True):
        """Moves the object to the specified backend.

        If the object is not registered, it will be registered with all its references
        to the corresponding backend

        Args:
            backend_id: Id of the backend where the object will be moved.
            recursive: If True, all objects referenced by this object registered in the
                same backend will also be moved.
            remotes: If True (default), when recursive is True the remote references will
                also be moved. Otherwise only the local references are moved.

        Raises:
            KeyError: If the backend_id is not registered in dataClay.
        """
        if not self._dc_is_registered:
            self.make_persistent(backend_id=backend_id)
        else:
            get_runtime().send_objects([self], backend_id, False, recursive, remotes)

    ########################
    # Object Store Methods #
    ########################

    @classmethod
    @tracer.start_as_current_span("dc_clone_by_alias")
    def dc_clone_by_alias(cls, alias: str, recursive: bool = False) -> DataClayObject:
        """Returns a non-persistent object as a copy of the object with the alias specified.

        Fields referencing to other objects are kept as remote references to objects stored
        in dataClay, unless the recursive parameter is set to True.

        Args:
            alias: alias of the object to be retrieved.
            recursive:
                When this is set to True, the default behavior is altered so not only current
                object but all of its references are also retrieved locally.

        Returns:
            A new instance initialized with the field values of the object with the alias specified.

        Raises:
            DoesNotExistError: If the alias does not exist.
        """
        instance = cls.get_by_alias(alias)
        return get_runtime().make_object_copy(instance, recursive)

    @tracer.start_as_current_span("dc_clone")
    def dc_clone(self, recursive: bool = False) -> DataClayObject:
        """Returns a non-persistent object as a copy of the current object.

        Args:
            recursive: When this is set to True, the default behavior is altered so not only current
                object but all of its references are also retrieved locally.

        Returns:
            A new object instance initialized with the field values of the current object.

        Raises:
            ObjectNotRegisteredError: If the object is not registered.
        """
        return get_runtime().make_object_copy(self, recursive)

    @classmethod
    @tracer.start_as_current_span("dc_update_by_alias")
    def dc_update_by_alias(cls, alias: str, from_object: DataClayObject):
        """Updates the object identified by specified alias with contents of from_object.

        Args:
            alias: alias of the object to be updated.
            from_object: object with the new values to be updated.

        Raises:
            DoesNotExistError: If the alias does not exist.
            TypeError: If the objects are not of the same type.
        """
        if cls != type(from_object):
            raise TypeError("Objects must be of the same type")

        o = cls.get_by_alias(alias)
        o.dc_update(from_object)

    @tracer.start_as_current_span("dc_update")
    def dc_update(self, from_object: DataClayObject):
        """Updates current object with contents of from_object.

        Args:
            from_object: object with the new values to update current object.

        Raises:
            TypeError: If the objects are not of the same type.
        """
        if type(self) != type(from_object):
            raise TypeError("Objects must be of the same type")

        get_runtime().replace_object_properties(self, from_object)

    @tracer.start_as_current_span("dc_put")
    def dc_put(self, alias: str, backend_id: UUID = None):
        """Makes the object persistent in the specified backend.

        Args:
            alias: a string that will identify the object in addition to its OID.
                Aliases are unique for dataset.
            backend_id: the backend where the object will be stored. If this parameter is not
                specified, a random backend will be chosen.

        Raises:
            AttributeError: if alias is null or empty.
            AlreadyExistError: If the alias already exists.
            KeyError: If the backend_id is not registered in dataClay.
            ObjectAlreadyRegisteredError: If the object is already registered in dataClay.
        """
        if not alias:
            raise AttributeError("Alias cannot be null or empty")
        self.make_persistent(alias=alias, backend_id=backend_id)

    # Versioning

    @tracer.start_as_current_span("new_version")
    def new_version(self, backend_id: UUID = None, recursive: bool = False) -> DataClayObject:
        """Create a new version of the current object.

        Args:
            backend_id: the backend where the object will be stored. If this parameter is not
                specified, a random backend will be chosen.

        Returns:
            A new object instance initialized with the field values of the current object.

        Raises:
            ObjectNotRegisteredError: If the object is not registered in dataClay.
            KeyError: If the backend_id is not registered in dataClay.
        """
        return get_runtime().new_object_version(self, backend_id)

    @tracer.start_as_current_span("consolidate_version")
    def consolidate_version(self):
        """Consolidate the current version of the object with the original one."""
        get_runtime().consolidate_version(self)

    @tracer.start_as_current_span("getID")
    def getID(self) -> str | None:
        """Return the string representation of the persistent object for COMPSs.

        dataClay specific implementation: The objects are internally represented
        through ObjectID, which are UUID. In addition to that, some extra fields
        are added to the representation. Currently, a "COMPSs ID" will be:

            <objectID>:<backendID|empty>:<classID>

        In which all ID are UUID and the "hint" (backendID) can be empty.

        If the object is NOT persistent, then this method returns None.
        """
        if self._dc_is_registered:
            return "%s:%s:%s" % (
                self._dc_meta.id,
                self._dc_meta.master_backend_id,
                self._dc_meta.class_name,
            )
        else:
            return None

    ###########
    # Replica #
    ###########

    def new_replica(self, backend_id: UUID = None, recursive: bool = False, remotes: bool = True):
        get_runtime().new_object_replica(self, backend_id, recursive, remotes)

    ##############
    # Federation #
    ##############

    def federate_to_backend(self, ext_execution_env_id, recursive=True):
        get_runtime().federate_to_backend(self, ext_execution_env_id, recursive)

    def federate(self, ext_dataclay_id, recursive=True):
        get_runtime().federate_object(self, ext_dataclay_id, recursive)

    def unfederate_from_backend(self, ext_execution_env_id, recursive=True):
        get_runtime().unfederate_from_backend(self, ext_execution_env_id, recursive)

    def unfederate(self, ext_dataclay_id=None, recursive=True):
        # FIXME: unfederate only from specific ext dataClay
        get_runtime().unfederate_object(self, ext_dataclay_id, recursive)

    def synchronize(self, field_name, value):
        # from dataclay.DataClayObjProperties import DCLAY_SETTER_PREFIX
        raise ("Synchronize need refactor")
        return get_runtime().synchronize(self, DCLAY_SETTER_PREFIX + field_name, value)

    def session_detach(self):
        """
        Detach object from session, i.e. remove reference from current session provided to current object,
            'dear garbage-collector, the current session is not using this object anymore'
        """
        get_runtime().detach_object_from_session(self._dc_meta.id, self._dc_meta.master_backend_id)

    def __repr__(self):
        if self._dc_is_registered:
            return "<%s instance with ObjectID=%s>" % (
                self._dc_meta.class_name,
                self._dc_meta.id,
            )
        else:
            return "<%s volatile instance with ObjectID=%s>" % (
                self._dc_meta.class_name,
                self._dc_meta.id,
            )

    def __eq__(self, other):
        if not isinstance(other, DataClayObject):
            return False

        if not self._dc_is_registered or not other._dc_is_registered:
            return False

        return self._dc_meta.id == other._dc_meta.id

    # FIXME: Think another solution, the user may want to override the method
    def __hash__(self):
        return hash(self._dc_meta.id)

    @activemethod
    def __setUpdate__(
        self, obj: "Any", property_name: str, value: "Any", beforeUpdate: str, afterUpdate: str
    ):
        if beforeUpdate is not None:
            getattr(self, beforeUpdate)(property_name, value)
        object.__setattr__(obj, "%s%s" % ("_dataclay_property_", property_name), value)
        if afterUpdate is not None:
            getattr(self, afterUpdate)(property_name, value)

    def __copy__(self):
        # NOTE: A shallow copy cannot be performed, or has no sense.
        return self
