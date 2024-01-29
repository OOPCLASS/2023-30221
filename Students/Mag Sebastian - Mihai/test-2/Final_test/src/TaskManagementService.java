import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskManagementService {
    private List<User> users;
    private List<Task> tasks;
    private static final AtomicInteger projectIdCounter = new AtomicInteger(1);
    public TaskManagementService() {
        this.users = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }
    private int generateUniqueId() {
        return projectIdCounter.getAndIncrement();
    }
    public void registerUser(User user) throws EmailAlreadyTakenException {
        if (users.stream().anyMatch(u -> u.getEmail().equals(user.getEmail()))) {
            throw new EmailAlreadyTakenException();
        }
        user.setId(generateUniqueId());
        users.add(user);
    }
    public void createTask(Task task) throws DuplicateTaskNameException {
        if (tasks.stream().anyMatch(t -> t.getName().equals(task.getName()))) {
            throw new DuplicateTaskNameException();
        }
        task.setId(generateUniqueId());
        tasks.add(task);
    }

    public Task getTaskById(int taskId) throws TaskNotFoundException {
        return tasks.stream()
                .filter(t -> t.getId() == taskId)
                .findFirst()
                .orElseThrow(TaskNotFoundException::new);
    }

    public void updateTask(Task task) throws TaskNotFoundException {
        int index = findTaskIndexById(task.getId());
        if (index == -1) {
            throw new TaskNotFoundException();
        }
        tasks.set(index, task);
    }

    public void deleteTask(int taskId) throws TaskNotFoundException {
        Task task = getTaskById(taskId);
        tasks.remove(task);
    }

    public List<Task> getTasksByProjectAndStatus(int projectId, TaskStatus status) {
        return tasks.stream()
                .filter(t -> t.getProjectId() == projectId && t.getStatus() == status)
                .toList();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return tasks.stream()
                .filter(t -> t.getStatus() == status)
                .toList();
    }

    private int findTaskIndexById(int taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == taskId) {
                return i;
            }
        }
        return -1;
    }
}
