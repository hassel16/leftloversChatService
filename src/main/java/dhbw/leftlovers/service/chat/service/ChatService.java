package dhbw.leftlovers.service.chat.service;

import dhbw.leftlovers.service.chat.entity.Chat;
import dhbw.leftlovers.service.chat.entity.ChatForm;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ChatService {

    List<Chat> findByUserId(Long userid);

    Optional<Chat> findByChatId(Long chatId);

    List<Chat> getChats(Long userId);

    Chat getChat(Long chatId);

    ResponseEntity<?> createChat(Long offerId, ChatForm chatForm);

    Chat save(Chat chat);


}
