package dhbw.leftlovers.service.chat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "tbl_nachricht")
@NoArgsConstructor
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nachrichtId;

    @Column(name = "erfasszeitpunkt")
    private Timestamp createdAt;

    @Lob
    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_chat_chatid", nullable = false)
    private Long chatid;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_user_userid", nullable = false)
    private Long userid;
}
