import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project extends AbstractEntity<Long>{
    private String title;
    private List<Task> tasks;

    private LocalDate creationDate;

    public Project(String title, LocalDate creationDate) {
        this.title = title;
        this.creationDate = creationDate;
        this.tasks = new ArrayList<Task>();
    }

    public Project() {
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

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void deleteTask(Task task) {
        this.tasks.remove(task);
    }
}
