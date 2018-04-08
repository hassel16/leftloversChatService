package dhbw.leftlovers.service.chat;

import dhbw.leftlovers.service.chat.register.ServiceRegistration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
        ServiceRegistration.registerInServiceRegister();
    }
}
