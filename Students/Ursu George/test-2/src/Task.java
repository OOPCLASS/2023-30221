import java.time.LocalDate;

public class Task extends AbstractEntity<Long> {

    private String title;
    private TaskStatus status;


    public Task(String title, Long id, TaskStatus status) {
        this.title = title;
        this.status = status;
        this.setId(id);
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
