import java.util.ArrayList;
import java.util.List;

public class User extends AbstractEntity {
    private String email;
    private List<Task> tasks;

    public User(String email) {
        this.email = email;
        this.tasks = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}