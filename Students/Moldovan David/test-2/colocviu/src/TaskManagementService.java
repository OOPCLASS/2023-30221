import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class TaskManagementService {
    private ProjectService projectService;
    private Map<String, User> users;
    private Long userIdCounter = 1L;

    public TaskManagementService(ProjectService projectService) {
        this.projectService = projectService;
        this.users = new HashMap<>();
    }

    public TaskManagementService(ProjectService projectService, List<User> list) {
        this.projectService = projectService;
        this.users = new HashMap<>();
        for (User user : list) {
            try {
                registerUser(user);
            } catch (EmailAlreadyTakenException e) {

                e.printStackTrace();
            }
        }
    }

    public Map<String, User> getUsers() {
        return new HashMap<>(users);
    }

    public void registerUser(User user) throws EmailAlreadyTakenException {
        if (isEmailTaken(user.getEmail())) {
            throw new EmailAlreadyTakenException("Email already taken: " + user.getEmail());
        }

        user.setId(generateUserEmail());
        users.put(user.getId(), user);
    }



    public void createTask(String userId, Task task) {
        User user = getUser(userId);
        user.getTasks().add(task);
    }

    public void updateTask(String userId, Task updatedTask) {
        User user = getUser(userId);
        List<Task> tasks = user.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getTitle().equals(updatedTask.getTitle())) {
                tasks.set(i, updatedTask);
                return;
            }
        }
        throw new TaskNotFoundException("Task not found with ID: " + updatedTask.getTitle());
    }

    public boolean removeTask(String userEmail, Long taskTitle) {
        User user = getUser(userEmail);
        List<Task> tasks = user.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getTitle().equals(taskTitle)) {
                tasks.remove(i);
                return true;
            }
        }
        throw new TaskNotFoundException("Task not found with ID: " + taskTitle);
    }


    public List<Task> getTasksByProject(String projectTitle) {
        Project project = projectService.getProjectByTitle(projectTitle);
        return project.getTasks();
    }

    public List<Task> getTasksByStatus(String projectTitle, TaskStatus status) {
        Project project = projectService.getProjectByTitle(projectTitle);
        List<Task> tasksWithStatus = new ArrayList<>();
        for (Task task : project.getTasks()) {
            if (task.getStatus().equals(status)) {
                tasksWithStatus.add(task);
            }
        }
        return tasksWithStatus;
    }


    private User getUser(String userId) {
        if (users.containsKey(userId)) {
            return users.get(userId);
        } else {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }
    }



    private boolean isEmailTaken(String email) {
        return users.values().stream().anyMatch(user -> user.getEmail().equals(email));
    }

    private String generateUserEmail() {
        return userIdCounter++ + "@example.com";
    }
}
