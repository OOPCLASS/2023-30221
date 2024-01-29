package taskManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project extends AbstractEntity<Long> {
    private String title;
    private List<Task> tasks;
    private LocalDate createdDate;
    private Long addedTask = 0L;

    public Project(Long id, String title) {
        super(id);
        this.title = title;
        this.tasks = new ArrayList<>();
        this.createdDate = LocalDate.now();
    }

    public String getTitle() {
        return title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Long generateTaskID() {
        return addedTask++;
    }
}
