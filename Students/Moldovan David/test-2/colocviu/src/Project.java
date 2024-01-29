import java.util.List;

public class Project extends AbstractEntity<Long> {
    private String title;
    private List<Task> tasks;

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

   public Project(String title, List<Task> tasks) {

       this.title = title;
        this.tasks = tasks;
    }



}


