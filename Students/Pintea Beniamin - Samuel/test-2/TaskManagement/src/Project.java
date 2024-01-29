import java.util.ArrayList;
import java.util.List;

public class Project extends AbstractEntity<Long>{
    private String title;
    private List<Task> tasks = new ArrayList<Task>();

    private static Long projectId = 1L;

    public Project(String title) {
        this.title = title;
        this.setId(projectId++);
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
}
