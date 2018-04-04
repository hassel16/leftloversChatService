package dhbw.leftlovers.service.chat.service;

import dhbw.leftlovers.service.chat.entity.Message;
import dhbw.leftlovers.service.chat.entity.MessageForm;
import dhbw.leftlovers.service.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    private ChatService chatService;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, ChatService chatService) {
        this.messageRepository = messageRepository;
        this.chatService = chatService;
    }

    @Override
    public ResponseEntity<?> createMessage(Long chatId, MessageForm messageForm) {
        return this.chatService.findByChatId(chatId)
                .map(chat -> {
                    Message message = this.save(new Message(messageForm.getText(), chat, messageForm.getUsers()));

                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/{id}")
                            .buildAndExpand(chat.getChatid()).toUri();
                    return ResponseEntity.created(location).build();
                }).orElse(ResponseEntity.noContent().build());
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }
}
