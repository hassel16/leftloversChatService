package dhbw.leftlovers.service.chat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_angebot")
@NoArgsConstructor
public class Offer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long angebotid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_user_userid", nullable = false)
    private User user;

}
