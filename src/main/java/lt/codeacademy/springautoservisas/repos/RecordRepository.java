package lt.codeacademy.springautoservisas.repos;

import lt.codeacademy.springautoservisas.entities.RecordOfService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface RecordRepository extends JpaRepository<RecordOfService, UUID> {

    Page<RecordOfService> findAllByClientId(Pageable pageable, UUID id);

    RecordOfService findByPlateNrAndRegTime(String plateNr, String regTime);
}
