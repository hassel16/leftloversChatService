package dhbw.leftlovers.service.chat.service;

import dhbw.leftlovers.service.chat.entity.Message;
import dhbw.leftlovers.service.chat.entity.MessageForm;
import dhbw.leftlovers.service.chat.entity.User;
import dhbw.leftlovers.service.chat.exception.UserNotFoundException;
import dhbw.leftlovers.service.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;
    private ChatService chatService;
    private UserService userService;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, ChatService chatService, UserService userService) {
        this.messageRepository = messageRepository;
        this.chatService = chatService;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<?> createMessage(Long chatId, MessageForm messageForm) {

        User user = userService.findByUserId(messageForm.getUserId()).orElseThrow(() -> new UserNotFoundException(messageForm.getUserId()));

        return this.chatService.findByChatId(chatId)
                .map(chat -> {
                    Message message = this.save(new Message(messageForm.getText(), chat, user));

                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/{id}")
                            .buildAndExpand(chat.getChatid()).toUri();
                    return ResponseEntity.created(location).build();
                }).orElse(ResponseEntity.noContent().build());
    }

    @Override
    @Transactional
    public Message save(Message message) {
        return messageRepository.save(message);
    }
}
