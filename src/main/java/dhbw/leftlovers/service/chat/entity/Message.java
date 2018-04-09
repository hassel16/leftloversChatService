package dhbw.leftlovers.service.chat.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "tbl_nachricht")
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nachrichtid;

    private Timestamp erfasszeitpunkt;

    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_chat_chatid", nullable = false)
    @JsonBackReference
    private Chat chat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_user_userid", nullable = false)
    @JsonManagedReference
    private User user;

    public Message(String text, Chat chat, User user) {
        this.text = text;
        this.chat = chat;
        this.user = user;
    }
}
