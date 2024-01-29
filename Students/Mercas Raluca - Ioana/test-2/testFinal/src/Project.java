import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Project extends AbstractEntity<Long>{

    private String title;
    private List<Task> tasks;
    private LocalDateTime startDate;


    public Project(Long aLong, String title) {
        super(aLong);
        this.title = title;
        this.tasks = new ArrayList<>();
        this.startDate = LocalDateTime.now();
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
    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        String string = "Project " + title + " - start date " + startDate;
        List<Task> tasks = getTasks();
        for(Task task: tasks) {
            string += "\n" + task.toString();
        }
        return string;
    }
}
