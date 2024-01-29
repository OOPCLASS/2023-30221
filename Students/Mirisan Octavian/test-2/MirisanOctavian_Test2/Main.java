import java.util.List;

public class Main {

    public static void main(String[] args)
    {

        ProjectService projectService = new ProjectService();

        Project project = projectService.create();

        Task task1 = new Task(generateId(), "Task 1", TaskStatus.CREATED);
        Task task2 = new Task(generateId(), "Task 2", TaskStatus.IN_PROGRESS);

        project.getTasks().add(task1);
        project.getTasks().add(task2);

        System.out.println("Initial project:");
        Project.printProject(project);

        boolean deleteResult = projectService.delete(project);

        if (deleteResult)
        {
            System.out.println("Project deleted successfully.");
        }
        else
        {
            System.out.println("Project could not be deleted.");
        }

        if (!deleteResult)
        {
            System.out.println("Project after delete attempt:");
            Project.printProject(project);
        }


        TaskManagementService taskManagementService = new TaskManagementService();

        User user = new User(generateId(),"example@gmail.com",List.of());

        try {
            taskManagementService.registerUser(user);
            System.out.println("User registered successfully.");
        } catch (Exceptions.EmailAlreadyTakenException e) {
            System.out.println("Email already taken. Choose a different email.");
        }



        Project projectForTask = projectService.create();
        taskManagementService.createTask(user, projectForTask);

        System.out.println("Project with task added:");
        Project.printProject(projectForTask);

    }




    private static Long generateId()
    {
        return Long.valueOf(System.currentTimeMillis());
    }
}
