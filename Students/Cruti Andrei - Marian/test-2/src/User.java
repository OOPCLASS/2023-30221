import java.util.ArrayList;
import java.util.List;

public class User extends AbstractEntity<String>{
    private String email;
    private List<Task> tasks;

    public User(String email) {
        this.email = email;
        this.tasks = new ArrayList<Task>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void deleteTask(Task task) {
        this.tasks.remove(task);
    }
}
