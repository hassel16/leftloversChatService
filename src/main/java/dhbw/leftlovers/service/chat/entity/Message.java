package dhbw.leftlovers.service.chat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_nachricht")
@NoArgsConstructor
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nachrichtid;

    @Column(name = "erfasszeitpunkt")
    private Timestamp createdAt;

    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_chat_chatid", nullable = false)
    private Chat chat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_user_userid", nullable = false)
    private User user;

    public Message(String text, Chat chat, User user) {
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
        this.text = text;
        this.chat = chat;
        this.user = user;
    }
}
