package demo;

import java.util.List;
import java.util.ArrayList;

// Clasa Project extinde AbstractEntity
// Metodele ei sunt caracteristice pt un proiect. Proiectul are titlu si o lista de task-uri.

public class Project extends AbstractEntity<Long> {
    private String title;
    private List<Task> tasks;

    public Project() {
        this.tasks = new ArrayList<>();
    }

    public Project(String title) {
        this.title = title;
        this.tasks = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
