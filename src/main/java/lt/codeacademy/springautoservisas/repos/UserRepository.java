package lt.codeacademy.springautoservisas.repos;

import lt.codeacademy.springautoservisas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Long countById(UUID id);
}
