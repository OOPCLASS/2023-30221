import java.util.Map;
import java.util.HashMap;
import java.util.List;
public class TaskManagementService {
    private ProjectService projectService;
    private Map<String, User> users;

    public TaskManagementService(ProjectService projectService) {
        this.projectService = projectService;
        this.users = new HashMap<>();
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public User registeruser(User user) throws EmailAlreadyTakenException {
        if (users.values().stream().anyMatch(u -> u.getEmail().equals(user.getEmail()))) {
            throw new EmailAlreadyTakenException("User with id " + user.getId() + " already exists");
        }
        user.setId(String.valueOf(users.size() + 1));
        users.put(user.getId(), user);
        return user;
    }

    public Project createTask(User user, Project project) throws IllegalArgumentException {
        if (!users.containsValue(user)) {
            throw new IllegalArgumentException("User with id " + user.getId() + " not found");
        }
        if (projectService.getProjects().get(project.getId()) == null) {
            throw new IllegalArgumentException("Project with id " + project.getId() + " not found");
        }
        Task newTask = new Task(project.getTasks().size() + 1L, "New Task", TaskStatus.CREATED);
        project.getTasks().add(newTask);
        return project;
    }

    public Task getTask(Long id) throws IllegalArgumentException {
        for (Project project : projectService.getProjects().values()) {
            for (Task task : project.getTasks()) {
                if (task.getId().equals(id)) {
                    return task;
                }
            }
        }
        throw new IllegalArgumentException("Task with id " + id + " not found");
    }

    public Project updateTask(Task updatedTask, Project project) throws IllegalArgumentException {
        if (projectService.getProjects().get(project.getId()) == null) {
            throw new IllegalArgumentException("Project with id " + project.getId() + " not found");
        }
        boolean taskExists = project.getTasks().removeIf(task -> task.getId().equals(updatedTask.getId()));
        if (!taskExists) {
            throw new IllegalArgumentException("Task with id " + updatedTask.getId() + " not found");
        }
        project.getTasks().add(updatedTask);
        return project;
    }

    public boolean deletetask(Long id) {
        for (Project project : projectService.getProjects().values()) {
            project.getTasks().removeIf(task -> task.getId().equals(id));
        }
        return true;
    }

    public List<Task> getTasks(Long projectId, TaskStatus taskStatus) throws IllegalArgumentException {
        Project project = projectService.getProjects().get(projectId);
        if (project != null) {
            return project.getTasks().stream().filter(task -> task.getStatus() == taskStatus).toList();
        }
        else {
            throw new IllegalArgumentException("Project with id " + projectId + " not found");
        }
    }
}
