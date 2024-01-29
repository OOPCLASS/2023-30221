import java.util.ArrayList;
import java.util.List;

public class Project extends AbstractEntity<Long> {
    private String title;
    List<Task> tasks;
    private long creationTime;

    public Project(Long id, String title, List<Task> tasks) {
        super(id);
        this.title = title;
        this.tasks = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public long getCreationTime() {
        return creationTime;
    }
}
