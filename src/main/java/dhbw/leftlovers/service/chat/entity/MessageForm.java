package dhbw.leftlovers.service.chat.entity;

import lombok.Data;

@Data
public class MessageForm {

    private String text;
    Long userId;
}
