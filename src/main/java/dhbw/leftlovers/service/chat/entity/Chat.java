package dhbw.leftlovers.service.chat.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_chat")
@NoArgsConstructor
public class Chat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatid;

    private String titel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_angebot_angebotid", nullable = false)
    private Long angebotid;
}
