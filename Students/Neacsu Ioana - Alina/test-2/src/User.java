import java.util.List;

public class User extends AbstractEntity<String> {
    private String email;
    private List<Task> tasks;

    public User(String id, String email, List<Task> tasks) {
        super(id);
        this.email = email;
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
    private String generateUniqueId() {
        return "USER_" + System.currentTimeMillis();
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
