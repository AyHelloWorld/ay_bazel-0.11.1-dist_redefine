package com.google.bytestream;

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
 * #### Introduction
 * The Byte Stream API enables a client to read and write a stream of bytes to
 * and from a resource. Resources have names, and these names are supplied in
 * the API calls below to identify the resource that is being read from or
 * written to.
 * All implementations of the Byte Stream API export the interface defined here:
 * * `Read()`: Reads the contents of a resource.
 * * `Write()`: Writes the contents of a resource. The client can call `Write()`
 *   multiple times with the same resource and can check the status of the write
 *   by calling `QueryWriteStatus()`.
 * #### Service parameters and metadata
 * The ByteStream API provides no direct way to access/modify any metadata
 * associated with the resource.
 * #### Errors
 * The errors returned by the service are in the Google canonical error space.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/bytestream/bytestream.proto")
public final class ByteStreamGrpc {

  private ByteStreamGrpc() {}

  public static final String SERVICE_NAME = "google.bytestream.ByteStream";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.bytestream.ByteStreamProto.ReadRequest,
      com.google.bytestream.ByteStreamProto.ReadResponse> METHOD_READ =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "google.bytestream.ByteStream", "Read"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.bytestream.ByteStreamProto.ReadRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.bytestream.ByteStreamProto.ReadResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.bytestream.ByteStreamProto.WriteRequest,
      com.google.bytestream.ByteStreamProto.WriteResponse> METHOD_WRITE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING,
          generateFullMethodName(
              "google.bytestream.ByteStream", "Write"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.bytestream.ByteStreamProto.WriteRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.bytestream.ByteStreamProto.WriteResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.bytestream.ByteStreamProto.QueryWriteStatusRequest,
      com.google.bytestream.ByteStreamProto.QueryWriteStatusResponse> METHOD_QUERY_WRITE_STATUS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.bytestream.ByteStream", "QueryWriteStatus"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.bytestream.ByteStreamProto.QueryWriteStatusRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.bytestream.ByteStreamProto.QueryWriteStatusResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ByteStreamStub newStub(io.grpc.Channel channel) {
    return new ByteStreamStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ByteStreamBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ByteStreamBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static ByteStreamFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ByteStreamFutureStub(channel);
  }

