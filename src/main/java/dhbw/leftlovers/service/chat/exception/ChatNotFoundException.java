package dhbw.leftlovers.service.chat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ChatNotFoundException extends RuntimeException {

    public ChatNotFoundException(Long chatId) {
        super("chatid " + chatId + " not found.");
    }
}