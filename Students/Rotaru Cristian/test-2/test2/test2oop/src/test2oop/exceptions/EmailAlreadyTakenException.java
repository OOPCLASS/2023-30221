package test2oop.exceptions;

public class EmailAlreadyTakenException extends Exception{
    public EmailAlreadyTakenException(String message) {
        super(message);
    }
}
