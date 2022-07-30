package lt.codeacademy.springautoservisas.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.entities.Auto;
import lt.codeacademy.springautoservisas.entities.Client;
import lt.codeacademy.springautoservisas.exceptions.AutoNotFoundException;
import lt.codeacademy.springautoservisas.repos.AutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Service
public class AutoService {

    private final AutoRepository autoRepository;

    public Page<Auto> getAutos(Pageable pageable) {

        return autoRepository.findAll(pageable);
    }

    public Page<Auto> findByKeyword(Pageable pageable, String keyword) {

        return autoRepository.findByKeyword(pageable, keyword);
    }

    public void addAuto(Auto auto, Client client) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        auto.setRegTime(now.format(format));
        auto.setClient(client);
        autoRepository.save(auto);
    }

    public Auto getAutoById(String plateNr) {
        return autoRepository.findById(plateNr)
                .orElseThrow(() -> new AutoNotFoundException("msg.auto.not.found", plateNr));
    }

    public void saveAuto(Auto auto) {
        autoRepository.save(auto);
    }

    public void reclaimAuto(String plateNr) {

        autoRepository.reclaimAuto(plateNr);
    }
}
