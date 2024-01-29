import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            ProjectService projectService = new ProjectService();
            TaskManagementService taskService = new TaskManagementService(projectService);

            User user1 = new User("email1");
            User user2 = new User("email2");
            Project project1 = projectService.create("Project1");

            taskService.registerUser(user1);
            taskService.registerUser(user2);

            Task task11 = taskService.createTask(user1, project1, "Task11");
            Task task21 = taskService.createTask(user2, project1, "Task21");

            System.out.println(taskService.getTask(task11.getId()).getTitle() + " " + taskService.getTask(task11.getId()).getStatus());

            taskService.deleteTask(task11.getId());

            List<Task> tasks = taskService.getTasks(project1.getId(), TaskStatus.CREATED);

            for (Task task : tasks) {
                System.out.println(task.getTitle() + " " + task.getStatus());
            }

            System.out.println(projectService.delete(project1));
            System.out.println(projectService.delete(project1));
        }
        catch (Exception e) {
            System.out.println(e.getClass().getSimpleName());
            e.printStackTrace();
        }
    }
}
