import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Project extends AbstractEntity<Long> {
    private String title;

    private List<Task> tasks;

    private LocalDateTime timeOfCreation;

    public String getTitle() {
        return title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public LocalDateTime getTimeOfCreation() {
        return timeOfCreation;
    }

    public Project(Long id, String title) {
        super(id);
        this.title = title;
        this.timeOfCreation = LocalDateTime.now();
    }
}