  /**
   * <pre>
   * #### Introduction
   * The Byte Stream API enables a client to read and write a stream of bytes to
   * and from a resource. Resources have names, and these names are supplied in
   * the API calls below to identify the resource that is being read from or
   * written to.
   * All implementations of the Byte Stream API export the interface defined here:
   * * `Read()`: Reads the contents of a resource.
   * * `Write()`: Writes the contents of a resource. The client can call `Write()`
   *   multiple times with the same resource and can check the status of the write
   *   by calling `QueryWriteStatus()`.
   * #### Service parameters and metadata
   * The ByteStream API provides no direct way to access/modify any metadata
   * associated with the resource.
   * #### Errors
   * The errors returned by the service are in the Google canonical error space.
   * </pre>
   */
  public static abstract class ByteStreamImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * `Read()` is used to retrieve the contents of a resource as a sequence
     * of bytes. The bytes are returned in a sequence of responses, and the
     * responses are delivered as the results of a server-side streaming RPC.
     * </pre>
     */
    public void read(com.google.bytestream.ByteStreamProto.ReadRequest request,
        io.grpc.stub.StreamObserver<com.google.bytestream.ByteStreamProto.ReadResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ, responseObserver);
    }

    /**
     * <pre>
     * `Write()` is used to send the contents of a resource as a sequence of
     * bytes. The bytes are sent in a sequence of request protos of a client-side
     * streaming RPC.
     * A `Write()` action is resumable. If there is an error or the connection is
     * broken during the `Write()`, the client should check the status of the
     * `Write()` by calling `QueryWriteStatus()` and continue writing from the
     * returned `committed_size`. This may be less than the amount of data the
     * client previously sent.
     * Calling `Write()` on a resource name that was previously written and
     * finalized could cause an error, depending on whether the underlying service
     * allows over-writing of previously written resources.
     * When the client closes the request channel, the service will respond with
     * a `WriteResponse`. The service will not view the resource as `complete`
     * until the client has sent a `WriteRequest` with `finish_write` set to
     * `true`. Sending any requests on a stream after sending a request with
     * `finish_write` set to `true` will cause an error. The client **should**
     * check the `WriteResponse` it receives to determine how much data the
     * service was able to commit and whether the service views the resource as
     * `complete` or not.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.bytestream.ByteStreamProto.WriteRequest> write(
        io.grpc.stub.StreamObserver<com.google.bytestream.ByteStreamProto.WriteResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_WRITE, responseObserver);
    }

    /**
     * <pre>
     * `QueryWriteStatus()` is used to find the `committed_size` for a resource
     * that is being written, which can then be used as the `write_offset` for
     * the next `Write()` call.
     * If the resource does not exist (i.e., the resource has been deleted, or the
     * first `Write()` has not yet reached the service), this method returns the
     * error `NOT_FOUND`.
     * The client **may** call `QueryWriteStatus()` at any time to determine how
     * much data has been processed for this resource. This is useful if the
     * client is buffering data and needs to know which data can be safely
     * evicted. For any sequence of `QueryWriteStatus()` calls for a given
     * resource name, the sequence of returned `committed_size` values will be
     * non-decreasing.
     * </pre>
     */
    public void queryWriteStatus(com.google.bytestream.ByteStreamProto.QueryWriteStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.bytestream.ByteStreamProto.QueryWriteStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_QUERY_WRITE_STATUS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_READ,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.bytestream.ByteStreamProto.ReadRequest,
                com.google.bytestream.ByteStreamProto.ReadResponse>(
                  this, METHODID_READ)))
          .addMethod(
            METHOD_WRITE,
            asyncClientStreamingCall(
              new MethodHandlers<
                com.google.bytestream.ByteStreamProto.WriteRequest,
                com.google.bytestream.ByteStreamProto.WriteResponse>(
                  this, METHODID_WRITE)))
          .addMethod(
            METHOD_QUERY_WRITE_STATUS,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.bytestream.ByteStreamProto.QueryWriteStatusRequest,
                com.google.bytestream.ByteStreamProto.QueryWriteStatusResponse>(
                  this, METHODID_QUERY_WRITE_STATUS)))
          .build();
    }
  }

  /**
   * <pre>
   * #### Introduction
   * The Byte Stream API enables a client to read and write a stream of bytes to
   * and from a resource. Resources have names, and these names are supplied in
   * the API calls below to identify the resource that is being read from or
   * written to.
   * All implementations of the Byte Stream API export the interface defined here:
   * * `Read()`: Reads the contents of a resource.
   * * `Write()`: Writes the contents of a resource. The client can call `Write()`
   *   multiple times with the same resource and can check the status of the write
   *   by calling `QueryWriteStatus()`.
   * #### Service parameters and metadata
   * The ByteStream API provides no direct way to access/modify any metadata
   * associated with the resource.
   * #### Errors
   * The errors returned by the service are in the Google canonical error space.
   * </pre>
   */
  public static final class ByteStreamStub extends io.grpc.stub.AbstractStub<ByteStreamStub> {
    private ByteStreamStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ByteStreamStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ByteStreamStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ByteStreamStub(channel, callOptions);
    }

    /**
     * <pre>
     * `Read()` is used to retrieve the contents of a resource as a sequence
     * of bytes. The bytes are returned in a sequence of responses, and the
     * responses are delivered as the results of a server-side streaming RPC.
     * </pre>
     */
    public void read(com.google.bytestream.ByteStreamProto.ReadRequest request,
        io.grpc.stub.StreamObserver<com.google.bytestream.ByteStreamProto.ReadResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_READ, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * `Write()` is used to send the contents of a resource as a sequence of
     * bytes. The bytes are sent in a sequence of request protos of a client-side
     * streaming RPC.
     * A `Write()` action is resumable. If there is an error or the connection is
     * broken during the `Write()`, the client should check the status of the
     * `Write()` by calling `QueryWriteStatus()` and continue writing from the
     * returned `committed_size`. This may be less than the amount of data the
     * client previously sent.
     * Calling `Write()` on a resource name that was previously written and
     * finalized could cause an error, depending on whether the underlying service
     * allows over-writing of previously written resources.
     * When the client closes the request channel, the service will respond with
     * a `WriteResponse`. The service will not view the resource as `complete`
     * until the client has sent a `WriteRequest` with `finish_write` set to
     * `true`. Sending any requests on a stream after sending a request with
     * `finish_write` set to `true` will cause an error. The client **should**
     * check the `WriteResponse` it receives to determine how much data the
     * service was able to commit and whether the service views the resource as
     * `complete` or not.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.bytestream.ByteStreamProto.WriteRequest> write(
        io.grpc.stub.StreamObserver<com.google.bytestream.ByteStreamProto.WriteResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_WRITE, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * `QueryWriteStatus()` is used to find the `committed_size` for a resource
     * that is being written, which can then be used as the `write_offset` for
     * the next `Write()` call.
     * If the resource does not exist (i.e., the resource has been deleted, or the
     * first `Write()` has not yet reached the service), this method returns the
     * error `NOT_FOUND`.
     * The client **may** call `QueryWriteStatus()` at any time to determine how
     * much data has been processed for this resource. This is useful if the
     * client is buffering data and needs to know which data can be safely
     * evicted. For any sequence of `QueryWriteStatus()` calls for a given
     * resource name, the sequence of returned `committed_size` values will be
     * non-decreasing.
     * </pre>
     */
    public void queryWriteStatus(com.google.bytestream.ByteStreamProto.QueryWriteStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.bytestream.ByteStreamProto.QueryWriteStatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_QUERY_WRITE_STATUS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * #### Introduction
   * The Byte Stream API enables a client to read and write a stream of bytes to
   * and from a resource. Resources have names, and these names are supplied in
   * the API calls below to identify the resource that is being read from or
   * written to.
   * All implementations of the Byte Stream API export the interface defined here:
   * * `Read()`: Reads the contents of a resource.
   * * `Write()`: Writes the contents of a resource. The client can call `Write()`
   *   multiple times with the same resource and can check the status of the write
   *   by calling `QueryWriteStatus()`.
   * #### Service parameters and metadata
   * The ByteStream API provides no direct way to access/modify any metadata
   * associated with the resource.
   * #### Errors
   * The errors returned by the service are in the Google canonical error space.
   * </pre>
   */
  public static final class ByteStreamBlockingStub extends io.grpc.stub.AbstractStub<ByteStreamBlockingStub> {
    private ByteStreamBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ByteStreamBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ByteStreamBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ByteStreamBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * `Read()` is used to retrieve the contents of a resource as a sequence
     * of bytes. The bytes are returned in a sequence of responses, and the
     * responses are delivered as the results of a server-side streaming RPC.
     * </pre>
     */
    public java.util.Iterator<com.google.bytestream.ByteStreamProto.ReadResponse> read(
        com.google.bytestream.ByteStreamProto.ReadRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_READ, getCallOptions(), request);
    }

    /**
     * <pre>
     * `QueryWriteStatus()` is used to find the `committed_size` for a resource
     * that is being written, which can then be used as the `write_offset` for
     * the next `Write()` call.
     * If the resource does not exist (i.e., the resource has been deleted, or the
     * first `Write()` has not yet reached the service), this method returns the
     * error `NOT_FOUND`.
     * The client **may** call `QueryWriteStatus()` at any time to determine how
     * much data has been processed for this resource. This is useful if the
     * client is buffering data and needs to know which data can be safely
     * evicted. For any sequence of `QueryWriteStatus()` calls for a given
     * resource name, the sequence of returned `committed_size` values will be
     * non-decreasing.
     * </pre>
     */
    public com.google.bytestream.ByteStreamProto.QueryWriteStatusResponse queryWriteStatus(com.google.bytestream.ByteStreamProto.QueryWriteStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_QUERY_WRITE_STATUS, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * #### Introduction
   * The Byte Stream API enables a client to read and write a stream of bytes to
   * and from a resource. Resources have names, and these names are supplied in
   * the API calls below to identify the resource that is being read from or
   * written to.
   * All implementations of the Byte Stream API export the interface defined here:
   * * `Read()`: Reads the contents of a resource.
   * * `Write()`: Writes the contents of a resource. The client can call `Write()`
   *   multiple times with the same resource and can check the status of the write
   *   by calling `QueryWriteStatus()`.
   * #### Service parameters and metadata
   * The ByteStream API provides no direct way to access/modify any metadata
   * associated with the resource.
   * #### Errors
   * The errors returned by the service are in the Google canonical error space.
   * </pre>
   */
  public static final class ByteStreamFutureStub extends io.grpc.stub.AbstractStub<ByteStreamFutureStub> {
    private ByteStreamFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ByteStreamFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ByteStreamFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ByteStreamFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * `QueryWriteStatus()` is used to find the `committed_size` for a resource
     * that is being written, which can then be used as the `write_offset` for
     * the next `Write()` call.
     * If the resource does not exist (i.e., the resource has been deleted, or the
     * first `Write()` has not yet reached the service), this method returns the
     * error `NOT_FOUND`.
     * The client **may** call `QueryWriteStatus()` at any time to determine how
     * much data has been processed for this resource. This is useful if the
     * client is buffering data and needs to know which data can be safely
     * evicted. For any sequence of `QueryWriteStatus()` calls for a given
     * resource name, the sequence of returned `committed_size` values will be
     * non-decreasing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.bytestream.ByteStreamProto.QueryWriteStatusResponse> queryWriteStatus(
        com.google.bytestream.ByteStreamProto.QueryWriteStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_QUERY_WRITE_STATUS, getCallOptions()), request);
    }
  }

  private static final int METHODID_READ = 0;
  private static final int METHODID_QUERY_WRITE_STATUS = 1;
  private static final int METHODID_WRITE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ByteStreamImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ByteStreamImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_READ:
          serviceImpl.read((com.google.bytestream.ByteStreamProto.ReadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bytestream.ByteStreamProto.ReadResponse>) responseObserver);
          break;
        case METHODID_QUERY_WRITE_STATUS:
          serviceImpl.queryWriteStatus((com.google.bytestream.ByteStreamProto.QueryWriteStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.bytestream.ByteStreamProto.QueryWriteStatusResponse>) responseObserver);
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
        case METHODID_WRITE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.write(
              (io.grpc.stub.StreamObserver<com.google.bytestream.ByteStreamProto.WriteResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class ByteStreamDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.bytestream.ByteStreamProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ByteStreamGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ByteStreamDescriptorSupplier())
              .addMethod(METHOD_READ)
              .addMethod(METHOD_WRITE)
              .addMethod(METHOD_QUERY_WRITE_STATUS)
              .build();
        }
      }
    }
    return result;
  }
}
