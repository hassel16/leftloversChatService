package dhbw.leftlovers.service.chat.security.service;

import dhbw.leftlovers.service.chat.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class TokenAuthenticationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public TokenAuthenticationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository
                .findByUsername(username)
                .map(user -> {
                    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());
                }).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
