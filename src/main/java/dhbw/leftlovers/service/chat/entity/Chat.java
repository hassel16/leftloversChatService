package dhbw.leftlovers.service.chat.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_chat")
@NoArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatid;

    private String titel;

    @OneToMany(mappedBy = "chat" , cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Message> messages;

    @ManyToMany
    @JoinTable(
            name = "tbl_chat_user_verbindung",
            joinColumns = @JoinColumn(name = "tbl_chat_chatid"),
            inverseJoinColumns = @JoinColumn(name = "tbl_user_userid")
    )
    private List<User> users;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_angebot_angebotid", nullable = false)
    private Offer offer;

    public Chat(String titel, Offer offer,List<User> users) {
        this.titel = titel;
        this.offer = offer;
        this.users = users;
    }
}

