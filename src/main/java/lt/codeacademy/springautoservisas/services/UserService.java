package lt.codeacademy.springautoservisas.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.entities.User;
import lt.codeacademy.springautoservisas.repos.UserRepository;
import lt.codeacademy.springautoservisas.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> listAll() {

        return (List<User>) userRepository.findAll();
    }

    public void saveUser(User user) {

        user.setId(UUID.randomUUID());
        userRepository.save(user);
    }

    public User getUser(UUID id) throws UserNotFoundException {

        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any user with ID ", id);
    }

    public void delete(UUID id) throws UserNotFoundException {
        Long count = userRepository.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any user with ID ", id);
        }
        userRepository.deleteById(id);

    }
}
