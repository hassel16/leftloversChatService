package dhbw.leftlovers.service.chat.service;

import dhbw.leftlovers.service.chat.entity.Chat;
import dhbw.leftlovers.service.chat.entity.ChatForm;
import dhbw.leftlovers.service.chat.entity.User;
import dhbw.leftlovers.service.chat.exception.ChatNotFoundException;
import dhbw.leftlovers.service.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatRepository chatRepository;
    private OfferService offerService;
    private UserServiceImpl userService;

    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository, OfferService offerService, UserServiceImpl userService) {
        this.chatRepository = chatRepository;
        this.offerService = offerService;
        this.userService = userService;
    }

    @Override
    public List<Chat> findByUserId(Long userId) {
        return chatRepository.findByUsers_Userid(userId);
    }

    @Override
    public Optional<Chat> findByChatId(Long chatId) {
        return chatRepository.findByChatid(chatId);
    }

    @Override
    public List<Chat> getChats(Long userId) {
        userService.validateUserId(userId);
        return this.findByUserId(userId);
    }

    @Override
    public Chat getChat(Long chatId) {
        return this.findByChatId(chatId).orElseThrow(() -> new ChatNotFoundException(chatId));
    }

    @Override
    public void deleteChat(Long chatId) {
         chatRepository.delete(chatId);
    }

    @Override
    public ResponseEntity<?> createChat(ChatForm chatForm) {
        return this.offerService.findByOfferId(chatForm.getOfferid())
                .map(offer -> {
                    List<User> cacheListUser = new ArrayList<>();
                    chatForm.getUserIds().forEach(userid->{
                        userService.findByUserId(userid).ifPresent((User user) -> cacheListUser.add(user));
                    });

                    Chat chat = this.save(new Chat(chatForm.getTitel(), offer,cacheListUser));

                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/{id}")
                            .buildAndExpand(chat.getChatid()).toUri();
                    return ResponseEntity.created(location).build();
                }).orElse(ResponseEntity.noContent().build());
    }

    @Override
    public Chat save(Chat chat) {
        return chatRepository.save(chat);
    }

}
