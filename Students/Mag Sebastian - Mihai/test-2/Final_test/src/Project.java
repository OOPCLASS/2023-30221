import java.util.Date;
import java.util.List;

public class Project {
    private int id;
    private String name;
    private Date creationDate;
    private List<Task>tasks;

    public Project(int id, String name, Date creationDate, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.tasks = tasks;
    }

    public Project(int id, String name, Date creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
