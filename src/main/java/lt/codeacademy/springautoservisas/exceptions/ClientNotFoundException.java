package lt.codeacademy.springautoservisas.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ClientNotFoundException extends RuntimeException {

    private final UUID clientId;

    public ClientNotFoundException(String messageCode, UUID clientId) {
        super(messageCode);
        this.clientId = clientId;
    }
}