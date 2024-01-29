
public class Task extends AbstractEntity<Long>{

    private String title;
    private TaskStatus status;


    public Task(Long aLong) {
        super(aLong);

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
        return "Task " + getId() + " - " + title + " - " + status;
    }
}
