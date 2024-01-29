public class Task extends AbstractEntity<Long>{
    private String title;
    private TaskStatus.TaskStatusEnum status;

    public Task(String title, TaskStatus.TaskStatusEnum status) {
        this.title = title;
        this.status = status;
    }

    public Task(String title) {
        this.title = title;
        this.status = TaskStatus.TaskStatusEnum.CREATED;
    }

    public Task() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskStatus.TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatus.TaskStatusEnum status) {
        this.status = status;
    }
}