package taskManagementSystem;

import java.util.List;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws EmailAlreadyTakenException {

        ProjectService projectService = new ProjectService();
        Project project1 = projectService.create("project1");
        Project project2 = projectService.create("project2");
        TaskManagementService taskManagementService = new TaskManagementService(projectService);

        User user = new User("anabizga");
        User user2 = new User("anabizga2");

        try {
            taskManagementService.registerUser(user);
        } catch (EmailAlreadyTakenException e) {
            e.printStackTrace();
        }
        try {
            taskManagementService.registerUser(user2);
        } catch (EmailAlreadyTakenException e) {
            e.printStackTrace();
        }
        try {
            taskManagementService.registerUser(user2);
        } catch (EmailAlreadyTakenException e) {
            e.printStackTrace();
        }

        project1 = taskManagementService.createTask(user, project1, "task1");
        project1 = taskManagementService.createTask(user, project1, "task2");
        project1 = taskManagementService.createTask(user, project1, "task3");

        Task task1 = project1.getTasks().get(0);
        task1.setStatus(TaskStatus.IN_PROGRESS);
        Task task2 = project1.getTasks().get(1);
        task2.setStatus(TaskStatus.DONE);

        taskManagementService.updateTask(task1, project1);
        taskManagementService.updateTask(task2, project1);

        project2 = taskManagementService.createTask(user, project2, "task1");
        project2 = taskManagementService.createTask(user2, project2, "task2");
        project2 = taskManagementService.createTask(user, project2, "task3");

        taskManagementService.displayDetails();
        System.out.println("--------------");

        List<Task> tasks = taskManagementService.getTasks(project1.getId(),TaskStatus.IN_PROGRESS);
        for (Task task : tasks)
            System.out.println(task.getTitle() + " " + task.getId() + " " + task.getStatus());

        System.out.println("--------------");
        
    }
}
