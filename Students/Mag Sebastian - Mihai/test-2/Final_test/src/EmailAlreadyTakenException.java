public class EmailAlreadyTakenException extends Exception{
    public EmailAlreadyTakenException() {
        super("Email is already taken.");
    }
}
