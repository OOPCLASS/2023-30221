import java.util.List;

public class User extends AbstractEntity<String>{
    private String email;

    private List<Task> tasks;

    public String getEmail() {
        return email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public User(String id, String email){
        super(id);
        this.email = email;
    }
}
