import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project extends AbstractEntity<Long> {

    private String title;
    private static List<Task> tasks = new ArrayList<>();
    private LocalDate creationDate;

    public Project(Long id, String title, List<Task> tasks) {
        this.title = title;
        this.tasks = tasks;
        creationDate = LocalDate.now();
        this.setId(id);
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public static void addTask(Task task) {
        tasks.add(task);
    }
}
