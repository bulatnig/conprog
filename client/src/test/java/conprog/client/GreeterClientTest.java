package conprog.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import({GreeterClient.class, GreeterStub.class})
@SpringBootTest(properties = {
        "grpc.server.inProcessName=greeter", // Enable inProcess server
        "grpc.server.port=-1", // Disable external server
        "grpc.client.inProcess.address=in-process:greeter" // Configure the client to connect to the inProcess server
})
@SpringJUnitConfig(classes = {GrpcTestConfiguration.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GreeterClientTest {

    @Autowired
    GreeterClient greeterClient;

    @Test
    public void testSayHello() {
        String greeting = greeterClient.receiveGreeting("Bob");
        assertEquals("Hello ==> Bob", greeting);
    }

}
