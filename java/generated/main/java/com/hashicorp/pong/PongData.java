// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api.proto

package com.hashicorp.pong;

/**
 * Protobuf type {@code pong.PongData}
 */
public  final class PongData extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:pong.PongData)
    PongDataOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PongData.newBuilder() to construct.
  private PongData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PongData() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PongData();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PongData(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
            com.hashicorp.pong.Bat.Builder subBuilder = null;
            if (bat_ != null) {
              subBuilder = bat_.toBuilder();
            }
            bat_ = input.readMessage(com.hashicorp.pong.Bat.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(bat_);
              bat_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            com.hashicorp.pong.Ball.Builder subBuilder = null;
            if (ball_ != null) {
              subBuilder = ball_.toBuilder();
            }
            ball_ = input.readMessage(com.hashicorp.pong.Ball.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(ball_);
              ball_ = subBuilder.buildPartial();
            }

            break;
          }
          case 24: {

            hit_ = input.readBool();
            break;
          }
          case 32: {

            score_ = input.readInt32();
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.hashicorp.pong.Api.internal_static_pong_PongData_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.hashicorp.pong.Api.internal_static_pong_PongData_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.hashicorp.pong.PongData.class, com.hashicorp.pong.PongData.Builder.class);
  }

  public static final int BAT_FIELD_NUMBER = 1;
  private com.hashicorp.pong.Bat bat_;
  /**
   * <code>.pong.Bat bat = 1;</code>
   */
  public boolean hasBat() {
    return bat_ != null;
  }
  /**
   * <code>.pong.Bat bat = 1;</code>
   */
  public com.hashicorp.pong.Bat getBat() {
    return bat_ == null ? com.hashicorp.pong.Bat.getDefaultInstance() : bat_;
  }
  /**
   * <code>.pong.Bat bat = 1;</code>
   */
  public com.hashicorp.pong.BatOrBuilder getBatOrBuilder() {
    return getBat();
  }

  public static final int BALL_FIELD_NUMBER = 2;
  private com.hashicorp.pong.Ball ball_;
  /**
   * <code>.pong.Ball ball = 2;</code>
   */
  public boolean hasBall() {
    return ball_ != null;
  }
  /**
   * <code>.pong.Ball ball = 2;</code>
   */
  public com.hashicorp.pong.Ball getBall() {
    return ball_ == null ? com.hashicorp.pong.Ball.getDefaultInstance() : ball_;
  }
  /**
   * <code>.pong.Ball ball = 2;</code>
   */
  public com.hashicorp.pong.BallOrBuilder getBallOrBuilder() {
    return getBall();
  }

  public static final int HIT_FIELD_NUMBER = 3;
  private boolean hit_;
  /**
   * <code>bool hit = 3;</code>
   */
  public boolean getHit() {
    return hit_;
  }

  public static final int SCORE_FIELD_NUMBER = 4;
  private int score_;
  /**
   * <code>int32 score = 4;</code>
   */
  public int getScore() {
    return score_;
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
    if (bat_ != null) {
      output.writeMessage(1, getBat());
    }
    if (ball_ != null) {
      output.writeMessage(2, getBall());
    }
    if (hit_ != false) {
      output.writeBool(3, hit_);
    }
    if (score_ != 0) {
      output.writeInt32(4, score_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (bat_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getBat());
    }
    if (ball_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getBall());
    }
    if (hit_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, hit_);
    }
    if (score_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, score_);
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
    if (!(obj instanceof com.hashicorp.pong.PongData)) {
      return super.equals(obj);
    }
    com.hashicorp.pong.PongData other = (com.hashicorp.pong.PongData) obj;

    if (hasBat() != other.hasBat()) return false;
    if (hasBat()) {
      if (!getBat()
          .equals(other.getBat())) return false;
    }
    if (hasBall() != other.hasBall()) return false;
    if (hasBall()) {
      if (!getBall()
          .equals(other.getBall())) return false;
    }
    if (getHit()
        != other.getHit()) return false;
    if (getScore()
        != other.getScore()) return false;
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
    if (hasBat()) {
      hash = (37 * hash) + BAT_FIELD_NUMBER;
      hash = (53 * hash) + getBat().hashCode();
    }
    if (hasBall()) {
      hash = (37 * hash) + BALL_FIELD_NUMBER;
      hash = (53 * hash) + getBall().hashCode();
    }
    hash = (37 * hash) + HIT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getHit());
    hash = (37 * hash) + SCORE_FIELD_NUMBER;
    hash = (53 * hash) + getScore();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.hashicorp.pong.PongData parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.hashicorp.pong.PongData parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.hashicorp.pong.PongData parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.hashicorp.pong.PongData parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.hashicorp.pong.PongData parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.hashicorp.pong.PongData parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.hashicorp.pong.PongData parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.hashicorp.pong.PongData parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.hashicorp.pong.PongData parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.hashicorp.pong.PongData parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.hashicorp.pong.PongData parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.hashicorp.pong.PongData parseFrom(
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
  public static Builder newBuilder(com.hashicorp.pong.PongData prototype) {
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
   * Protobuf type {@code pong.PongData}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:pong.PongData)
      com.hashicorp.pong.PongDataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.hashicorp.pong.Api.internal_static_pong_PongData_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.hashicorp.pong.Api.internal_static_pong_PongData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.hashicorp.pong.PongData.class, com.hashicorp.pong.PongData.Builder.class);
    }

    // Construct using com.hashicorp.pong.PongData.newBuilder()
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
      if (batBuilder_ == null) {
        bat_ = null;
      } else {
        bat_ = null;
        batBuilder_ = null;
      }
      if (ballBuilder_ == null) {
        ball_ = null;
      } else {
        ball_ = null;
        ballBuilder_ = null;
      }
      hit_ = false;

      score_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.hashicorp.pong.Api.internal_static_pong_PongData_descriptor;
    }

    @java.lang.Override
    public com.hashicorp.pong.PongData getDefaultInstanceForType() {
      return com.hashicorp.pong.PongData.getDefaultInstance();
    }

    @java.lang.Override
    public com.hashicorp.pong.PongData build() {
      com.hashicorp.pong.PongData result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.hashicorp.pong.PongData buildPartial() {
      com.hashicorp.pong.PongData result = new com.hashicorp.pong.PongData(this);
      if (batBuilder_ == null) {
        result.bat_ = bat_;
      } else {
        result.bat_ = batBuilder_.build();
      }
      if (ballBuilder_ == null) {
        result.ball_ = ball_;
      } else {
        result.ball_ = ballBuilder_.build();
      }
      result.hit_ = hit_;
      result.score_ = score_;
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
      if (other instanceof com.hashicorp.pong.PongData) {
        return mergeFrom((com.hashicorp.pong.PongData)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.hashicorp.pong.PongData other) {
      if (other == com.hashicorp.pong.PongData.getDefaultInstance()) return this;
      if (other.hasBat()) {
        mergeBat(other.getBat());
      }
      if (other.hasBall()) {
        mergeBall(other.getBall());
      }
      if (other.getHit() != false) {
        setHit(other.getHit());
      }
      if (other.getScore() != 0) {
        setScore(other.getScore());
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
      com.hashicorp.pong.PongData parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.hashicorp.pong.PongData) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.hashicorp.pong.Bat bat_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.hashicorp.pong.Bat, com.hashicorp.pong.Bat.Builder, com.hashicorp.pong.BatOrBuilder> batBuilder_;
    /**
     * <code>.pong.Bat bat = 1;</code>
     */
    public boolean hasBat() {
      return batBuilder_ != null || bat_ != null;
    }
    /**
     * <code>.pong.Bat bat = 1;</code>
     */
    public com.hashicorp.pong.Bat getBat() {
      if (batBuilder_ == null) {
        return bat_ == null ? com.hashicorp.pong.Bat.getDefaultInstance() : bat_;
      } else {
        return batBuilder_.getMessage();
      }
    }
    /**
     * <code>.pong.Bat bat = 1;</code>
     */
    public Builder setBat(com.hashicorp.pong.Bat value) {
      if (batBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        bat_ = value;
        onChanged();
      } else {
        batBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.pong.Bat bat = 1;</code>
     */
    public Builder setBat(
        com.hashicorp.pong.Bat.Builder builderForValue) {
      if (batBuilder_ == null) {
        bat_ = builderForValue.build();
        onChanged();
      } else {
        batBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.pong.Bat bat = 1;</code>
     */
    public Builder mergeBat(com.hashicorp.pong.Bat value) {
      if (batBuilder_ == null) {
        if (bat_ != null) {
          bat_ =
            com.hashicorp.pong.Bat.newBuilder(bat_).mergeFrom(value).buildPartial();
        } else {
          bat_ = value;
        }
        onChanged();
      } else {
        batBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.pong.Bat bat = 1;</code>
     */
    public Builder clearBat() {
      if (batBuilder_ == null) {
        bat_ = null;
        onChanged();
      } else {
        bat_ = null;
        batBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.pong.Bat bat = 1;</code>
     */
    public com.hashicorp.pong.Bat.Builder getBatBuilder() {
      
      onChanged();
      return getBatFieldBuilder().getBuilder();
    }
    /**
     * <code>.pong.Bat bat = 1;</code>
     */
    public com.hashicorp.pong.BatOrBuilder getBatOrBuilder() {
      if (batBuilder_ != null) {
        return batBuilder_.getMessageOrBuilder();
      } else {
        return bat_ == null ?
            com.hashicorp.pong.Bat.getDefaultInstance() : bat_;
      }
    }
    /**
     * <code>.pong.Bat bat = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.hashicorp.pong.Bat, com.hashicorp.pong.Bat.Builder, com.hashicorp.pong.BatOrBuilder> 
        getBatFieldBuilder() {
      if (batBuilder_ == null) {
        batBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.hashicorp.pong.Bat, com.hashicorp.pong.Bat.Builder, com.hashicorp.pong.BatOrBuilder>(
                getBat(),
                getParentForChildren(),
                isClean());
        bat_ = null;
      }
      return batBuilder_;
    }

    private com.hashicorp.pong.Ball ball_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.hashicorp.pong.Ball, com.hashicorp.pong.Ball.Builder, com.hashicorp.pong.BallOrBuilder> ballBuilder_;
    /**
     * <code>.pong.Ball ball = 2;</code>
     */
    public boolean hasBall() {
      return ballBuilder_ != null || ball_ != null;
    }
    /**
     * <code>.pong.Ball ball = 2;</code>
     */
    public com.hashicorp.pong.Ball getBall() {
      if (ballBuilder_ == null) {
        return ball_ == null ? com.hashicorp.pong.Ball.getDefaultInstance() : ball_;
      } else {
        return ballBuilder_.getMessage();
      }
    }
    /**
     * <code>.pong.Ball ball = 2;</code>
     */
    public Builder setBall(com.hashicorp.pong.Ball value) {
      if (ballBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ball_ = value;
        onChanged();
      } else {
        ballBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.pong.Ball ball = 2;</code>
     */
    public Builder setBall(
        com.hashicorp.pong.Ball.Builder builderForValue) {
      if (ballBuilder_ == null) {
        ball_ = builderForValue.build();
        onChanged();
      } else {
        ballBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.pong.Ball ball = 2;</code>
     */
    public Builder mergeBall(com.hashicorp.pong.Ball value) {
      if (ballBuilder_ == null) {
        if (ball_ != null) {
          ball_ =
            com.hashicorp.pong.Ball.newBuilder(ball_).mergeFrom(value).buildPartial();
        } else {
          ball_ = value;
        }
        onChanged();
      } else {
        ballBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.pong.Ball ball = 2;</code>
     */
    public Builder clearBall() {
      if (ballBuilder_ == null) {
        ball_ = null;
        onChanged();
      } else {
        ball_ = null;
        ballBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.pong.Ball ball = 2;</code>
     */
    public com.hashicorp.pong.Ball.Builder getBallBuilder() {
      
      onChanged();
      return getBallFieldBuilder().getBuilder();
    }
    /**
     * <code>.pong.Ball ball = 2;</code>
     */
    public com.hashicorp.pong.BallOrBuilder getBallOrBuilder() {
      if (ballBuilder_ != null) {
        return ballBuilder_.getMessageOrBuilder();
      } else {
        return ball_ == null ?
            com.hashicorp.pong.Ball.getDefaultInstance() : ball_;
      }
    }
    /**
     * <code>.pong.Ball ball = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.hashicorp.pong.Ball, com.hashicorp.pong.Ball.Builder, com.hashicorp.pong.BallOrBuilder> 
        getBallFieldBuilder() {
      if (ballBuilder_ == null) {
        ballBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.hashicorp.pong.Ball, com.hashicorp.pong.Ball.Builder, com.hashicorp.pong.BallOrBuilder>(
                getBall(),
                getParentForChildren(),
                isClean());
        ball_ = null;
      }
      return ballBuilder_;
    }

    private boolean hit_ ;
    /**
     * <code>bool hit = 3;</code>
     */
    public boolean getHit() {
      return hit_;
    }
    /**
     * <code>bool hit = 3;</code>
     */
    public Builder setHit(boolean value) {
      
      hit_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool hit = 3;</code>
     */
    public Builder clearHit() {
      
      hit_ = false;
      onChanged();
      return this;
    }

    private int score_ ;
    /**
     * <code>int32 score = 4;</code>
     */
    public int getScore() {
      return score_;
    }
    /**
     * <code>int32 score = 4;</code>
     */
    public Builder setScore(int value) {
      
      score_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 score = 4;</code>
     */
    public Builder clearScore() {
      
      score_ = 0;
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


    // @@protoc_insertion_point(builder_scope:pong.PongData)
  }

  // @@protoc_insertion_point(class_scope:pong.PongData)
  private static final com.hashicorp.pong.PongData DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.hashicorp.pong.PongData();
  }

  public static com.hashicorp.pong.PongData getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PongData>
      PARSER = new com.google.protobuf.AbstractParser<PongData>() {
    @java.lang.Override
    public PongData parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PongData(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PongData> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PongData> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.hashicorp.pong.PongData getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

