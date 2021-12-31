package com.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Get user profile service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.41.0)",
    comments = "Source: my_proto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GetProfileGrpc {

  private GetProfileGrpc() {}

  public static final String SERVICE_NAME = "GetProfile";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.service.UserProfileRequest,
      com.service.UserProfileReply> getGetUserProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserProfile",
      requestType = com.service.UserProfileRequest.class,
      responseType = com.service.UserProfileReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.service.UserProfileRequest,
      com.service.UserProfileReply> getGetUserProfileMethod() {
    io.grpc.MethodDescriptor<com.service.UserProfileRequest, com.service.UserProfileReply> getGetUserProfileMethod;
    if ((getGetUserProfileMethod = GetProfileGrpc.getGetUserProfileMethod) == null) {
      synchronized (GetProfileGrpc.class) {
        if ((getGetUserProfileMethod = GetProfileGrpc.getGetUserProfileMethod) == null) {
          GetProfileGrpc.getGetUserProfileMethod = getGetUserProfileMethod =
              io.grpc.MethodDescriptor.<com.service.UserProfileRequest, com.service.UserProfileReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.service.UserProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.service.UserProfileReply.getDefaultInstance()))
              .setSchemaDescriptor(new GetProfileMethodDescriptorSupplier("GetUserProfile"))
              .build();
        }
      }
    }
    return getGetUserProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.service.MovieProfileRequest,
      com.service.MovieProfileReply> getGetMovieProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMovieProfile",
      requestType = com.service.MovieProfileRequest.class,
      responseType = com.service.MovieProfileReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.service.MovieProfileRequest,
      com.service.MovieProfileReply> getGetMovieProfileMethod() {
    io.grpc.MethodDescriptor<com.service.MovieProfileRequest, com.service.MovieProfileReply> getGetMovieProfileMethod;
    if ((getGetMovieProfileMethod = GetProfileGrpc.getGetMovieProfileMethod) == null) {
      synchronized (GetProfileGrpc.class) {
        if ((getGetMovieProfileMethod = GetProfileGrpc.getGetMovieProfileMethod) == null) {
          GetProfileGrpc.getGetMovieProfileMethod = getGetMovieProfileMethod =
              io.grpc.MethodDescriptor.<com.service.MovieProfileRequest, com.service.MovieProfileReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMovieProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.service.MovieProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.service.MovieProfileReply.getDefaultInstance()))
              .setSchemaDescriptor(new GetProfileMethodDescriptorSupplier("GetMovieProfile"))
              .build();
        }
      }
    }
    return getGetMovieProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.service.UserRecommendRequest,
      com.service.UserRecommendReply> getGetRecommendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecommend",
      requestType = com.service.UserRecommendRequest.class,
      responseType = com.service.UserRecommendReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.service.UserRecommendRequest,
      com.service.UserRecommendReply> getGetRecommendMethod() {
    io.grpc.MethodDescriptor<com.service.UserRecommendRequest, com.service.UserRecommendReply> getGetRecommendMethod;
    if ((getGetRecommendMethod = GetProfileGrpc.getGetRecommendMethod) == null) {
      synchronized (GetProfileGrpc.class) {
        if ((getGetRecommendMethod = GetProfileGrpc.getGetRecommendMethod) == null) {
          GetProfileGrpc.getGetRecommendMethod = getGetRecommendMethod =
              io.grpc.MethodDescriptor.<com.service.UserRecommendRequest, com.service.UserRecommendReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRecommend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.service.UserRecommendRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.service.UserRecommendReply.getDefaultInstance()))
              .setSchemaDescriptor(new GetProfileMethodDescriptorSupplier("GetRecommend"))
              .build();
        }
      }
    }
    return getGetRecommendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GetProfileStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetProfileStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetProfileStub>() {
        @java.lang.Override
        public GetProfileStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetProfileStub(channel, callOptions);
        }
      };
    return GetProfileStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GetProfileBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetProfileBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetProfileBlockingStub>() {
        @java.lang.Override
        public GetProfileBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetProfileBlockingStub(channel, callOptions);
        }
      };
    return GetProfileBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GetProfileFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GetProfileFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GetProfileFutureStub>() {
        @java.lang.Override
        public GetProfileFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GetProfileFutureStub(channel, callOptions);
        }
      };
    return GetProfileFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Get user profile service
   * </pre>
   */
  public static abstract class GetProfileImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUserProfile(com.service.UserProfileRequest request,
        io.grpc.stub.StreamObserver<com.service.UserProfileReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserProfileMethod(), responseObserver);
    }

    /**
     */
    public void getMovieProfile(com.service.MovieProfileRequest request,
        io.grpc.stub.StreamObserver<com.service.MovieProfileReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMovieProfileMethod(), responseObserver);
    }

    /**
     */
    public void getRecommend(com.service.UserRecommendRequest request,
        io.grpc.stub.StreamObserver<com.service.UserRecommendReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRecommendMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.service.UserProfileRequest,
                com.service.UserProfileReply>(
                  this, METHODID_GET_USER_PROFILE)))
          .addMethod(
            getGetMovieProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.service.MovieProfileRequest,
                com.service.MovieProfileReply>(
                  this, METHODID_GET_MOVIE_PROFILE)))
          .addMethod(
            getGetRecommendMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.service.UserRecommendRequest,
                com.service.UserRecommendReply>(
                  this, METHODID_GET_RECOMMEND)))
          .build();
    }
  }

  /**
   * <pre>
   * Get user profile service
   * </pre>
   */
  public static final class GetProfileStub extends io.grpc.stub.AbstractAsyncStub<GetProfileStub> {
    private GetProfileStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetProfileStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetProfileStub(channel, callOptions);
    }

    /**
     */
    public void getUserProfile(com.service.UserProfileRequest request,
        io.grpc.stub.StreamObserver<com.service.UserProfileReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMovieProfile(com.service.MovieProfileRequest request,
        io.grpc.stub.StreamObserver<com.service.MovieProfileReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMovieProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRecommend(com.service.UserRecommendRequest request,
        io.grpc.stub.StreamObserver<com.service.UserRecommendReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRecommendMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Get user profile service
   * </pre>
   */
  public static final class GetProfileBlockingStub extends io.grpc.stub.AbstractBlockingStub<GetProfileBlockingStub> {
    private GetProfileBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetProfileBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetProfileBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.service.UserProfileReply getUserProfile(com.service.UserProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserProfileMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.service.MovieProfileReply getMovieProfile(com.service.MovieProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMovieProfileMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.service.UserRecommendReply getRecommend(com.service.UserRecommendRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRecommendMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Get user profile service
   * </pre>
   */
  public static final class GetProfileFutureStub extends io.grpc.stub.AbstractFutureStub<GetProfileFutureStub> {
    private GetProfileFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetProfileFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GetProfileFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.service.UserProfileReply> getUserProfile(
        com.service.UserProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserProfileMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.service.MovieProfileReply> getMovieProfile(
        com.service.MovieProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMovieProfileMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.service.UserRecommendReply> getRecommend(
        com.service.UserRecommendRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRecommendMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_PROFILE = 0;
  private static final int METHODID_GET_MOVIE_PROFILE = 1;
  private static final int METHODID_GET_RECOMMEND = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GetProfileImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GetProfileImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_PROFILE:
          serviceImpl.getUserProfile((com.service.UserProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.service.UserProfileReply>) responseObserver);
          break;
        case METHODID_GET_MOVIE_PROFILE:
          serviceImpl.getMovieProfile((com.service.MovieProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.service.MovieProfileReply>) responseObserver);
          break;
        case METHODID_GET_RECOMMEND:
          serviceImpl.getRecommend((com.service.UserRecommendRequest) request,
              (io.grpc.stub.StreamObserver<com.service.UserRecommendReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GetProfileBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GetProfileBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.service.MyProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GetProfile");
    }
  }

  private static final class GetProfileFileDescriptorSupplier
      extends GetProfileBaseDescriptorSupplier {
    GetProfileFileDescriptorSupplier() {}
  }

  private static final class GetProfileMethodDescriptorSupplier
      extends GetProfileBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GetProfileMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GetProfileGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GetProfileFileDescriptorSupplier())
              .addMethod(getGetUserProfileMethod())
              .addMethod(getGetMovieProfileMethod())
              .addMethod(getGetRecommendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
