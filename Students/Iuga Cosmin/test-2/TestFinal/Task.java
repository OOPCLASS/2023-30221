public class Task extends AbstractEntity {
    private String title;
    private TaskStatus status;

    public Task(String title, TaskStatus status) {
        this.title = title;
        this.status = status;
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

    public void setTitle(String title) {
        this.title = title;
    }
}