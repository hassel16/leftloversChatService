package dhbw.leftlovers.service.chat.repository;

import dhbw.leftlovers.service.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    Collection<Chat> findByUserId(Long userId);

    Optional<Chat> findByChatId(Long chatId);

}
