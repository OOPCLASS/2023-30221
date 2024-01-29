import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        TaskManagementService taskManagementService = new TaskManagementService();

        try {
            // User Registration
            User john = taskManagementService.registerUser("john@example.com");
            User anna = taskManagementService.registerUser("anna@example.com");

            //Trigger EmailAlreadyTakenException
            try {
                User duplicateJohn = taskManagementService.registerUser("john@example.com");
            } catch (EmailAlreadyTakenException e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }

            // Project Creation
            Project johnsProject = taskManagementService.projectService.create("John's project");
            Project annasProject = taskManagementService.projectService.create("Anna's project");

            //Trigger DuplicateProjectNameException
            try {
                Project duplicateProject = taskManagementService.projectService.create("John's project");
            } catch (DuplicateProjectNameException e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }

            // Task Creation
            Task johnsTask1 = taskManagementService.createTask(john, johnsProject, "John's task 1");
            Task johnsTask2 = taskManagementService.createTask(john, johnsProject, "John's task 2");
            Task annasTask1 = taskManagementService.createTask(anna, annasProject, "Anna's task 1");

            //Trigger NoSuchElementException when getting a task
            try {
                Task nonExistentTask = taskManagementService.getTask(999L);
            } catch (NoSuchElementException e) {
                System.out.println("EXCEPTION: Task not found");
            }

            // Update Task
            taskManagementService.updateTask(johnsTask1.getId(), "John's updated task 1", TaskStatus.IN_Progress);

            // Filter and Print Tasks based on statuses
            System.out.println("\nTasks In Progress:");
            Map<Project, List<Task>> tasksInProgress = taskManagementService.getTasks(TaskStatus.IN_Progress);
            for (Map.Entry<Project, List<Task>> entry : tasksInProgress.entrySet()) {
                System.out.printf("Project: %s%n", entry.getKey().getTitle());
                for (Task task : entry.getValue()) {
                    System.out.printf("Task: %s, Status: %s%n", task.getTitle(), task.getStatus());
                }
            }

            // Delete a task
            System.out.println("\nDeleting task: " + johnsTask1.getTitle());
            taskManagementService.deleteTask(johnsTask1.getId());

            // Show that task has been deleted
            System.out.println("John's tasks after deletion:");
            for (Task task : taskManagementService.getTasks(johnsProject.getId(), TaskStatus.Created)) {
                System.out.println(task.getTitle());
            }
            System.out.println("Deleted task is not displayed.");

            // Attempt to delete a project with tasks IN_Progress
            System.out.println("\nAttempting to delete Anna's project:");
            boolean deleted = taskManagementService.projectService.delete(annasProject.getId());
            if (deleted) {
                System.out.println("Project was deleted.");
            } else {
                System.out.println("Project could not be deleted as it has tasks IN_Progress.");
            }

            //Trigger ProjectNotFoundException when getting a project
            try {
                Project nonexistentProject = taskManagementService.projectService.get(999L);
            } catch (ProjectNotFoundException e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }

        } catch(EmailAlreadyTakenException | DuplicateProjectNameException | ProjectNotFoundException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }
}