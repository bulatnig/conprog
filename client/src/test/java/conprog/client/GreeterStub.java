package conprog.client;

import conprog.api.GreeterGrpc;
import conprog.api.HelloReply;
import conprog.api.HelloRequest;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreeterStub extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, io.grpc.stub.StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
