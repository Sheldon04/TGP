// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: my_proto.proto

package com.service;

/**
 * Protobuf type {@code UserRecommendReply}
 */
public final class UserRecommendReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:UserRecommendReply)
    UserRecommendReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UserRecommendReply.newBuilder() to construct.
  private UserRecommendReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserRecommendReply() {
    mid_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UserRecommendReply();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UserRecommendReply(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              mid_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            mid_.add(s);
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        mid_ = mid_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.service.MyProto.internal_static_UserRecommendReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.service.MyProto.internal_static_UserRecommendReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.service.UserRecommendReply.class, com.service.UserRecommendReply.Builder.class);
  }

  public static final int MID_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList mid_;
  /**
   * <code>repeated string mid = 1;</code>
   * @return A list containing the mid.
   */
  public com.google.protobuf.ProtocolStringList
      getMidList() {
    return mid_;
  }
  /**
   * <code>repeated string mid = 1;</code>
   * @return The count of mid.
   */
  public int getMidCount() {
    return mid_.size();
  }
  /**
   * <code>repeated string mid = 1;</code>
   * @param index The index of the element to return.
   * @return The mid at the given index.
   */
  public java.lang.String getMid(int index) {
    return mid_.get(index);
  }
  /**
   * <code>repeated string mid = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the mid at the given index.
   */
  public com.google.protobuf.ByteString
      getMidBytes(int index) {
    return mid_.getByteString(index);
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
    for (int i = 0; i < mid_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, mid_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < mid_.size(); i++) {
        dataSize += computeStringSizeNoTag(mid_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getMidList().size();
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.service.UserRecommendReply)) {
      return super.equals(obj);
    }
    com.service.UserRecommendReply other = (com.service.UserRecommendReply) obj;

    if (!getMidList()
        .equals(other.getMidList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getMidCount() > 0) {
      hash = (37 * hash) + MID_FIELD_NUMBER;
      hash = (53 * hash) + getMidList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.service.UserRecommendReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.service.UserRecommendReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.service.UserRecommendReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.service.UserRecommendReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.service.UserRecommendReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.service.UserRecommendReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.service.UserRecommendReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.service.UserRecommendReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.service.UserRecommendReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.service.UserRecommendReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.service.UserRecommendReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.service.UserRecommendReply parseFrom(
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
  public static Builder newBuilder(com.service.UserRecommendReply prototype) {
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
   * Protobuf type {@code UserRecommendReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:UserRecommendReply)
      com.service.UserRecommendReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.service.MyProto.internal_static_UserRecommendReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.service.MyProto.internal_static_UserRecommendReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.service.UserRecommendReply.class, com.service.UserRecommendReply.Builder.class);
    }

    // Construct using com.service.UserRecommendReply.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      mid_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.service.MyProto.internal_static_UserRecommendReply_descriptor;
    }

    @java.lang.Override
    public com.service.UserRecommendReply getDefaultInstanceForType() {
      return com.service.UserRecommendReply.getDefaultInstance();
    }

    @java.lang.Override
    public com.service.UserRecommendReply build() {
      com.service.UserRecommendReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.service.UserRecommendReply buildPartial() {
      com.service.UserRecommendReply result = new com.service.UserRecommendReply(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        mid_ = mid_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.mid_ = mid_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.service.UserRecommendReply) {
        return mergeFrom((com.service.UserRecommendReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.service.UserRecommendReply other) {
      if (other == com.service.UserRecommendReply.getDefaultInstance()) return this;
      if (!other.mid_.isEmpty()) {
        if (mid_.isEmpty()) {
          mid_ = other.mid_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureMidIsMutable();
          mid_.addAll(other.mid_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
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
      com.service.UserRecommendReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.service.UserRecommendReply) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList mid_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureMidIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        mid_ = new com.google.protobuf.LazyStringArrayList(mid_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string mid = 1;</code>
     * @return A list containing the mid.
     */
    public com.google.protobuf.ProtocolStringList
        getMidList() {
      return mid_.getUnmodifiableView();
    }
    /**
     * <code>repeated string mid = 1;</code>
     * @return The count of mid.
     */
    public int getMidCount() {
      return mid_.size();
    }
    /**
     * <code>repeated string mid = 1;</code>
     * @param index The index of the element to return.
     * @return The mid at the given index.
     */
    public java.lang.String getMid(int index) {
      return mid_.get(index);
    }
    /**
     * <code>repeated string mid = 1;</code>
     * @param index The index of the value to return.
     * @return The bytes of the mid at the given index.
     */
    public com.google.protobuf.ByteString
        getMidBytes(int index) {
      return mid_.getByteString(index);
    }
    /**
     * <code>repeated string mid = 1;</code>
     * @param index The index to set the value at.
     * @param value The mid to set.
     * @return This builder for chaining.
     */
    public Builder setMid(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureMidIsMutable();
      mid_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string mid = 1;</code>
     * @param value The mid to add.
     * @return This builder for chaining.
     */
    public Builder addMid(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureMidIsMutable();
      mid_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string mid = 1;</code>
     * @param values The mid to add.
     * @return This builder for chaining.
     */
    public Builder addAllMid(
        java.lang.Iterable<java.lang.String> values) {
      ensureMidIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, mid_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string mid = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMid() {
      mid_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string mid = 1;</code>
     * @param value The bytes of the mid to add.
     * @return This builder for chaining.
     */
    public Builder addMidBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureMidIsMutable();
      mid_.add(value);
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


    // @@protoc_insertion_point(builder_scope:UserRecommendReply)
  }

  // @@protoc_insertion_point(class_scope:UserRecommendReply)
  private static final com.service.UserRecommendReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.service.UserRecommendReply();
  }

  public static com.service.UserRecommendReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserRecommendReply>
      PARSER = new com.google.protobuf.AbstractParser<UserRecommendReply>() {
    @java.lang.Override
    public UserRecommendReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UserRecommendReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UserRecommendReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UserRecommendReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.service.UserRecommendReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
