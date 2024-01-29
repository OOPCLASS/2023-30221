enum TaskStatus {
    CREATED,
    IN_PROGRESS,
    DONE
}
public class Task extends AbstractEntity<Long> {

    private String title;
    private TaskStatus status;

    public Task(Long id, String title, TaskStatus status) {
        super(id);
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setProjectId(Long id) {
        setId(id);
    }
}