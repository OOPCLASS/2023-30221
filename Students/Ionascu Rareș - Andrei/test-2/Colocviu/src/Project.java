import java.util.ArrayList;
import java.util.List;

public class Project {
    private long projectId;
    private String projectName;
    private List<User> users;
    private List<Task> tasks;

    public Project(String projectName) {
        this.projectId = generateUniqueID();
        this.projectName = projectName;
        this.users = new ArrayList<>();
        this.tasks = new ArrayList<>();


    }

    private long generateUniqueID() {
        return 0L;
    }

    public long getProjectId() {
        return projectId;
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    // Method to add a user to the project
    public void addUser(User user) {
        this.users.add(user);
    }
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public List<Task> getTasks() {
        return this.tasks;
    }
}
