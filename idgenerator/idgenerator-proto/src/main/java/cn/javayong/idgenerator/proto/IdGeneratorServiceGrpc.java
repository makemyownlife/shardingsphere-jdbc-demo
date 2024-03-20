package cn.javayong.idgenerator.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.47.0)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IdGeneratorServiceGrpc {

  private IdGeneratorServiceGrpc() {}

  public static final String SERVICE_NAME = "sharding.IdGeneratorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.javayong.idgenerator.proto.IdRequest,
      cn.javayong.idgenerator.proto.IdResult> getGetSeqIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSeqId",
      requestType = cn.javayong.idgenerator.proto.IdRequest.class,
      responseType = cn.javayong.idgenerator.proto.IdResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.javayong.idgenerator.proto.IdRequest,
      cn.javayong.idgenerator.proto.IdResult> getGetSeqIdMethod() {
    io.grpc.MethodDescriptor<cn.javayong.idgenerator.proto.IdRequest, cn.javayong.idgenerator.proto.IdResult> getGetSeqIdMethod;
    if ((getGetSeqIdMethod = IdGeneratorServiceGrpc.getGetSeqIdMethod) == null) {
      synchronized (IdGeneratorServiceGrpc.class) {
        if ((getGetSeqIdMethod = IdGeneratorServiceGrpc.getGetSeqIdMethod) == null) {
          IdGeneratorServiceGrpc.getGetSeqIdMethod = getGetSeqIdMethod =
              io.grpc.MethodDescriptor.<cn.javayong.idgenerator.proto.IdRequest, cn.javayong.idgenerator.proto.IdResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getSeqId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.javayong.idgenerator.proto.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.javayong.idgenerator.proto.IdResult.getDefaultInstance()))
              .setSchemaDescriptor(new IdGeneratorServiceMethodDescriptorSupplier("getSeqId"))
              .build();
        }
      }
    }
    return getGetSeqIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IdGeneratorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdGeneratorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IdGeneratorServiceStub>() {
        @java.lang.Override
        public IdGeneratorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IdGeneratorServiceStub(channel, callOptions);
        }
      };
    return IdGeneratorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IdGeneratorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdGeneratorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IdGeneratorServiceBlockingStub>() {
        @java.lang.Override
        public IdGeneratorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IdGeneratorServiceBlockingStub(channel, callOptions);
        }
      };
    return IdGeneratorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IdGeneratorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdGeneratorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IdGeneratorServiceFutureStub>() {
        @java.lang.Override
        public IdGeneratorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IdGeneratorServiceFutureStub(channel, callOptions);
        }
      };
    return IdGeneratorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class IdGeneratorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getSeqId(cn.javayong.idgenerator.proto.IdRequest request,
        io.grpc.stub.StreamObserver<cn.javayong.idgenerator.proto.IdResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSeqIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetSeqIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cn.javayong.idgenerator.proto.IdRequest,
                cn.javayong.idgenerator.proto.IdResult>(
                  this, METHODID_GET_SEQ_ID)))
          .build();
    }
  }

  /**
   */
  public static final class IdGeneratorServiceStub extends io.grpc.stub.AbstractAsyncStub<IdGeneratorServiceStub> {
    private IdGeneratorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdGeneratorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdGeneratorServiceStub(channel, callOptions);
    }

    /**
     */
    public void getSeqId(cn.javayong.idgenerator.proto.IdRequest request,
        io.grpc.stub.StreamObserver<cn.javayong.idgenerator.proto.IdResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSeqIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class IdGeneratorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<IdGeneratorServiceBlockingStub> {
    private IdGeneratorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdGeneratorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdGeneratorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.javayong.idgenerator.proto.IdResult getSeqId(cn.javayong.idgenerator.proto.IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSeqIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class IdGeneratorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<IdGeneratorServiceFutureStub> {
    private IdGeneratorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdGeneratorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdGeneratorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.javayong.idgenerator.proto.IdResult> getSeqId(
        cn.javayong.idgenerator.proto.IdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSeqIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SEQ_ID = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IdGeneratorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IdGeneratorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SEQ_ID:
          serviceImpl.getSeqId((cn.javayong.idgenerator.proto.IdRequest) request,
              (io.grpc.stub.StreamObserver<cn.javayong.idgenerator.proto.IdResult>) responseObserver);
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

  private static abstract class IdGeneratorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IdGeneratorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.javayong.idgenerator.proto.idgeneratorservice.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IdGeneratorService");
    }
  }

  private static final class IdGeneratorServiceFileDescriptorSupplier
      extends IdGeneratorServiceBaseDescriptorSupplier {
    IdGeneratorServiceFileDescriptorSupplier() {}
  }

  private static final class IdGeneratorServiceMethodDescriptorSupplier
      extends IdGeneratorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IdGeneratorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (IdGeneratorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IdGeneratorServiceFileDescriptorSupplier())
              .addMethod(getGetSeqIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
