import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Project<Long> extends AbstractEntity<String> {
    private String title;
    private LocalDateTime creationDate;
    List<Task<Long>> tasks = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<Task<Long>> getTasks() {
        return this.tasks;
    }
}
