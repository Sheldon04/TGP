// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: my_proto.proto

package com.service;

public interface UserProfileReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:UserProfileReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string uid = 1;</code>
   * @return The uid.
   */
  java.lang.String getUid();
  /**
   * <code>string uid = 1;</code>
   * @return The bytes for uid.
   */
  com.google.protobuf.ByteString
      getUidBytes();

  /**
   * <code>repeated .UserProfileReply.Rating rating = 2;</code>
   */
  java.util.List<com.service.UserProfileReply.Rating> 
      getRatingList();
  /**
   * <code>repeated .UserProfileReply.Rating rating = 2;</code>
   */
  com.service.UserProfileReply.Rating getRating(int index);
  /**
   * <code>repeated .UserProfileReply.Rating rating = 2;</code>
   */
  int getRatingCount();
  /**
   * <code>repeated .UserProfileReply.Rating rating = 2;</code>
   */
  java.util.List<? extends com.service.UserProfileReply.RatingOrBuilder> 
      getRatingOrBuilderList();
  /**
   * <code>repeated .UserProfileReply.Rating rating = 2;</code>
   */
  com.service.UserProfileReply.RatingOrBuilder getRatingOrBuilder(
      int index);
}
