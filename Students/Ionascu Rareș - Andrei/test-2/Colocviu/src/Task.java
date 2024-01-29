public class Task extends AbstractEntity {
    private String description;
    private TaskStatus status;
    private int taskId;
    private String title;

    public Task(String title, String description, TaskStatus status) {
        super();
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public long getTaskId() { return taskId; }
    public void setTaskId(int taskId) { this.taskId = taskId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

}
