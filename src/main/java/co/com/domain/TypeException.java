package co.com.domain;

public class TypeException extends RuntimeException {

    public TypeException(String message) {
        super(message);
    }

    public TypeException(String message, Throwable cause) {
        super(message, cause);
    }
}