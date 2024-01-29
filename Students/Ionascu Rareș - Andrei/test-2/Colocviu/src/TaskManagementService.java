import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class TaskManagementService {
    private Map<Long, User> users;
    private Map<Long, Task> tasks;

    public TaskManagementService() {
        this.users = new HashMap<>();
        this.tasks = new HashMap<>();
    }
    public void registerUser(User user) throws EmailAlreadyTakenException {
        if(users.containsKey(user.getUserId())) {
            throw new EmailAlreadyTakenException("Email already taken");
        } else {
            users.put(user.getUserId(), user);
        }
    }
    public void createTask(Task task) {
        if(!tasks.containsKey(task.getTaskId())) {
            tasks.put(task.getTaskId(), task);
        }
    }

    public Task getTask(long taskId) {
        return tasks.get(taskId);
    }

    public void updateTask(long taskId, Task updatedTask) {
        if(tasks.containsKey(taskId)) {
            tasks.put(taskId, updatedTask);
        }
    }
    public void deleteTask(long taskId) {
        tasks.remove(taskId);
    }


}
