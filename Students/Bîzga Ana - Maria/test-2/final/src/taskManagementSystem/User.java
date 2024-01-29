package taskManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class User extends AbstractEntity<String> {

    private String email;
    private List<Task> tasks;
    private static int userAdded = 0;

    public User(String email) {
        super(generateID());
        this.email = email;
        this.tasks = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    private static String generateID() {
        return "U" + userAdded++;
    }
}
