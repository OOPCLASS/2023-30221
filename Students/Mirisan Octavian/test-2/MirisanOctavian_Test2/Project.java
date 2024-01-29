import java.util.List;

public class Project extends AbstractEntity<Long>{

    private String title;
    private List<Task> tasks;

    public Project(Long id, String title, List<Task> tasks) {
        super(id);
        this.title = title;
        this.tasks = tasks;
    }

    public String getTitle() {
        return title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


    public static void printProject(Project project) {
        System.out.println("Project ID: " + project.getId());
        System.out.println("Project Title: " + project.getTitle());
        System.out.println("Tasks in project:");
        for (Task task : project.getTasks()) {
            System.out.println("- Task ID: " + task.getId() + ", Title: " + task.getTitle() + ", Status: " + task.getStatus());
        }
        System.out.println();
    }
}
