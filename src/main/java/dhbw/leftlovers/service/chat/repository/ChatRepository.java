package dhbw.leftlovers.service.chat.repository;

import dhbw.leftlovers.service.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findByUsers_Userid(Long userId);

    Optional<Chat> findByChatid(Long chatId);

}
