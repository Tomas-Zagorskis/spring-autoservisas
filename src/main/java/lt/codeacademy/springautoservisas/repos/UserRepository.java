package lt.codeacademy.springautoservisas.repos;

import lt.codeacademy.springautoservisas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Long countById(Integer id);
}
