import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project extends AbstractEntityLong {
    private String title;

    private List<Task> tasks;

    private LocalDate createdDate;

    public Project(String title) {
        super();
        this.title = title;
        createdDate = LocalDate.now();
        tasks = new ArrayList<Task>();
    }

    public String getTitle() {
        return title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
