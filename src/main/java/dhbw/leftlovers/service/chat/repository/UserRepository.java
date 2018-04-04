package dhbw.leftlovers.service.chat.repository;

import dhbw.leftlovers.service.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUserid(Long userId);
}
