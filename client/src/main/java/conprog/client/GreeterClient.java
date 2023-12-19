package conprog.client;

import conprog.api.GreeterGrpc;
import conprog.api.HelloRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GreeterClient {

    @GrpcClient("greeter")
    private GreeterGrpc.GreeterBlockingStub greeter;

    public String receiveGreeting(String name) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        return greeter.sayHello(request).getMessage();
    }

}
