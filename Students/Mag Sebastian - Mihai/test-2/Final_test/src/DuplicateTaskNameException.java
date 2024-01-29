public class DuplicateTaskNameException extends RuntimeException{
    public DuplicateTaskNameException() {
        super("A task with the same name already exists.");
    }
}
