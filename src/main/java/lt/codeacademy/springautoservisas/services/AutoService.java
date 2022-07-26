package lt.codeacademy.springautoservisas.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.entities.Auto;
import lt.codeacademy.springautoservisas.entities.Client;
import lt.codeacademy.springautoservisas.repos.AutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        auto.setClient(client);
        autoRepository.save(auto);
    }

    public Auto getAutoById(String plateNr) {
        return autoRepository.findAutoByPlateNr(plateNr);
    }

    public void saveAuto(Auto auto) {
        autoRepository.save(auto);
    }

    public void reclaimAuto(String plateNr) {

        autoRepository.reclaimAuto(plateNr);
    }

}
