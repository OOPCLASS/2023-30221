import java.util.ArrayList;
import java.util.List;

public class TaskManagementService {
    ProjectService projectService;
    List<User<String>> users = new ArrayList<>();
    private static Long nextId = 1L;

    public User<String> registerUser(User<String> user) throws EmailAlreadyTakenException {
        for (User<String> existingUser : users) {
            if (existingUser.getEmail().equals(user.getEmail())) {
                throw new EmailAlreadyTakenException("A user with the same email already exists.");
            }
        }

        user.setId(nextId.toString());
        nextId++;
        users.add(user);

        return user;
    }

    public Project<Long> createTask(User<String> user, Project<Long> project) {
        if (!users.contains(user)) {
            throw new UserNotFoundException("User not found.");
        }

        if (!projectService.getProjects().containsValue(project)) {
            throw new ProjectNotFoundException("Project not found.");
        }

        Task<Long> task = new Task();

        task.setId(nextId);
        nextId++;
        project.getTasks().add(task);

        return project;
    }

    public Task<Long> getTask(Long id) {
        for (Project<Long> project : projectService.getProjects().values()) {
            for (Task<Long> task : project.getTasks()) {
                if (task.getId().equals(id)) {
                    return task;
                }
            }
        }
        throw new TaskNotFoundException("Task with id " + id + " not found.");
    }

    public Project<Long> updateTask(Task<Long> task, Project<Long> project) {
        if (!projectService.getProjects().containsValue(project)) {
            throw new ProjectNotFoundException("Project not found.");
        }

        List<Task<Long>> tasks = project.getTasks();

        int index = tasks.indexOf(task);

        if (index == -1) {
            throw new TaskNotFoundException("Task not found.");
        }

        tasks.set(index, task);

        return project;
    }

    public boolean deleteTask(Long id) {
        for (Project<Long> project : projectService.getProjects().values()) {
            List<Task<Long>> tasks = project.getTasks();

            for (Task<Long> task : tasks) {
                if (task.getId().equals(id)) {
                    tasks.remove(task);
                    return true;
                }
            }
        }

        return false;
    }

    public List<Task<Long>> getTasks(Long projectId) {
        Project<Long> project = projectService.get(projectId.toString());

        if (project == null) {
            throw new ProjectNotFoundException("Project with id " + projectId + " not found.");
        }

        return project.getTasks();
    }

    public List<Task<Long>> getTasks(TaskStatus status) {
        List<Task<Long>> tasksWithStatus = new ArrayList<>();

        for (Project<Long> project : projectService.getProjects().values()) {
            for (Task<Long> task : project.getTasks()) {
                if (task.getStatus() == status) {
                    tasksWithStatus.add(task);
                }
            }
        }

        return tasksWithStatus;
    }
}
