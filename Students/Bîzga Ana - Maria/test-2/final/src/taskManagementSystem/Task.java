package taskManagementSystem;

public class Task extends AbstractEntity<Long> {

    private String title;
    private TaskStatus status;

    public Task(Long id, String title) {
        super(id);
        this.title = title;
        this.status = TaskStatus.CREATED;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
