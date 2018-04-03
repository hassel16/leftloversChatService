package dhbw.leftlovers.service.chat.security.repository;

import dhbw.leftlovers.service.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRepository, Long> {

    Optional<User> findByUsername(String username);
}
