package dhbw.leftlovers.service.chat.register;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ServiceRegistration {

    public static void registerInServiceRegister() {
        Gson g = new GsonBuilder().create();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Service ownService =  new Service("ChatService", "https://angebotsservice.herokuapp.com", 443);
        HttpEntity<String> entity = new HttpEntity<>(g.toJson(ownService, Service.class), headers);
        ResponseEntity<String> response = restTemplate.postForEntity("https://leftloversgateway.azurewebsites.net/APIGateway/ServiceRegister?password=leftlovers_wwi16B3", entity, String.class);
    }
}

