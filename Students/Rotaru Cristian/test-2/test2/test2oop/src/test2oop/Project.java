package test2oop;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Project<ID> extends AbstractEntity<ID> {

    private String title;
    private List<Task<Long>> tasks;

    private Date startDate;

    public Project(ID id, String title, List<Task<Long>> tasks) {
        super(id);
        this.title = title;
        this.tasks = tasks;
        this.startDate = Calendar.getInstance().getTime();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Task<Long>> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task<Long>> tasks) {
        this.tasks = tasks;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
