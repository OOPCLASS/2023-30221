import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TaskManagementService taskManagementService = new TaskManagementService();
        Project ok = taskManagementService.getProjectService().createProject("ok", LocalDate.now());
        User one = taskManagementService.registerUser(new User("some email"));
        //User two = taskManagementService.registerUser(new User("some email"));
        taskManagementService.createTask(one, ok, "oneTask");
        System.out.println(one.getTasks().isEmpty());
    }
}