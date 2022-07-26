package lt.codeacademy.springautoservisas.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springautoservisas.entities.Client;
import lt.codeacademy.springautoservisas.exceptions.UserNotFoundException;
import lt.codeacademy.springautoservisas.repos.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Page<Client> getClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    public Page<Client> findByKeyword(Pageable pageable, String keyword) {

        return clientRepository.findByNameOrSurnameContainingIgnoreCase(pageable, keyword, keyword);
    }

    public Client getClientById(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No client found by id"));
    }

    public void saveClient(Client client) {

        clientRepository.save(client);
    }

    public void createClient(Client client) {

        client.setId(UUID.randomUUID());
        saveClient(client);
    }

    public void removeClient(UUID id) {

        clientRepository.delete(getClientById(id));
    }

}
