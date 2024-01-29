import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User extends AbstractEntity<String> {
    private String email;
    private List<Task> tasks = new ArrayList<Task>();

    public User(String email) {
        this.email = email;
        //UUID assures that the ID is unique
        this.setId(UUID.randomUUID().toString());
    }

    public void addTask(Task task) {
        this.tasks.add(task);
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
}
