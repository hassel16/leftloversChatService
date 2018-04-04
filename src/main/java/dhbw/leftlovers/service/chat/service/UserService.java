package dhbw.leftlovers.service.chat.service;

import dhbw.leftlovers.service.chat.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUserId(Long userId);
}
