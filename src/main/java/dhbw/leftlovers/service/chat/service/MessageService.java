package dhbw.leftlovers.service.chat.service;

import dhbw.leftlovers.service.chat.entity.Chat;
import dhbw.leftlovers.service.chat.entity.ChatForm;
import dhbw.leftlovers.service.chat.entity.Message;
import dhbw.leftlovers.service.chat.entity.MessageForm;
import org.springframework.http.ResponseEntity;

public interface MessageService {

    ResponseEntity<?> createMessage(Long chatId, MessageForm messageForm);

    Message save(Message message);
}
