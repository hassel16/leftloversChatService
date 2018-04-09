package dhbw.leftlovers.service.chat.service;

import dhbw.leftlovers.service.chat.entity.Chat;
import dhbw.leftlovers.service.chat.entity.ChatForm;

import java.util.List;
import java.util.Optional;

public interface ChatService {

    List<Chat> findByUserId(Long userid);

    Optional<Chat> findByChatId(Long chatId);

    List<Chat> getChats(Long userId);

    Chat getChat(Long chatId);

    Chat createChat(ChatForm chatForm);

    Chat save(Chat chat);

    void deleteChat(Long chatId);

}
