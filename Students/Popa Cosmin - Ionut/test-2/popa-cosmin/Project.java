import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
class Project extends AbstractEntity<Long> {
    private String title;
    private List<Task> tasks;
    private LocalDate creationDate; // Add this line
    private List<User> users;

    public Project(Long id, String title, List<Task> tasks) {
        super(id);
        this.title = title;
        this.tasks =  new ArrayList<>();
        this.users = new ArrayList<>(); // Inițializează lista de utilizatori
        this.creationDate = LocalDate.now(); // Set creation date when the project is created
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public LocalDate getCreationDate() { // Add this method
        return creationDate;
    }
    public List<User> getUsers() {
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;
    }
}
