package main;

public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException(Long projectId) {
        super("Project not found with ID: " + projectId);
    }
}
