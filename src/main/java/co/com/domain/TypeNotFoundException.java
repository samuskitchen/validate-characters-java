package co.com.domain;

public class TypeNotFoundException extends RuntimeException {

    public TypeNotFoundException(String message) {
        super(message);
    }

    public TypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}