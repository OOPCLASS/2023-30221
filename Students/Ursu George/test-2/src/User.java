import java.util.ArrayList;
import java.util.List;

public class User extends AbstractEntity<String> {
    private String email;
    private static List<Task> tasks = new ArrayList<>();

    public User(String email){
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public static void addTask(Task task) {
        tasks.add(task);
    }
}
