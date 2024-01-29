import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Initialize ProjectService and TaskManagementService
        ProjectService projectService = new ProjectService();
        TaskManagementService taskManagementService = new TaskManagementService(projectService);

        // Create a user
        User user1 = new User("1", "user1@gmail.com", new ArrayList<>());
        User user2 = new User("2", "user2@gmail.com", new ArrayList<>());
        User user3 = new User("3", "user3@gamil.com", new ArrayList<>());

        try {
            // Register the user
            User registeredUser1 = taskManagementService.registeruser(user1);
            User registeredUser2 = taskManagementService.registeruser(user2);
            User registeredUser3 = taskManagementService.registeruser(user3);
            System.out.println("Registered Users: ");
            for (User user : taskManagementService.getUsers().values()) {
                System.out.println(user.getEmail());
            }
            System.out.println("\n");

            // Create a project
            Project project1 = new Project(1L, "Project 1", new ArrayList<>());
            Project project2 = new Project(2L, "Project 2", new ArrayList<>());
            Project project3 = new Project(3L, "Project 3", new ArrayList<>());
            projectService.create(project1);
            projectService.create(project2);
            projectService.create(project3);

            // Create a task for the project
            taskManagementService.createTask(user1, project1);
            taskManagementService.createTask(user2, project3);
            taskManagementService.createTask(user3, project2);

            // Get the task
            Task task1 = taskManagementService.getTask(1L);
            Task task2 = taskManagementService.getTask(1L);
            Task task3 = taskManagementService.getTask(1L);
            System.out.println("Task Title: " + task1.getTitle());
            System.out.println("Task Title: " + task2.getTitle());
            System.out.println("\n");

            // Update the task
            task1.setTitle("Updated Task 1");
            task2.setTitle("Updated Task 2");
            Project updatedProject1 = taskManagementService.updateTask(task1, project1);
            Project updatedProject2 = taskManagementService.updateTask(task2, project2);
            System.out.println("Updated Project Title: " + updatedProject1.getTitle());
            System.out.println("Updated Project Title: " + updatedProject2.getTitle());
            System.out.println("\n");

            // Delete the task
            boolean taskDeleted = taskManagementService.deletetask(1L);
            System.out.println("Task Deleted: " + taskDeleted);
            System.out.println("\n");

            // Get tasks by status
            task2.setStatus(TaskStatus.IN_PROGRESS);
            System.out.println("Status task 2: " + task2.getStatus());

        } catch (EmailAlreadyTakenException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
