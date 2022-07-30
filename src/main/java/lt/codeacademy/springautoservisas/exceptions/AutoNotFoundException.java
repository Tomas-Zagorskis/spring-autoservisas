package lt.codeacademy.springautoservisas.exceptions;

import lombok.Getter;

@Getter
public class AutoNotFoundException extends RuntimeException {
    private final String autoId;

    public AutoNotFoundException(String messageCode, String autoId) {
        super(messageCode);
        this.autoId = autoId;
    }
}