package lt.codeacademy.springautoservisas.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.entities.Auto;
import lt.codeacademy.springautoservisas.entities.RecordOfService;
import lt.codeacademy.springautoservisas.repos.RecordRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RecordService {

    RecordRepository recordRepository;

    public Page<RecordOfService> getRecordsByClientId(Pageable pageable, UUID id) {

       return recordRepository.findAllByClientId(pageable, id);
    }

    public void addRecord(UUID id, Auto auto) {

        RecordOfService record = new RecordOfService();
        setAttributes(id, auto, record);
        recordRepository.save(record);
    }

    public void update(Auto auto) {

        RecordOfService recordUpdate = recordRepository.findByPlateNrAndRegTime(auto.getPlateNr(), auto.getRegTime());
        setAttributes(auto.getClient().getId(), auto, recordUpdate);
        recordRepository.save(recordUpdate);
    }
    private void setAttributes(UUID id, Auto auto, RecordOfService record) {
        record.setRegTime(auto.getRegTime());
        record.setClientId(id);
        record.setBrand(auto.getBrand());
        record.setModel(auto.getModel());
        record.setPlateNr(auto.getPlateNr());
        record.setFixed(auto.isFixed());
        record.setCosts(auto.getCosts());
        record.setIssue(auto.getIssue());
        record.setYear(auto.getYear());
    }

    public Page<RecordOfService> getAllRecords(Pageable pageable) {
        return recordRepository.findAll(pageable);
    }
}

