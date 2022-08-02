package lt.codeacademy.springautoservisas.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserNotFoundException extends RuntimeException {

        private final String userId;

    public UserNotFoundException(String messageCode, String userId) {
            super(messageCode);
            this.userId = userId;
    }
}

