// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dataclay/proto/backend/backend.proto

package es.bsc.dataclay.proto.backend;

public interface MoveObjectRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:dataclay.proto.backend.MoveObjectRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string object_id = 1;</code>
   * @return The objectId.
   */
  java.lang.String getObjectId();
  /**
   * <code>string object_id = 1;</code>
   * @return The bytes for objectId.
   */
  com.google.protobuf.ByteString
      getObjectIdBytes();

  /**
   * <code>string backend_id = 2;</code>
   * @return The backendId.
   */
  java.lang.String getBackendId();
  /**
   * <code>string backend_id = 2;</code>
   * @return The bytes for backendId.
   */
  com.google.protobuf.ByteString
      getBackendIdBytes();

  /**
   * <code>bool recursive = 3;</code>
   * @return The recursive.
   */
  boolean getRecursive();
}
