package test_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
        // Create instances of ProjectService and TaskManagementService
        ProjectService projectService = new ProjectService();
        TaskManagementService taskManagementService = new TaskManagementService(projectService);

        // Create a project
        Project projectA = projectService.create("Project A");

        // Register a user
        User user1 = new User("user1@example.com");
        taskManagementService.registerUser(user1);

        // Create tasks for the user within the project
        taskManagementService.createTask(user1, projectA, "Task 1", TaskStatus.IN_PROGRESS);
        taskManagementService.createTask(user1, projectA, "Task 2", TaskStatus.OPEN);

        // Create another project
        Project projectB = projectService.create("Project B");

        // Register another user
        User user2 = new User("user2@example.com");
        taskManagementService.registerUser(user2);

        // Create tasks for the second user within the second project
        taskManagementService.createTask(user2, projectB, "Task 3", TaskStatus.COMPLETED);

        // Print tasks with a given status across all projects
        printTasksByStatusInAllProjects(projectService, taskManagementService, TaskStatus.IN_PROGRESS);
        
    }

	 private static void printTasksByStatusInAllProjects(ProjectService projectService, TaskManagementService taskManagementService, TaskStatus status) {
	        List<Project> allProjects = projectService.getAllProjects();

	        for (Project project : allProjects) {
	            System.out.println("Tasks with status " + status + " in project " + project.getTitle() + ":");

	            for (Task task : taskManagementService.getTasks(project.getId(), status)) {
	                System.out.println("Task ID: " + task.getId() +
	                        ", Title: " + task.getTitle() +
	                        ", Status: " + task.getStatus() +
	                        ", Project: " + project.getTitle());
	            }

	            System.out.println();  // Separate projects for better readability
	        }     
}
}
