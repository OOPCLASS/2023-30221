public class Task extends AbstractEntity<Long>{
    private String title;
    private TaskStatus status;
    private static Long taskId = 1L;

    public Task(String title, TaskStatus status) {
        this.title = title;
        this.status = status;
        this.setId(taskId++);
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
