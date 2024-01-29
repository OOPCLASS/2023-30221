import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Task task1 = new Task("Task 1", TaskStatus.CREATED);
        Task task2 = new Task("Task 2", TaskStatus.IN_PROGRESS);
        Task task3 = new Task("Task 3", TaskStatus.DONE);

        List<Task> projectTasks = new ArrayList<>();
        projectTasks.add(task1);
        projectTasks.add(task2);
        projectTasks.add(task3);

        Project project = new Project("My Project", projectTasks);


        List<Task> userTasks = new ArrayList<>();
        userTasks.add(task1);

        User user = new User("user@example.com", userTasks);


        List<User> userList = new ArrayList<>();
        userList.add(user);


        ProjectService projectService = new ProjectService();
        TaskManagementService taskManagementService = new TaskManagementService(projectService, userList);


        projectService.addProject(project);


        try {
            taskManagementService.registerUser(new User("anotheruser@example.com", new ArrayList<>()));
        } catch (EmailAlreadyTakenException e) {
            e.printStackTrace();
        }


        Task newTask = new Task("New Task", TaskStatus.CREATED);
        taskManagementService.createTask(user.getId(), newTask);


        List<Task> tasksInProgress = taskManagementService.getTasksByStatus(project.getTitle(),TaskStatus.IN_PROGRESS);
        System.out.println("Tasks in progress: " + tasksInProgress);


        newTask.setStatus(TaskStatus.IN_PROGRESS);
        taskManagementService.updateTask(user.getId(), newTask);


        tasksInProgress = taskManagementService.getTasksByStatus(project.getTitle(), TaskStatus.IN_PROGRESS);
        System.out.println("Updated tasks in progress: " + tasksInProgress);


        boolean projectRemoved = projectService.removeProject("My Project");
        System.out.println("Project removed: " + projectRemoved);


        try {
            Project removedProject = projectService.getProjectByTitle("My Project");
            System.out.println("Removed Project: " + removedProject);
        } catch (ProjectNotFoundException e) {
            System.out.println("Project not found: " + e.getMessage());
        }
    }
}
