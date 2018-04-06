package dhbw.leftlovers.service.chat.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_chat")
@NoArgsConstructor
public class Chat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatid;

    private String titel;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_nachricht_nachrichtid", nullable = false)
    private List<Message> messages;

    @ManyToMany
    @JoinTable(
            name = "tbl_chat_user_verbindung",
            joinColumns = @JoinColumn(name = "tbl_chat_chatid", referencedColumnName = "chatid"),
            inverseJoinColumns = @JoinColumn(name = "tbl_user_userid", referencedColumnName = "userid")
    )
    private List<User> users;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_angebot_angebotid", nullable = false)
    private Offer offer;

    public Chat(String titel, Offer offer) {
        this.titel = titel;
        this.offer = offer;
    }
}

