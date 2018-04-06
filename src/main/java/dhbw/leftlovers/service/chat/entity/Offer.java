package dhbw.leftlovers.service.chat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_angebot")
@NoArgsConstructor
public class Offer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long angebotid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_user_userid", nullable = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_chat_chatid", nullable = false)
    private List<Chat> chats;


}
