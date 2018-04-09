package dhbw.leftlovers.service.chat.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_angebot")
@NoArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long angebotid;

    @OneToMany(mappedBy="offer", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Chat> chats;


}
