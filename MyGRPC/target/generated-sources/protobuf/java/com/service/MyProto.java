// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: my_proto.proto

package com.service;

public final class MyProto {
  private MyProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_HelloReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_HelloReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserProfileRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserProfileRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserProfileReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserProfileReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserProfileReply_Rating_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserProfileReply_Rating_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserRecommendRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserRecommendRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserRecommendReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserRecommendReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MovieProfileRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MovieProfileRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MovieProfileReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MovieProfileReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016my_proto.proto\"\034\n\014HelloRequest\022\014\n\004name" +
      "\030\001 \001(\t\"\035\n\nHelloReply\022\017\n\007message\030\001 \001(\t\" \n" +
      "\022UserProfileRequest\022\n\n\002id\030\001 \001(\t\"\203\001\n\020User" +
      "ProfileReply\022\013\n\003uid\030\001 \001(\t\022(\n\006rating\030\002 \003(" +
      "\0132\030.UserProfileReply.Rating\0328\n\006Rating\022\013\n" +
      "\003mid\030\001 \001(\t\022\016\n\006rating\030\002 \001(\002\022\021\n\ttimestamp\030" +
      "\003 \001(\t\"\"\n\024UserRecommendRequest\022\n\n\002id\030\001 \001(" +
      "\t\"!\n\022UserRecommendReply\022\013\n\003mid\030\001 \003(\t\"!\n\023" +
      "MovieProfileRequest\022\n\n\002id\030\001 \001(\t\">\n\021Movie" +
      "ProfileReply\022\013\n\003mid\030\001 \001(\t\022\r\n\005title\030\002 \001(\t" +
      "\022\r\n\005genre\030\003 \001(\t23\n\007Greeter\022(\n\010SayHello\022\r" +
      ".HelloRequest\032\013.HelloReply\"\0002\305\001\n\nGetProf" +
      "ile\022:\n\016GetUserProfile\022\023.UserProfileReque" +
      "st\032\021.UserProfileReply\"\000\022=\n\017GetMovieProfi" +
      "le\022\024.MovieProfileRequest\032\022.MovieProfileR" +
      "eply\"\000\022<\n\014GetRecommend\022\025.UserRecommendRe" +
      "quest\032\023.UserRecommendReply\"\000B\036\n\013com.serv" +
      "iceB\007MyProtoP\001\242\002\003HLWb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_HelloRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_HelloReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_HelloReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_HelloReply_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_UserProfileRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_UserProfileRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserProfileRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_UserProfileReply_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_UserProfileReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserProfileReply_descriptor,
        new java.lang.String[] { "Uid", "Rating", });
    internal_static_UserProfileReply_Rating_descriptor =
      internal_static_UserProfileReply_descriptor.getNestedTypes().get(0);
    internal_static_UserProfileReply_Rating_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserProfileReply_Rating_descriptor,
        new java.lang.String[] { "Mid", "Rating", "Timestamp", });
    internal_static_UserRecommendRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_UserRecommendRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserRecommendRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_UserRecommendReply_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_UserRecommendReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserRecommendReply_descriptor,
        new java.lang.String[] { "Mid", });
    internal_static_MovieProfileRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_MovieProfileRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MovieProfileRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_MovieProfileReply_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_MovieProfileReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MovieProfileReply_descriptor,
        new java.lang.String[] { "Mid", "Title", "Genre", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
