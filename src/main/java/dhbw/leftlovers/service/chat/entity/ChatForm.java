package dhbw.leftlovers.service.chat.entity;

import lombok.Data;

import java.util.List;

@Data
public class ChatForm {

    String titel;
    long offerid;
    List<Long> userIds;
}
