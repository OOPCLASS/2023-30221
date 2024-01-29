package test2oop.exceptions;

public class DuplicateProjectNameException extends RuntimeException{
    public DuplicateProjectNameException(String message) {
        super(message);
    }
}

