import java.util.ArrayList;
import java.util.List;

public class TaskManagementService
{
    private ProjectService projectService;
    private List<User> users = new ArrayList<User>();
    private int idd=1;
    public User registerUser(User user)
    {
        user.setID(idd);
        for(User u:users)
            if(u.getEmail().equals(user.getEmail()))
            {
                System.out.println("EmailAlreadyTakenException");
                return null;
            }
        idd++;
        this.users.add(user);

        return user;
    }
    public Project createTask(User user,Project project)
    {
        return null;
    }
    public Project updateTask(Task task,Project project)
    {
        return null;
    }
    public Task getTask ( int id)
    {
        return null;
    }
    public boolean deleteTask(int id)
    {
        return true;
    }
    public List<Task> getTasks(int ProjectID, Task.TaskStatus taskStatus)
    {
        return null;
    }

}
