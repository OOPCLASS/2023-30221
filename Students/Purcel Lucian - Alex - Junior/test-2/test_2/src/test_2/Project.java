package test_2;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


class Project extends AbstractEntity<Long> {
	private String title;
    private List<Task> tasks;
    private LocalDateTime createdDate;
    private long id;
    
    public static long nextId=1;
   
    public Project(String title) {
        this.title = title;
        this.tasks = new ArrayList<>();
        this.setId(getNextId());
        this.createdDate = LocalDateTime.now();
    }

   
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
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
    
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

  
    public void addTask(Task task) {
        tasks.add(task);
    }
}
