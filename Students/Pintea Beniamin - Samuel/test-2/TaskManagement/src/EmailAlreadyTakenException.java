public class EmailAlreadyTakenException extends RuntimeException{
    public EmailAlreadyTakenException() {
        super("Email already taken");
    }
}
