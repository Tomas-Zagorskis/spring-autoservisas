package lt.codeacademy.springautoservisas.repos;

import lt.codeacademy.springautoservisas.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
