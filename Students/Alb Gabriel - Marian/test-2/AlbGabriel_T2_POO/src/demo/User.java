package demo;

import java.util.List;
import java.util.ArrayList;

public class User extends AbstractEntity<String> {
    private String email;
    private String name; // am adugat atributul name
    private List<Task> tasks;

    public User(String email, String name, List<Task> tasks) {
        this.email = email;
        this.name = name;
        this.tasks = tasks;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }


}
