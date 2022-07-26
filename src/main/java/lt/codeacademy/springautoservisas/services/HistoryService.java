package lt.codeacademy.springautoservisas.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.entities.Auto;
import lt.codeacademy.springautoservisas.entities.HistoryOfClient;
import lt.codeacademy.springautoservisas.repos.HistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class HistoryService {

    HistoryRepository historyRepository;

    public Page<HistoryOfClient> getHistoryByClientId(Pageable pageable, UUID id) {

       return historyRepository.findAllByClientId(pageable, id);
    }

    public void addStory(UUID id, Auto auto) {

        HistoryOfClient story = new HistoryOfClient();
        setAttributes(id, auto, story);
        historyRepository.save(story);
    }

    public void update(Auto auto) {

        HistoryOfClient story = historyRepository.findByPlateNrAndRegTime(auto.getPlateNr(), auto.getRegTime());
        setAttributes(auto.getClient().getId(), auto, story);
        historyRepository.save(story);
    }
    private void setAttributes(UUID id, Auto auto, HistoryOfClient story) {
        story.setRegTime(auto.getRegTime());
        story.setClientId(id);
        story.setBrand(auto.getBrand());
        story.setModel(auto.getModel());
        story.setPlateNr(auto.getPlateNr());
        story.setFixed(auto.isFixed());
        story.setCosts(auto.getCosts());
        story.setIssue(auto.getIssue());
        story.setYear(auto.getYear());
    }
}

