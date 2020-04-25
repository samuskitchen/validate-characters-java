package co.com.domain;

public class TypeNotContainException extends RuntimeException {

    public TypeNotContainException(String message) {
        super(message);
    }

    public TypeNotContainException(String message, Throwable cause) {
        super(message, cause);
    }
}