package test_2;

class Task extends AbstractEntity<Long> {
    private String title;
    private TaskStatus status;
    private long id;

    public static long nextId = 1;

    
    public Task(String title, TaskStatus status) {
        this.title = title;
        this.status = status;
        this.setId(getNextId());
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNextId() {
        return nextId++;
    }
}