import java.time.LocalDateTime;
import java.util.List;

public class Project extends AbstractEntity<Long> {
    private String title;
    private List<Task> tasks;
    private LocalDateTime creationTime;

    public Project(Long id, String title, List<Task> tasks, LocalDateTime creationTime) {
        super(id);
        this.title = title;
        this.tasks = tasks;
        this.creationTime = creationTime;
        this.creationTime = LocalDateTime.now();
    }

    public Project(Long id, String title, List<Task> tasks) {
        super(id);
        this.title = title;
        this.tasks = tasks;
    }

    public Project(Long id, List<Task> tasks) {
        super(id);
        this.tasks = tasks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void addTask(Task task) {
        tasks.add(task);
        task.setProjectId(this.getId());
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void updateTask(Task task) {
        Task existingTask = getTaskById(task.getId());
        existingTask.setTitle(task.getTitle());
        existingTask.setStatus(task.getStatus());
    }

    public Task getTaskById(Long taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        throw new TaskNotFoundException("Task not found with ID: " + taskId);
    }


}
