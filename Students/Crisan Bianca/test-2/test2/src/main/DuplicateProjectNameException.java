package main;

public class DuplicateProjectNameException extends RuntimeException{
    public DuplicateProjectNameException(String projectName) {
        super("Duplicate project name: " + projectName);
    }
}
