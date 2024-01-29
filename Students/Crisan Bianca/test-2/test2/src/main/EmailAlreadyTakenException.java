package main;

public class EmailAlreadyTakenException extends Exception{
    public EmailAlreadyTakenException(String email) {
        super("Email already taken: " + email);
    }
}
