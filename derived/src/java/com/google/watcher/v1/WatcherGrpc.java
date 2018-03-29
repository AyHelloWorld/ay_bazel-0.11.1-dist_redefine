package com.google.watcher.v1;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * The service that a client uses to connect to the watcher system.
 * The errors returned by the service are in the canonical error space,
 * see [google.rpc.Code][].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/watcher/v1/watch.proto")
public final class WatcherGrpc {

  private WatcherGrpc() {}

  public static final String SERVICE_NAME = "google.watcher.v1.Watcher";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.watcher.v1.Request,
      com.google.watcher.v1.ChangeBatch> METHOD_WATCH =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "google.watcher.v1.Watcher", "Watch"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.watcher.v1.Request.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.watcher.v1.ChangeBatch.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WatcherStub newStub(io.grpc.Channel channel) {
    return new WatcherStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WatcherBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WatcherBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static WatcherFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WatcherFutureStub(channel);
  }

  /**
   * <pre>
   * The service that a client uses to connect to the watcher system.
   * The errors returned by the service are in the canonical error space,
   * see [google.rpc.Code][].
   * </pre>
   */
  public static abstract class WatcherImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Start a streaming RPC to get watch information from the server.
     * </pre>
     */
    public void watch(com.google.watcher.v1.Request request,
        io.grpc.stub.StreamObserver<com.google.watcher.v1.ChangeBatch> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WATCH, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_WATCH,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.watcher.v1.Request,
                com.google.watcher.v1.ChangeBatch>(
                  this, METHODID_WATCH)))
          .build();
    }
  }

  /**
   * <pre>
   * The service that a client uses to connect to the watcher system.
   * The errors returned by the service are in the canonical error space,
   * see [google.rpc.Code][].
   * </pre>
   */
  public static final class WatcherStub extends io.grpc.stub.AbstractStub<WatcherStub> {
    private WatcherStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WatcherStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatcherStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WatcherStub(channel, callOptions);
    }

    /**
     * <pre>
     * Start a streaming RPC to get watch information from the server.
     * </pre>
     */
    public void watch(com.google.watcher.v1.Request request,
        io.grpc.stub.StreamObserver<com.google.watcher.v1.ChangeBatch> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_WATCH, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The service that a client uses to connect to the watcher system.
   * The errors returned by the service are in the canonical error space,
   * see [google.rpc.Code][].
   * </pre>
   */
  public static final class WatcherBlockingStub extends io.grpc.stub.AbstractStub<WatcherBlockingStub> {
    private WatcherBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WatcherBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatcherBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WatcherBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Start a streaming RPC to get watch information from the server.
     * </pre>
     */
    public java.util.Iterator<com.google.watcher.v1.ChangeBatch> watch(
        com.google.watcher.v1.Request request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_WATCH, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The service that a client uses to connect to the watcher system.
   * The errors returned by the service are in the canonical error space,
   * see [google.rpc.Code][].
   * </pre>
   */
  public static final class WatcherFutureStub extends io.grpc.stub.AbstractStub<WatcherFutureStub> {
    private WatcherFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WatcherFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatcherFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WatcherFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_WATCH = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WatcherImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WatcherImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WATCH:
          serviceImpl.watch((com.google.watcher.v1.Request) request,
              (io.grpc.stub.StreamObserver<com.google.watcher.v1.ChangeBatch>) responseObserver);
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

  private static final class WatcherDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.watcher.v1.WatchProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WatcherGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WatcherDescriptorSupplier())
              .addMethod(METHOD_WATCH)
              .build();
        }
      }
    }
    return result;
  }
}
