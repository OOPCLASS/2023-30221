import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TaskManagementService {
    private ProjectService projectService;
    private Set<User> users;
    private HashMap<Long, Task> tasks;

    public TaskManagementService(ProjectService projectService){
        this.projectService = projectService;
        this.users = new HashSet<>();
        this.tasks = new HashMap<>();
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public Set<User> getUsers() {
        return users;
    }

    public HashMap<Long,Task> getTasks() {
        return tasks;
    }

    private String generateUniqueID() {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        char randomLetter = (char) ('A' + random.nextInt(26));

        return randomNumber + String.valueOf(randomLetter);
    }

    private Long generateUniqueID_task() {
        Random random = new Random();
        Long randomNumber = random.nextLong(100, 1000);

        return randomNumber;
    }

    public User registerUser(String email) throws EmailAlreadyTakenException {
        for (User existingUsers : users)
            if (!existingUsers.getEmail().equals(email))
                throw new EmailAlreadyTakenException("There is another user with this email");

        User user = new User(generateUniqueID(), email);
        users.add(user);
        return user;
    }

    public Task createTask(String title, User user, Project project) throws TaskAlreadyExistsException {
        Long newID = generateUniqueID_task();
        Task newTask = new Task(newID, title, TaskStatus.CREATED);
         if (!tasks.containsKey(newID))
             throw new TaskAlreadyExistsException("This task already exist");
         tasks.put(newID, newTask);
         return newTask;
    }

    public Task getTask(Long id){
       if (!tasks.containsKey(id))
            throw new TaskNotFoundException("Task " + id + " doesn't exist");
       return tasks.get(id);
    }

    public Task updateTask(Long id, Task updatedTask){
        if (!tasks.containsKey(id))
            throw new TaskNotFoundException("Task " + id + " doesn't exist");
        tasks.replace(id, updatedTask);
        return updatedTask;
    }


    public boolean deleteTask(Long id){
        if (!tasks.containsKey(id))
            throw new TaskNotFoundException("Task "+id+" doesn't exist");

        Task taskToDelete = tasks.get(id);

        for (Long taskId : tasks.keySet()) {
            Task task = tasks.get(taskId);
            if (task.getStatus().equals(TaskStatus.IN_PROGRESS)) {
                return false;
            }
        }

        tasks.remove(id);
        return true;
    }


}
