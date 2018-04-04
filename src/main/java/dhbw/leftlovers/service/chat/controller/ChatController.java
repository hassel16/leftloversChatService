package dhbw.leftlovers.service.chat.controller;

import dhbw.leftlovers.service.chat.entity.Chat;
import dhbw.leftlovers.service.chat.entity.ChatForm;
import dhbw.leftlovers.service.chat.entity.Message;
import dhbw.leftlovers.service.chat.service.ChatService;
import dhbw.leftlovers.service.chat.service.OfferService;
import dhbw.leftlovers.service.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
public class ChatController {

    private UserService userService;
    private ChatService chatService;
    private OfferService offerService;

    @Autowired
    public ChatController(UserService userService, ChatService chatService, OfferService offerService) {
        this.userService = userService;
        this.chatService = chatService;
        this.offerService = offerService;
    }

    @GetMapping("/chats/{userId}")
    Collection<Chat> getChats(@PathVariable Long userId) {
        return chatService.getChats(userId);
    }

    @GetMapping("/chat/{chatId}")
    Chat getChat(@PathVariable Long chatId) {
        return chatService.getChat(chatId);
    }

    @PostMapping("/chat/{chatId}")
    void addMessage(@PathVariable Long chatId, @RequestBody Message message) {

    }

    @PostMapping("/{offerId}/chat")
    ResponseEntity<?> createChat(@RequestParam Long offerId, @RequestBody ChatForm chatForm) {
        return chatService.createChat(offerId, chatForm);
    }
}
