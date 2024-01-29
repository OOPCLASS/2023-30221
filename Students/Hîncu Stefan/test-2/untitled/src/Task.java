public class Task<Long> extends AbstractEntity<Long> {
    private String title;
    private TaskStatus status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

}
