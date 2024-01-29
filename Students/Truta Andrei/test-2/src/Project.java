import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Project extends AbstractEntity<Long> {
    private String title;
    private List<Task> tasks = new ArrayList<Task>();

    private LocalDateTime createdAt;

    public static Long nextId = 1L;

    public static Long getNextId() {
        return nextId++;
    }

    public Project(String title) {
        this.title = title;
        this.setId(getNextId());
        this.createdAt = LocalDateTime.now();
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

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Project{" + "title='" + title + '\'' + '}';
    }
}
