public class Task extends AbstractEntity<Long> {
    String title;
    TaskStatus status;

    public Task(Long taskId, String title, TaskStatus status) {
        super(taskId);
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
}
