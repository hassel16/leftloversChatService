package dhbw.leftlovers.service.chat.service;

import dhbw.leftlovers.service.chat.entity.Chat;
import dhbw.leftlovers.service.chat.entity.ChatForm;
import dhbw.leftlovers.service.chat.exception.ChatNotFoundException;
import dhbw.leftlovers.service.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @Transactional
    public ResponseEntity<?> createChat(Long offerId, ChatForm chatForm) {
        return this.offerService.findByOfferId(offerId)
                .map(offer -> {
                    Chat chat = this.save(new Chat(chatForm.getTitel(), offer));

                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/{id}")
                            .buildAndExpand(chat.getChatid()).toUri();
                    return ResponseEntity.created(location).build();
                }).orElse(ResponseEntity.noContent().build());
    }

    @Override
    @Transactional
    public Chat save(Chat chat) {
        return chatRepository.save(chat);
    }

}
