package lt.codeacademy.springautoservisas.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.entities.User;
import lt.codeacademy.springautoservisas.exceptions.UserNotFoundException;
import lt.codeacademy.springautoservisas.repos.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserWithRoles(username)
                .orElseThrow(() -> new UserNotFoundException("msg.user.not.found", username));
    }

    public List<User> listAll() {

        return userRepository.findAll();
    }

    public void saveUser(User user) {

        userRepository.save(user);
    }

    public User getUser(String id) throws UserNotFoundException {

        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("msg.user.not.found", id);
    }

    public void delete(String id) throws UserNotFoundException {
        Long count = userRepository.countByUsername(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("msg.user.not.found", id);
        }
        userRepository.deleteById(id);

    }
}
