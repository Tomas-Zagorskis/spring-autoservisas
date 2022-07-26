package lt.codeacademy.springautoservisas.repos;

import lt.codeacademy.springautoservisas.entities.HistoryOfClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface HistoryRepository extends JpaRepository<HistoryOfClient, UUID> {

    Page<HistoryOfClient> findAllByClientId(Pageable pageable, UUID id);
}
