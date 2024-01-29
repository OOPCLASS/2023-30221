import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User extends AbstractEntity<String> {
    private String email;

    private List<Task> tasks;

    public User(String email) {
        super(UUID.randomUUID().toString());
        this.email = email;
        tasks = new ArrayList<Task>();
    }

    public String getEmail() {
        return email;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }
}
