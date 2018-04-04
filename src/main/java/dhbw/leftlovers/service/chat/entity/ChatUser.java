package dhbw.leftlovers.service.chat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_chat_user_verbindung")
@NoArgsConstructor
public class ChatUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chatuserid;

   /* @JoinColumn(name = "tbl_chat_chatid", nullable = false)
    private Chat chat;

    @JoinColumn(name = "tbl_user_userid", nullable = false)
    private User user;*/
}
