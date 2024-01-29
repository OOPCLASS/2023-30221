import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProjectService projectService = new ProjectService();

        Project project1 = projectService.create("Project 1");

        Task task1 = new Task(1L, "Task 1", TaskStatus.Created);
        Task task2 = new Task(2L, "Task 2", TaskStatus.In_Progress);
        project1.getTasks().add(task1);
        project1.getTasks().add(task2);

        List<User> users = new ArrayList<>();
        TaskManagementService taskManagementService = new TaskManagementService(projectService, users);

        User user1 = new User("user1", "user1@example.com", new ArrayList<>());
        try {
            taskManagementService.registerUser(user1);
        } catch (EmailAlreadyTakenException e) {
            System.out.println("Error: " + e.getMessage());
        }

        taskManagementService.createTask(user1, project1, "User1 Task");

        List<Task> inProgressTasks = projectService.getTasksByStatus(project1.getId(), TaskStatus.In_Progress);
        System.out.println("In Progress Tasks in Project 1: " + inProgressTasks);

        boolean taskDeleted = taskManagementService.deleteTask(task1.getId(), project1);
        System.out.println("Task 1 Deleted: " + taskDeleted);
    }
}
