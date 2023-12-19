package conprog.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ClientApp {

    public static void main(String[] args) {
        var context = SpringApplication.run(ClientApp.class, args);
        var greeterClient = context.getBean(GreeterClient.class);
        var greeting = greeterClient.receiveGreeting("Alphie");
        System.out.println("Greeting is " + greeting);
    }
}
