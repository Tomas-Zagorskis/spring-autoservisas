package lt.codeacademy.springautoservisas.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.entities.HistoryOfAutos;
import lt.codeacademy.springautoservisas.repos.HistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class HistoryService {

    HistoryRepository historyRepository;

    public Page<HistoryOfAutos> getHistoryByClientId(Pageable pageable, UUID id) {

       return historyRepository.findAllByClientId(pageable, id);
    }
}