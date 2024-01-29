import java.util.List;

public class User extends AbstractEntity<Long>
{

    private String email;

    private List<Task> tasks;

    public User(Long id, String email, List<Task> tasks)
    {
        super(id);
        this.email = email;
        this.tasks = tasks;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<Task> getTasks()
    {
        return tasks;
    }

    public void setTasks(List<Task> tasks)
    {
        this.tasks = tasks;
    }
}
