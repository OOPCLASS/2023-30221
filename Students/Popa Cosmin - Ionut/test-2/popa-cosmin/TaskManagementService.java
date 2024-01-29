import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
class TaskManagementService {
    private ProjectService projectService;
    private List<User> users;

    public TaskManagementService(ProjectService projectService) {
        this.projectService = projectService;
        this.users = new ArrayList<>();
    }

    public User registerUser(User user) throws EmailAlreadyTakenException {
        // Check for duplicate email
        if (users.stream().anyMatch(u -> u.getEmail().equals(user.getEmail()))) {
            throw new EmailAlreadyTakenException("Email is already registered");
        }

        // Assign a unique ID to the user
        user.setId(generateUniqueUserId());

        // Store the user in the collection
        users.add(user);

        return user;
    }

    private String generateUniqueUserId() {
        // Replace this with a proper ID generation logic (e.g., using UUID)
        // For simplicity, using the current time in milliseconds as a placeholder
        return String.valueOf(System.currentTimeMillis());
    }

    public void createTask(User user, Project project, String taskTitle) {
        // Check if the user is associated with the project
        if (!project.getUsers().contains(user)) {
            throw new RuntimeException("User is not associated with the project");
        }

        // Create a new task with a unique ID
        Long newTaskId = generateUniqueTaskId();
        Task newTask = new Task(newTaskId, taskTitle, TaskStatus.CREATED);

        // Add the task to the user and project
        user.getTasks().add(newTask);
        project.getTasks().add(newTask);
    }

    private Long generateUniqueTaskId() {
        // Replace this with a proper ID generation logic (e.g., using UUID)
        // For simplicity, using the current time in milliseconds as a placeholder
        return System.currentTimeMillis();
    }



    public Project updateTask(Task task, Project project, String newTitle) {
        // Check if the task is associated with the project
        if (!project.getTasks().contains(task)) {
            throw new RuntimeException("Task is not associated with the project");
        }

        // Update the task's title
        task.setTitle(newTitle);

        return project;
    }

    public boolean deleteTask(Long taskId) {
        // Find and remove the task with the provided ID from users
        boolean userTaskDeleted = users.stream()
                .anyMatch(user -> user.getTasks().removeIf(task -> task.getId().equals(taskId)));

        // Find and remove the task with the provided ID from projects
        boolean projectTaskDeleted = projectService.getProjects().stream()
                .anyMatch(project -> project.getTasks().removeIf(task -> task.getId().equals(taskId)));

        // Return true if the task was deleted from either users or projects
        return userTaskDeleted || projectTaskDeleted;
    }


    public List<Task> getTasks(Long projectId, TaskStatus taskStatus) {
        // Get tasks from the specified project with the given status
        return projectService.getProjects().stream()
                .filter(project -> project.getId().equals(projectId))
                .findFirst()
                .map(project -> project.getTasks().stream()
                        .filter(task -> task.getStatus() == taskStatus)
                        .toList())
                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + projectId));
    }
    public Map<Project, List<Task>> getTasks(TaskStatus taskStatus) {
        // Get tasks with the provided status from all projects
        Map<Project, List<Task>> tasksByProject = new HashMap<>();

        projectService.getProjects().forEach(project -> {
            List<Task> tasksInProject = project.getTasks().stream()
                    .filter(task -> task.getStatus() == taskStatus)
                    .collect(Collectors.toList());

            if (!tasksInProject.isEmpty()) {
                tasksByProject.put(project, tasksInProject);
            }
        });

        return tasksByProject;
    }
    public void updateTaskStatus(Task task, TaskStatus newStatus) {
        task.setStatus(newStatus);
    }


}