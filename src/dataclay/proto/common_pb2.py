# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: proto/common.proto
"""Generated protocol buffer code."""
from google.protobuf.internal import builder as _builder
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x12proto/common.proto\x12\x0cproto.common\"J\n\x07\x42\x61\x63kend\x12\n\n\x02id\x18\x01 \x01(\t\x12\x10\n\x08hostname\x18\x02 \x01(\t\x12\x0c\n\x04port\x18\x03 \x01(\x05\x12\x13\n\x0b\x64\x61taclay_id\x18\x04 \x01(\t\"\xc6\x01\n\x0eObjectMetadata\x12\n\n\x02id\x18\x01 \x01(\t\x12\x14\n\x0c\x64\x61taset_name\x18\x02 \x01(\t\x12\x12\n\nclass_name\x18\x03 \x01(\t\x12\x12\n\nbackend_id\x18\x04 \x01(\t\x12\x1b\n\x13replica_backend_ids\x18\x05 \x03(\t\x12\x14\n\x0cis_read_only\x18\x06 \x01(\x08\x12\x1a\n\x12original_object_id\x18\x07 \x01(\t\x12\x1b\n\x13versions_object_ids\x18\x08 \x03(\t\"P\n\x07Session\x12\n\n\x02id\x18\x01 \x01(\t\x12\x10\n\x08username\x18\x02 \x01(\t\x12\x14\n\x0c\x64\x61taset_name\x18\x03 \x01(\t\x12\x11\n\tis_active\x18\x04 \x01(\x08\"G\n\x08\x44\x61taclay\x12\n\n\x02id\x18\x01 \x01(\t\x12\x10\n\x08hostname\x18\x02 \x01(\t\x12\x0c\n\x04port\x18\x03 \x01(\x05\x12\x0f\n\x07is_this\x18\x04 \x01(\x08\">\n\x05\x41lias\x12\x0c\n\x04name\x18\x01 \x01(\t\x12\x14\n\x0c\x64\x61taset_name\x18\x02 \x01(\t\x12\x11\n\tobject_id\x18\x03 \x01(\tb\x06proto3')

_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, globals())
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'proto.common_pb2', globals())
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  _BACKEND._serialized_start=36
  _BACKEND._serialized_end=110
  _OBJECTMETADATA._serialized_start=113
  _OBJECTMETADATA._serialized_end=311
  _SESSION._serialized_start=313
  _SESSION._serialized_end=393
  _DATACLAY._serialized_start=395
  _DATACLAY._serialized_end=466
  _ALIAS._serialized_start=468
  _ALIAS._serialized_end=530
# @@protoc_insertion_point(module_scope)
