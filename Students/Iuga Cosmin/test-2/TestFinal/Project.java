import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Project extends AbstractEntity {
    private String title;
    private List<Task> tasks;
    private LocalDateTime creationDateTime;

    public Project(String title, LocalDateTime creationDateTime) {
        this.title = title;
        this.tasks = new ArrayList<>();
        this.creationDateTime = creationDateTime;
    }

    public String getTitle() {
        return title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }
}