package lt.codeacademy.springautoservisas.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Long countById(Integer id);
}
