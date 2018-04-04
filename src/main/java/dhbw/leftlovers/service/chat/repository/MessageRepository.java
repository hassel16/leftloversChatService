package dhbw.leftlovers.service.chat.repository;

import dhbw.leftlovers.service.chat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {


}
