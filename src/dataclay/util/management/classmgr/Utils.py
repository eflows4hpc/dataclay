
""" Class description goes here. """

from itertools import starmap

from jinja2 import Template

from dataclay.serialization.python.lang.BooleanWrapper import BooleanWrapper
from dataclay.serialization.python.lang.FloatWrapper import FloatWrapper
from dataclay.serialization.python.lang.IntegerWrapper import IntegerWrapper
from dataclay.serialization.python.lang.NullWrapper import NullWrapper
from .Type import Type

NATIVE_PACKAGES = {
    'numpy',
    'caffe',
    'csv',
}

STATIC_ATTRIBUTE_FOR_EXTERNAL_INIT = 'DCLAY_FORCE_EXTERNAL_INIT'

# Static Template for the source code of the classes
py_code = Template("""
class {{ class_name }}({{ parent_name }}):
    \"\"\"Auto-generated code for class {{ metaclass.name }}

    This source code has been generated by the dataclay MetaClass container. There is
    some work ToDo yet.
    \"\"\"
{% for c in imp_codes %}
{{ c }}{% endfor %}
""")

stub_only_def = Template("""
    @dclayEmptyMethod
    def {{ func_name }}(
            self{% for param in param_names %}{% if loop.first %},{% endif %}
            {{ param }}{% if loop.last %}
    {% endif %}{% else %}
    {% endfor %}):
        raise NotImplementedError("Language Error: Method {{ func_name }} is not available for Python")
""")

# Note that the class_id of language types are null since "dataClay 2"
mapping_table = [
    (("int", int, IntegerWrapper(64)), Type(
        signature='J',
        includes=[],
    )),
    (("float", float, FloatWrapper(64)), Type(
        signature='D',
        includes=[],
    )),
    (("bool", bool, BooleanWrapper()), Type(
        signature='Z',
        includes=[],
    )),
    (("None", None, NullWrapper()), Type(
        signature='V',
        includes=[],
    )),
]

# Statically build the dictionaries for fast and easy lookup
docstring_types = dict(starmap(
    lambda what, type_c: (what[0], type_c),
    mapping_table))

instance_types = dict(starmap(
    lambda what, type_c: (what[1], type_c),
    mapping_table))

serialization_types = dict(starmap(
    lambda what, type_c: (type_c.signature, what[2]),
    mapping_table
))
