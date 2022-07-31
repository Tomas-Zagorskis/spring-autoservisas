package lt.codeacademy.springautoservisas.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserNotFoundException extends RuntimeException {

        private final UUID userId;

    public UserNotFoundException(String messageCode, UUID userId) {
            super(messageCode);
            this.userId = userId;
    }
}

