package pack;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id;
    private String name;
    private List<Task>tasks;
    private long creationDate;
    public Project(int id, String name){
        this.id=id;
        this.name=name;
        this.tasks=new ArrayList<>();
        this.creationDate=System.currentTimeMillis();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Task> getTasks() {
        return tasks;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    public long getCreationDate() {
        return creationDate;
    }
    public void addTask(Task task) {
        tasks.add(task);
    }
    //Metoda pentru obtinerea unei liste de sarcini in fucntie de status
    public List<Task>getTasksByStatus(TaskStatus status)
    {
        List<Task>tasksByStatus = new ArrayList<>();
        for(Task task: tasks){
            if(task.getStatus()== status){
                tasksByStatus.add(task);
            }
        }
        return tasksByStatus;
    }
}
