public class DuplicateProjectNameException extends RuntimeException{
    public DuplicateProjectNameException() {
        super("A project with the same name already exists.");
    }
}
