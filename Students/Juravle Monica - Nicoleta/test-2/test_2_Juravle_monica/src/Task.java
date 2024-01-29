public class Task extends AbstractEntity<Long>{
    private String title;
    private TaskStatus status;

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Task(Long id, String title, TaskStatus status){
        super(id);
        this.title = title;
        this.status = status;
    }
}
