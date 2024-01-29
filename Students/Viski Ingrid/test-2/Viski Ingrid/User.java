import java.util.ArrayList;
import java.util.List;

public class User extends AbstractEntity<String>{
    private String email;
    private List<Task> tasks;

    public User(String id, String email, List<Task> tasks) {
        super(id);
        this.email = email;
        this.tasks = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
