package lt.codeacademy.springautoservisas.repos;

import lt.codeacademy.springautoservisas.entities.HistoryOfAutos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface HistoryRepository extends JpaRepository<HistoryOfAutos, UUID> {

    Page<HistoryOfAutos> findAllByClientId(Pageable pageable, UUID id);
}
