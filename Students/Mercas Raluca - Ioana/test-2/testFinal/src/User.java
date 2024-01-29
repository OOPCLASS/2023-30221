import java.util.ArrayList;
import java.util.List;

public class User extends AbstractEntity<String>{

    private String email;
    private List<Task> tasks;
//    private String name;
    public User(String s) {
        super(s);
        this.tasks = new ArrayList<>();
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
