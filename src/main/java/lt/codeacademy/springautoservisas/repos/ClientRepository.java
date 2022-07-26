package lt.codeacademy.springautoservisas.repos;

import lt.codeacademy.springautoservisas.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    Page<Client> findByNameOrSurnameContainingIgnoreCase(
            Pageable pageable,
            @Param("keyword") String name,
            @Param("keyword") String surname);

}
