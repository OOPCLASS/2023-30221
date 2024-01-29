public class Task extends AbstractEntity {
   enum TaskStatus{
       CREATED,
       IN_PROGRESS,
       DONE
    }
    private String title;
    private TaskStatus status;

    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return this.id;
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
