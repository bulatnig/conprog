package conprog.server;

import conprog.api.GreeterGrpc;
import conprog.api.HelloReply;
import conprog.api.HelloRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Import(GreeterImpl.class)
@SpringBootTest
@SpringJUnitConfig(classes = { GrpcTestConfiguration.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GreeterServerTest extends GrpcTestConfiguration {

    @GrpcClient("test")
    private GreeterGrpc.GreeterBlockingStub greeter;

    @Test
    public void testSayHello() {
        var request = HelloRequest.newBuilder()
                .setName("Test")
                .build();
        HelloReply response = greeter.sayHello(request);
        assertNotNull(response);
        assertEquals("Hello ==> Test", response.getMessage());
    }

}
