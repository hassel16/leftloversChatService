package dhbw.leftlovers.service.chat.service;

import dhbw.leftlovers.service.chat.entity.User;
import dhbw.leftlovers.service.chat.exception.UserNotFoundException;
import dhbw.leftlovers.service.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByUserId(Long userId) {
        this.validateUserId(userId);
        return userRepository.findByUserid(userId);
    }

    public void validateUserId(Long userId) {
        userRepository.findByUserid(userId).orElseThrow(
                () -> new UserNotFoundException(userId));
    }
}
