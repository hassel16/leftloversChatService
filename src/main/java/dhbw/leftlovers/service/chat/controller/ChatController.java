package dhbw.leftlovers.service.chat.controller;

import dhbw.leftlovers.service.chat.entity.Chat;
import dhbw.leftlovers.service.chat.entity.ChatForm;
import dhbw.leftlovers.service.chat.entity.MessageForm;
import dhbw.leftlovers.service.chat.service.ChatService;
import dhbw.leftlovers.service.chat.service.MessageService;
import dhbw.leftlovers.service.chat.service.OfferService;
import dhbw.leftlovers.service.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/ChatService")
public class ChatController {

    private UserService userService;
    private ChatService chatService;
    private OfferService offerService;
    private MessageService messageService;

    @Autowired
    public ChatController(UserService userService, ChatService chatService, OfferService offerService, MessageService messageService) {
        this.userService = userService;
        this.chatService = chatService;
        this.offerService = offerService;
        this.messageService = messageService;
    }

    @GetMapping("/chats/{userId}")
    Collection<Chat> getChats(@PathVariable Long userId) {
        Collection<Chat> s= chatService.getChats(userId);
        return s;
    }

    @GetMapping("/chat/{chatId}")
    Chat getChat(@PathVariable Long chatId) {
        return chatService.getChat(chatId);
    }

    @PostMapping("/chat/{chatId}")
    ResponseEntity<?> addMessage(@PathVariable Long chatId, @RequestBody MessageForm messageForm) {
        return messageService.createMessage(chatId, messageForm);
    }

    @DeleteMapping("/chat/{chatId}")
    ResponseEntity<?> addMessage(@PathVariable Long chatId) {
        chatService.deleteChat(chatId);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/chat")
    ResponseEntity<?> createChat(@RequestBody ChatForm chatForm) {
        Chat cache = chatService.createChat(chatForm);

        return messageService.createMessage(cache.getChatid(), chatForm.getMessageform());
    }
}
