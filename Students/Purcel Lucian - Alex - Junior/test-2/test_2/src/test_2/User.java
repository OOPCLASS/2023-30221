package test_2;
import java.util.ArrayList;
import java.util.List;

class User extends AbstractEntity<String> {
	 private String email;
	    private List<Task> tasks;
	    private String id;

	    public static long nextId = 1;
	   
	    public User(String email) {
	        this.email = email;
	        this.tasks = new ArrayList<>();
	    }

	
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public List<Task> getTasks() {
	        return tasks;
	    }

	    public void setTasks(List<Task> tasks) {
	        this.tasks = tasks;
	    }

	    
	    public void addTask(Task task) {
	        tasks.add(task);
	    }
	    
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getNextId() {
	        return "U" + nextId++;
	    }
	    
}