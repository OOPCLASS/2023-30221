import java.util.*;
import java.util.stream.Collectors;

public class TaskManagementService {
    public ProjectService projectService = new ProjectService();
    private Map<String, User> users = new HashMap<>();
    private Long nextID = 1L; // pentru a genera ID-uri unice pentru sarcini

    User registerUser(String email) throws EmailAlreadyTakenException {
        if (users.containsKey(email)) {
            throw new EmailAlreadyTakenException("This email is already taken");
        }

        User newUser = new User();
        newUser.setId(email);
        newUser.setTasks(new ArrayList<>());
        users.put(email, newUser);
        return newUser;
    }

    Task createTask(User user, Project project, String title) {
        Task newTask = new Task();
        newTask.setId(nextID++);
        newTask.setTitle(title);
        newTask.setStatus(TaskStatus.Created);

        project.getTasks().add(newTask);
        user.getTasks().add(newTask);
        return newTask;
    }

    Task getTask(Long id) {
        for (User user : users.values()) {
            for (Task task : user.getTasks()) {
                if (task.getId().equals(id)) {
                    return task;
                }
            }
        }
        throw new NoSuchElementException("Task not found");
    }

    void updateTask(Long id, String newTitle, TaskStatus newStatus) {
        Task task = getTask(id);
        task.setTitle(newTitle);
        task.setStatus(newStatus);
    }

    boolean deleteTask(Long id) {
        Task task = getTask(id);
        for (User user : users.values()) {
            if (user.getTasks().remove(task)) {
                for (Project project : projectService.getAllProjects().values()) {
                    if (project.getTasks().remove(task)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    List<Task> getTasks(Long projectId, TaskStatus status) {
        return projectService.get(projectId).getTasks().stream()
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }

    Map<Project, List<Task>> getTasks(TaskStatus status) {
        Map<Project, List<Task>> tasks = new HashMap<>();
        for (Project project : projectService.getAllProjects().values()) {
            List<Task> projectTasks = project.getTasks().stream()
                    .filter(task -> task.getStatus() == status)
                    .collect(Collectors.toList());
            if (!projectTasks.isEmpty()) {
                tasks.put(project, projectTasks);
            }
        }
        return tasks;
    }
}