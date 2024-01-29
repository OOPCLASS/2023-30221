package pack;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskManagementService taskManagementService = new TaskManagementService();
        ProjectService projectService = new ProjectService();

        try {
            // Creare și înregistrare utilizator
            User user1 = new User(1, "user1@example.com");
            taskManagementService.registerUser(user1);

            // Creare proiect
            projectService.createProject(1, "Project A");

            // Creare și adăugare sarcini la proiect
            taskManagementService.createTask(1, "Task 1", TaskStatus.TODO, 1);
            taskManagementService.createTask(2, "Task 2", TaskStatus.IN_PROGRESS, 1);
            taskManagementService.createTask(3, "Task 3", TaskStatus.DONE, 1);

            // Obținere informații despre proiect și sarcini
            Project project = projectService.getProject(1);
            List<Task> tasksInProgress = taskManagementService.getTasksByStatus(1, TaskStatus.TODO); // Modificat aici

            // Actualizare proiect
            projectService.updateProject(1, "Project A Updated");

            // Ștergere proiect
            boolean projectDeleted = projectService.deleteProject(1);

            // Afisare rezultate
            System.out.println("Project Name: " + project.getName());
            System.out.println("Tasks in Progress: " + tasksInProgress.size());
            System.out.println("Project Deleted: " + projectDeleted);

        } catch (EmailAlreadyTakenException | DuplicateProjectNameException | ProjectNotFoundException e) {
            e.printStackTrace();
        }
    }
}
