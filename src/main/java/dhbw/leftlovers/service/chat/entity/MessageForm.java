package dhbw.leftlovers.service.chat.entity;

import lombok.Data;

import java.util.List;

@Data
public class MessageForm {

    private String text;

    List<User> users;
}
