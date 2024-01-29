import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProjectService projectService = new ProjectService();
        List<User> users = new ArrayList<>();
        User user1 = new User("User1");
        users.add(user1);
        TaskManagementService taskManagementService = new TaskManagementService(projectService, users);
        Project project1 = projectService.create("Front-end");
        Project project2 = projectService.create("Back-end");
        Project project3 = projectService.create("Full-stack");

        List<Task> tasks1 = new ArrayList<>();
        taskManagementService.createTask(user1, project1, "GUI");

        Project retrievedProject = projectService.get(project1.getId());
        System.out.println(retrievedProject);


    }
}
