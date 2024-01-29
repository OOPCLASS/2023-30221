package test2oop;

public class Task<ID> extends AbstractEntity<ID> {

    private String title;
    private TaskStatus status;

    public Task(ID id, String title, TaskStatus status) {
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
}
