import java.util.List;

public class User extends AbstractEntity<String> {
    private String email;
    private List<Task> tasks;

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

    public User(String email, List<Task> tasks) {
        this.email = email;
        this.tasks = tasks;
    }

    


}
