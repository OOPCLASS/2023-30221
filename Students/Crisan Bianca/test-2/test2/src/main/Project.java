package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Project extends AbstractEntity<Long>{
    private static String title;
    private static List<Task> tasks;
    private LocalDateTime creationDateTime;
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }
    public Project() {
        this.tasks = new ArrayList<>();
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
}
