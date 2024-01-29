import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskManagementService taskManagementService = new TaskManagementService();
        User user1 = new User("ursug");
        User user2 = new User("ursug");
        User user3 = new User("georgeu");

        taskManagementService.registerUser(user1);
        taskManagementService.registerUser(user3);

        ProjectService projectService = new ProjectService();
        Project project1 = projectService.create("LABORATOR");
        taskManagementService.registerUser(user2);

    }
}