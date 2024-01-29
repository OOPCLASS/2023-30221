package test2oop.exceptions;

public class DuplicateTaskNameException extends RuntimeException{
    public DuplicateTaskNameException(String message) {
        super(message);
    }
}
