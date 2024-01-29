import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Main {
    public static void main(String[] args) {
        TaskManagementService taskManagementService = new TaskManagementService();

//        LocalDate currentDate = LocalDate.now();
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String formattedDate = currentDate.format(formatter);


        try {
            User user = new User(1,"Gheorghe Ioan", "ioan.gheorghe@gmail.com");
            taskManagementService.registerUser(user);
        } catch (EmailAlreadyTakenException e) {
            System.out.println("Error: " + e.getMessage());
        }


        ProjectService projectService = new ProjectService();
        Project project = new Project(0,"Project A",new Date());
        try {
            projectService.createProject(project);
        } catch (DuplicateProjectNameException e) {
            System.out.println("Error: " + e.getMessage());
        }


        Task task = new Task(project.getId(),"Task 1", "Description for Task 1", TaskStatus.OPEN);
        try {
            taskManagementService.createTask(task);
        } catch (DuplicateTaskNameException e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("Project Details:");
        System.out.println("ID: " + project.getId());
        System.out.println("Name: " + project.getName());
        System.out.println("Creation Date: " + project.getCreationDate());


        List<Task> tasksByProjectAndStatus = taskManagementService.getTasksByProjectAndStatus(project.getId(), TaskStatus.OPEN);
        System.out.println("\nTasks by project and status:");
        tasksByProjectAndStatus.forEach(System.out::println);



        task.setStatus(TaskStatus.IN_PROGRESS);
        try {
            taskManagementService.updateTask(task);
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }


        try {
            taskManagementService.deleteTask(task.getId());
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
