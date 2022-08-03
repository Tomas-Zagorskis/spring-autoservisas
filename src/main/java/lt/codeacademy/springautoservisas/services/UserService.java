package lt.codeacademy.springautoservisas.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.entities.User;
import lt.codeacademy.springautoservisas.exceptions.UserNotFoundException;
import lt.codeacademy.springautoservisas.repos.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserWithRoles(username)
                .orElse(null);
    }

    public Page<User> listAll(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

    public void saveNewUser(User user) {

        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(10, new SecureRandom());
        String encoded = "{bcrypt}" + bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encoded);
        userRepository.save(user);
    }

    public void saveUser(User user) {

        User userUpdate = userRepository.findById(user.getUsername()).orElse(null);
        userUpdate.setAge(user.getAge());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setRoles(user.getRoles());

        userRepository.save(userUpdate);
    }

    public User getUser(String id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("msg.user.not.found", id));
    }

    public void delete(String id) {

        userRepository.delete(getUser(id));

    }
}
