// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dataclay/proto/metadata/metadata.proto

package es.bsc.dataclay.proto.metadata;

/**
 * Protobuf type {@code dataclay.proto.metadata.NewAliasRequest}
 */
public final class NewAliasRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dataclay.proto.metadata.NewAliasRequest)
    NewAliasRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NewAliasRequest.newBuilder() to construct.
  private NewAliasRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NewAliasRequest() {
    sessionId_ = "";
    aliasName_ = "";
    datasetName_ = "";
    objectId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new NewAliasRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return es.bsc.dataclay.proto.metadata.Metadata.internal_static_dataclay_proto_metadata_NewAliasRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return es.bsc.dataclay.proto.metadata.Metadata.internal_static_dataclay_proto_metadata_NewAliasRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            es.bsc.dataclay.proto.metadata.NewAliasRequest.class, es.bsc.dataclay.proto.metadata.NewAliasRequest.Builder.class);
  }

  public static final int SESSION_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object sessionId_ = "";
  /**
   * <code>string session_id = 1;</code>
   * @return The sessionId.
   */
  @java.lang.Override
  public java.lang.String getSessionId() {
    java.lang.Object ref = sessionId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      sessionId_ = s;
      return s;
    }
  }
  /**
   * <code>string session_id = 1;</code>
   * @return The bytes for sessionId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSessionIdBytes() {
    java.lang.Object ref = sessionId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      sessionId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ALIAS_NAME_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object aliasName_ = "";
  /**
   * <code>string alias_name = 2;</code>
   * @return The aliasName.
   */
  @java.lang.Override
  public java.lang.String getAliasName() {
    java.lang.Object ref = aliasName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      aliasName_ = s;
      return s;
    }
  }
  /**
   * <code>string alias_name = 2;</code>
   * @return The bytes for aliasName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAliasNameBytes() {
    java.lang.Object ref = aliasName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      aliasName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DATASET_NAME_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object datasetName_ = "";
  /**
   * <code>string dataset_name = 3;</code>
   * @return The datasetName.
   */
  @java.lang.Override
  public java.lang.String getDatasetName() {
    java.lang.Object ref = datasetName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      datasetName_ = s;
      return s;
    }
  }
  /**
   * <code>string dataset_name = 3;</code>
   * @return The bytes for datasetName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDatasetNameBytes() {
    java.lang.Object ref = datasetName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      datasetName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OBJECT_ID_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile java.lang.Object objectId_ = "";
  /**
   * <code>string object_id = 4;</code>
   * @return The objectId.
   */
  @java.lang.Override
  public java.lang.String getObjectId() {
    java.lang.Object ref = objectId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      objectId_ = s;
      return s;
    }
  }
  /**
   * <code>string object_id = 4;</code>
   * @return The bytes for objectId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getObjectIdBytes() {
    java.lang.Object ref = objectId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      objectId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(sessionId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, sessionId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(aliasName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, aliasName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(datasetName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, datasetName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(objectId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, objectId_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(sessionId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, sessionId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(aliasName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, aliasName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(datasetName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, datasetName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(objectId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, objectId_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof es.bsc.dataclay.proto.metadata.NewAliasRequest)) {
      return super.equals(obj);
    }
    es.bsc.dataclay.proto.metadata.NewAliasRequest other = (es.bsc.dataclay.proto.metadata.NewAliasRequest) obj;

    if (!getSessionId()
        .equals(other.getSessionId())) return false;
    if (!getAliasName()
        .equals(other.getAliasName())) return false;
    if (!getDatasetName()
        .equals(other.getDatasetName())) return false;
    if (!getObjectId()
        .equals(other.getObjectId())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SESSION_ID_FIELD_NUMBER;
    hash = (53 * hash) + getSessionId().hashCode();
    hash = (37 * hash) + ALIAS_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getAliasName().hashCode();
    hash = (37 * hash) + DATASET_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getDatasetName().hashCode();
    hash = (37 * hash) + OBJECT_ID_FIELD_NUMBER;
    hash = (53 * hash) + getObjectId().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static es.bsc.dataclay.proto.metadata.NewAliasRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static es.bsc.dataclay.proto.metadata.NewAliasRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static es.bsc.dataclay.proto.metadata.NewAliasRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static es.bsc.dataclay.proto.metadata.NewAliasRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static es.bsc.dataclay.proto.metadata.NewAliasRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static es.bsc.dataclay.proto.metadata.NewAliasRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static es.bsc.dataclay.proto.metadata.NewAliasRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static es.bsc.dataclay.proto.metadata.NewAliasRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static es.bsc.dataclay.proto.metadata.NewAliasRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static es.bsc.dataclay.proto.metadata.NewAliasRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static es.bsc.dataclay.proto.metadata.NewAliasRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static es.bsc.dataclay.proto.metadata.NewAliasRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(es.bsc.dataclay.proto.metadata.NewAliasRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code dataclay.proto.metadata.NewAliasRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dataclay.proto.metadata.NewAliasRequest)
      es.bsc.dataclay.proto.metadata.NewAliasRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return es.bsc.dataclay.proto.metadata.Metadata.internal_static_dataclay_proto_metadata_NewAliasRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return es.bsc.dataclay.proto.metadata.Metadata.internal_static_dataclay_proto_metadata_NewAliasRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              es.bsc.dataclay.proto.metadata.NewAliasRequest.class, es.bsc.dataclay.proto.metadata.NewAliasRequest.Builder.class);
    }

    // Construct using es.bsc.dataclay.proto.metadata.NewAliasRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      sessionId_ = "";
      aliasName_ = "";
      datasetName_ = "";
      objectId_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return es.bsc.dataclay.proto.metadata.Metadata.internal_static_dataclay_proto_metadata_NewAliasRequest_descriptor;
    }

    @java.lang.Override
    public es.bsc.dataclay.proto.metadata.NewAliasRequest getDefaultInstanceForType() {
      return es.bsc.dataclay.proto.metadata.NewAliasRequest.getDefaultInstance();
    }

    @java.lang.Override
    public es.bsc.dataclay.proto.metadata.NewAliasRequest build() {
      es.bsc.dataclay.proto.metadata.NewAliasRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public es.bsc.dataclay.proto.metadata.NewAliasRequest buildPartial() {
      es.bsc.dataclay.proto.metadata.NewAliasRequest result = new es.bsc.dataclay.proto.metadata.NewAliasRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(es.bsc.dataclay.proto.metadata.NewAliasRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.sessionId_ = sessionId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.aliasName_ = aliasName_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.datasetName_ = datasetName_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.objectId_ = objectId_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof es.bsc.dataclay.proto.metadata.NewAliasRequest) {
        return mergeFrom((es.bsc.dataclay.proto.metadata.NewAliasRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(es.bsc.dataclay.proto.metadata.NewAliasRequest other) {
      if (other == es.bsc.dataclay.proto.metadata.NewAliasRequest.getDefaultInstance()) return this;
      if (!other.getSessionId().isEmpty()) {
        sessionId_ = other.sessionId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getAliasName().isEmpty()) {
        aliasName_ = other.aliasName_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getDatasetName().isEmpty()) {
        datasetName_ = other.datasetName_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (!other.getObjectId().isEmpty()) {
        objectId_ = other.objectId_;
        bitField0_ |= 0x00000008;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              sessionId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              aliasName_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              datasetName_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 34: {
              objectId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000008;
              break;
            } // case 34
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object sessionId_ = "";
    /**
     * <code>string session_id = 1;</code>
     * @return The sessionId.
     */
    public java.lang.String getSessionId() {
      java.lang.Object ref = sessionId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        sessionId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string session_id = 1;</code>
     * @return The bytes for sessionId.
     */
    public com.google.protobuf.ByteString
        getSessionIdBytes() {
      java.lang.Object ref = sessionId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        sessionId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string session_id = 1;</code>
     * @param value The sessionId to set.
     * @return This builder for chaining.
     */
    public Builder setSessionId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      sessionId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string session_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSessionId() {
      sessionId_ = getDefaultInstance().getSessionId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string session_id = 1;</code>
     * @param value The bytes for sessionId to set.
     * @return This builder for chaining.
     */
    public Builder setSessionIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      sessionId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object aliasName_ = "";
    /**
     * <code>string alias_name = 2;</code>
     * @return The aliasName.
     */
    public java.lang.String getAliasName() {
      java.lang.Object ref = aliasName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        aliasName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string alias_name = 2;</code>
     * @return The bytes for aliasName.
     */
    public com.google.protobuf.ByteString
        getAliasNameBytes() {
      java.lang.Object ref = aliasName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        aliasName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string alias_name = 2;</code>
     * @param value The aliasName to set.
     * @return This builder for chaining.
     */
    public Builder setAliasName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      aliasName_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string alias_name = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAliasName() {
      aliasName_ = getDefaultInstance().getAliasName();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string alias_name = 2;</code>
     * @param value The bytes for aliasName to set.
     * @return This builder for chaining.
     */
    public Builder setAliasNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      aliasName_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object datasetName_ = "";
    /**
     * <code>string dataset_name = 3;</code>
     * @return The datasetName.
     */
    public java.lang.String getDatasetName() {
      java.lang.Object ref = datasetName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        datasetName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string dataset_name = 3;</code>
     * @return The bytes for datasetName.
     */
    public com.google.protobuf.ByteString
        getDatasetNameBytes() {
      java.lang.Object ref = datasetName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        datasetName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string dataset_name = 3;</code>
     * @param value The datasetName to set.
     * @return This builder for chaining.
     */
    public Builder setDatasetName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      datasetName_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string dataset_name = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearDatasetName() {
      datasetName_ = getDefaultInstance().getDatasetName();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string dataset_name = 3;</code>
     * @param value The bytes for datasetName to set.
     * @return This builder for chaining.
     */
    public Builder setDatasetNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      datasetName_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private java.lang.Object objectId_ = "";
    /**
     * <code>string object_id = 4;</code>
     * @return The objectId.
     */
    public java.lang.String getObjectId() {
      java.lang.Object ref = objectId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        objectId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string object_id = 4;</code>
     * @return The bytes for objectId.
     */
    public com.google.protobuf.ByteString
        getObjectIdBytes() {
      java.lang.Object ref = objectId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        objectId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string object_id = 4;</code>
     * @param value The objectId to set.
     * @return This builder for chaining.
     */
    public Builder setObjectId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      objectId_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>string object_id = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearObjectId() {
      objectId_ = getDefaultInstance().getObjectId();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>string object_id = 4;</code>
     * @param value The bytes for objectId to set.
     * @return This builder for chaining.
     */
    public Builder setObjectIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      objectId_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:dataclay.proto.metadata.NewAliasRequest)
  }

  // @@protoc_insertion_point(class_scope:dataclay.proto.metadata.NewAliasRequest)
  private static final es.bsc.dataclay.proto.metadata.NewAliasRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new es.bsc.dataclay.proto.metadata.NewAliasRequest();
  }

  public static es.bsc.dataclay.proto.metadata.NewAliasRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NewAliasRequest>
      PARSER = new com.google.protobuf.AbstractParser<NewAliasRequest>() {
    @java.lang.Override
    public NewAliasRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<NewAliasRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NewAliasRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public es.bsc.dataclay.proto.metadata.NewAliasRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

