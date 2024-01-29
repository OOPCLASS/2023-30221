import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Project extends AbstractEntity<Long>{
    private String title;
    private List<Task> tasks;
    private LocalDateTime creationDate;
    public Project(Long id) {
        super(id);
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Task addTask(Task task){
        tasks.add(task);
        return task;
    }
}
