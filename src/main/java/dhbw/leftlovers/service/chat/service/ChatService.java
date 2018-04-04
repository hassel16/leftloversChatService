package dhbw.leftlovers.service.chat.service;

import dhbw.leftlovers.service.chat.entity.Chat;
import dhbw.leftlovers.service.chat.entity.ChatForm;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Optional;

public interface ChatService {

    Collection<Chat> findByUserId(Long userid);

    Optional<Chat> findByChatId(Long chatId);

    Collection<Chat> getChats(Long userId);

    Chat getChat(Long chatId);

    ResponseEntity<?> createChat(Long offerId, ChatForm chatForm);

    Chat save(Chat chat);


}
