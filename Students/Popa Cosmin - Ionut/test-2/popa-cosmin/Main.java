import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        // Creăm serviciul de gestionare a proiectelor
        ProjectService projectService = new ProjectService();

        // Creăm serviciul de gestionare a sarcinilor
        TaskManagementService taskManagementService = new TaskManagementService(projectService);

        Task taskInProgress = null; // Declaram variabila taskInProgress

        try {
            // Înregistrăm utilizatori
            User user1 = taskManagementService.registerUser(new User("user1@example.com"));
            User user2 = taskManagementService.registerUser(new User("user2@example.com"));
            User user3 = taskManagementService.registerUser(new User("user3@example.com"));

            // Creăm proiecte
            Project project1 = projectService.create("Project One");
            Project project2 = projectService.create("Project Two");

            // Asociem utilizatori cu proiecte
            project1.getUsers().add(user1);
            project1.getUsers().add(user2);
            project2.getUsers().add(user3);

            // Adăugăm sarcini
            taskManagementService.createTask(user1, project1, "Task 1");
            taskManagementService.createTask(user2, project1, "Task 2");
            taskManagementService.createTask(user3, project2, "Task 3");

            // Marcăm o sarcină ca IN_PROGRESS
            List<Task> tasksInProgress = taskManagementService.getTasks(project1.getId(), TaskStatus.CREATED);
            if (!tasksInProgress.isEmpty()) {
                taskInProgress = tasksInProgress.get(0);
                taskManagementService.updateTask(taskInProgress, project1, "Task 1 - In Progress");
                System.out.println("Task marked as IN_PROGRESS: " + taskInProgress);
            }

            // Afișăm toate sarcinile din proiect cu statusul IN_PROGRESS
            Map<Project, List<Task>> tasksByProjectInProgress = taskManagementService.getTasks(TaskStatus.IN_PROGRESS);
            tasksByProjectInProgress.forEach((p, tasks) -> {
                System.out.println("Tasks in Project '" + p.getTitle() + "' with Status IN_PROGRESS: " + tasks);
            });

            // Actualizăm statusul sarcinii la DONE
            taskManagementService.updateTaskStatus(taskInProgress, TaskStatus.DONE);
            System.out.println("Task marked as DONE: " + taskInProgress);

            // Ștergem o sarcină
            List<Task> tasksInProject1 = taskManagementService.getTasks(project1.getId(), TaskStatus.CREATED);
            if (!tasksInProject1.isEmpty()) {
                Task taskToDelete = tasksInProject1.get(0);
                taskManagementService.deleteTask(taskToDelete.getId());
                System.out.println("Task deleted: " + taskToDelete);
            }

            // Afișăm lista actualizată de sarcini din proiect după ștergere
            List<Task> tasksAfterDeletion = taskManagementService.getTasks(project1.getId(), TaskStatus.CREATED);
            System.out.println("Tasks in Project with Status CREATED after deletion: " + tasksAfterDeletion);

        } catch (EmailAlreadyTakenException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
