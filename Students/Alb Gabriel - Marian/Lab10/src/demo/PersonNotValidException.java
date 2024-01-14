package demo;

public class PersonNotValidException extends Exception {
    public PersonNotValidException(String message) {
        super(message);
    }
}