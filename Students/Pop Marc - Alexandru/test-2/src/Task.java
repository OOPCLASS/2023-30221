public class Task extends AbstractEntityLong {
    private String title;

    private TaskStatus status;

    public Task(String title) {
        super();
        this.title = title;
        status = TaskStatus.CREATED;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }
}
