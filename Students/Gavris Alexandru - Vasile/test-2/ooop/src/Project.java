import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project extends AbstractEntity {
    private String title;
    private List<Task> tasks=new ArrayList<Task>();
    private int months;

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
