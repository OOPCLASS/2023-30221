import java.util.ArrayList;
import java.util.List;

public class User extends AbstractEntity {
    private String email;
    private List<Task> tasks=new ArrayList<Task>();

    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return this.id;
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
