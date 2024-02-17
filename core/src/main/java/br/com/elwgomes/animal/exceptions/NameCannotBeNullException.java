package br.com.elwgomes.animal.exceptions;

public class NameCannotBeNullException extends Exception {
    public NameCannotBeNullException(String message) {
        super(message);
    }
    public NameCannotBeNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
