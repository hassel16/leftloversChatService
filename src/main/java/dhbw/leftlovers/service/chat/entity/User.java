package dhbw.leftlovers.service.chat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    private String username;
    private String password;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "tbl_chat_user_verbindung",
            joinColumns = @JoinColumn(name = "tbl_user_userid", referencedColumnName = "userid"),
            inverseJoinColumns = @JoinColumn(name = "tbl_chat_chatid", referencedColumnName = "chatid")
    )
    private List<Chat> chats;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_angebot_angebotid", nullable = false)
    private List<Offer> offers;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_nachricht_nachrichtid", nullable = false)
    private List<Message> messages;
}
