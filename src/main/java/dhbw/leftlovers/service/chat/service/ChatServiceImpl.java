package dhbw.leftlovers.service.chat.service;

import dhbw.leftlovers.service.chat.entity.Chat;
import dhbw.leftlovers.service.chat.entity.ChatForm;
import dhbw.leftlovers.service.chat.exception.ChatNotFoundException;
import dhbw.leftlovers.service.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatRepository chatRepository;
    private ChatService chatService;
    private OfferService offerService;
    private UserServiceImpl userService;

    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository, ChatService chatService, OfferService offerService, UserServiceImpl userService) {
        this.chatRepository = chatRepository;
        this.chatService = chatService;
        this.offerService = offerService;
        this.userService = userService;
    }

    @Override
    public Collection<Chat> findByUserId(Long userId) {
        return chatRepository.findByUserId(userId);
    }

    @Override
    public Optional<Chat> findByChatId(Long chatId) {
        return chatRepository.findByChatId(chatId);
    }

    @Override
    public Collection<Chat> getChats(Long userId) {
        userService.validateUserId(userId);
        return this.findByUserId(userId);
    }

    @Override
    public Chat getChat(Long chatId) {
        return this.findByChatId(chatId).orElseThrow(() -> new ChatNotFoundException(chatId));
    }

    @Override
    public ResponseEntity<?> createChat(Long offerId, ChatForm chatForm) {
        return this.offerService.findByOfferId(offerId)
                .map(offer -> {
                    Chat chat = chatService.save(new Chat(chatForm.getTitel(), offer));

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
