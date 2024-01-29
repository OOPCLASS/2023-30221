package test_2;

import java.util.ArrayList;
import java.util.List;

public class TaskManagementService {
	private ProjectService projectService;
    private List<User> users = new ArrayList<>();

    // Constructor
    public TaskManagementService(ProjectService projectService) {
        this.projectService = projectService;
    }

    // Register a new user
    public User registerUser(User user){
    	if (isEmailTaken(user.getEmail())) {
            throw new RuntimeException("Email " + user.getEmail() + " is already taken.");
        }
        users.add(user);
        return user;
    }

    // Create a new task for a user within a project
    public void createTask(User user, Project project, String taskTitle, TaskStatus taskStatus) {
    	if (!projectService.getAllProjects().contains(project)) {
            throw new RuntimeException("Project does not exist.");
        }
        Task newTask = new Task(taskTitle, taskStatus);
        user.addTask(newTask);
        project.addTask(newTask);
    }

    public List<Task> getTasks(Long projectId, TaskStatus status) {
        Project project = projectService.get(projectId);
        if (project != null) {
            List<Task> tasks = new ArrayList<>();
            for (User user : users) {
                for (Task task : user.getTasks()) {
                    if (task.getStatus() == status && project.getTasks().contains(task)) {
                        tasks.add(task);
                    }
                }
            }
            return tasks;
        } else {
            throw new RuntimeException("Project with ID " + projectId + " not found.");
        }
    }

    // Update a task within a project
    public void updateTask(Task task, Project project) {
    	if (!projectService.getAllProjects().contains(project)) {
            throw new RuntimeException("Project does not exist.");
        }
        projectService.update(project.getId(), project);
    }

    // Delete a task by ID
    public void deleteTask(Long taskId) {
        for (User user : users) {
            List<Task> userTasks = user.getTasks();
            userTasks.removeIf(task -> task.getId().equals(taskId));
            return;
        }
        throw new RuntimeException("Task with ID " + taskId + " not found.");
    }
    private boolean isEmailTaken(String email) {
        for (User existingUser : users) {
            if (existingUser.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

}
