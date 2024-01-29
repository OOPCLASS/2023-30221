import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProjectService projectService = new ProjectService();
        TaskManagementService taskManagementService = new TaskManagementService(projectService);


        User user1 = new User("user1@example.com");
        User user2 = new User("user2@example.com");

        try {

            taskManagementService.registerUser(user1);
            taskManagementService.registerUser(user2);


            LocalDateTime projectCreationDateTime = LocalDateTime.of(2022, 1, 1, 12, 0);
            Project project = new Project("Project 1", projectCreationDateTime);


            projectService.addProject(project);


            Task task1 = new Task("Task 1", TaskStatus.CREATED);
            Task task2 = new Task("Task 2", TaskStatus.IN_PROGRESS);


            taskManagementService.createTask(user1.getId(), project.getId(), task1);
            taskManagementService.createTask(user2.getId(), project.getId(), task2);


            Task retrievedTask = taskManagementService.getTask(task1.getId());
            System.out.println("Retrieved Task: " + retrievedTask.getTitle());


            retrievedTask.setStatus(TaskStatus.DONE);
            taskManagementService.updateTask(retrievedTask.getId(), retrievedTask);
            System.out.println("Updated Task Status: " + retrievedTask.getStatus());


            List<Task> tasksByStatus = taskManagementService.getTasksByProjectAndStatus(project.getId(), TaskStatus.DONE);
            System.out.println("Tasks in Project with Status DONE:");
            for (Task task : tasksByStatus) {
                System.out.println("- " + task.getTitle());
            }


            boolean taskDeleted = taskManagementService.deleteTask(task2.getId());
            System.out.println("Task Deletion Status: " + (taskDeleted ? "Success" : "Failed"));


            List<Task> allTasksByStatus = taskManagementService.getAllTasksByStatus(TaskStatus.CREATED);
            System.out.println("All Tasks with Status CREATED:");
            for (Task task : allTasksByStatus) {
                System.out.println("- " + task.getTitle());
            }

        } catch (EmailAlreadyTakenException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (ProjectNotFoundException | TaskNotFoundException | UserNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}