import java.util.List;

public class User extends AbstractEntity<String> {
    String email;
    List<Task> tasks;

    public User(String userId, String email, List<Task> tasks) {
        super(userId);
        this.email = email;
        this.tasks = tasks;
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
