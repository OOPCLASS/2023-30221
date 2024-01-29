public class Task extends AbstractEntity<Long> {
    private String title;
    private TaskStatus status;

    public static Long nextId = 1L;

    public static Long getNextId() {
        return nextId++;
    }

    public Task(String title) {
        this.title = title;
        this.setId(getNextId());
        this.status = TaskStatus.CREATED;
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

    @Override
    public String toString() {
        return "Task{" + "title='" + title + '\'' + ", status=" + status + '}';
    }
}


