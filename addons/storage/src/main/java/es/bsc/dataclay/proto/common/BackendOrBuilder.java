// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dataclay/proto/common/common.proto

package es.bsc.dataclay.proto.common;

public interface BackendOrBuilder extends
    // @@protoc_insertion_point(interface_extends:dataclay.proto.common.Backend)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>string host = 2;</code>
   * @return The host.
   */
  java.lang.String getHost();
  /**
   * <code>string host = 2;</code>
   * @return The bytes for host.
   */
  com.google.protobuf.ByteString
      getHostBytes();

  /**
   * <code>int32 port = 3;</code>
   * @return The port.
   */
  int getPort();

  /**
   * <code>string dataclay_id = 4;</code>
   * @return The dataclayId.
   */
  java.lang.String getDataclayId();
  /**
   * <code>string dataclay_id = 4;</code>
   * @return The bytes for dataclayId.
   */
  com.google.protobuf.ByteString
      getDataclayIdBytes();
}
