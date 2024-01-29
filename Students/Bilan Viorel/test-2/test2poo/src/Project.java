import java.util.List;

public class Project extends AbstractEntity<Long> {
    String title;
    List<Task> tasks;

    public Project(Long projectId, String title, List<Task> tasks) {
        super(projectId);
        this.title = title;
        this.tasks = tasks;
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
