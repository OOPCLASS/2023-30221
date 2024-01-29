package test2oop;

import java.util.List;

public class User<ID> extends AbstractEntity<ID>{

    private String email;
    private List<Task<Long>> tasks;

    public User(ID id, String email, List<Task<Long>> tasks) {
        super(id);
        this.email = email;
        this.tasks = tasks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task<Long>> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task<Long>> tasks) {
        this.tasks = tasks;
    }

}
