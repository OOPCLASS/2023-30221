import java.util.List;
import java.util.UUID;

public class TaskManagementService {
    private ProjectService projectService;
    private List<User> users;

    public TaskManagementService(ProjectService projectService, List<User> users) {
        this.projectService = projectService;
        this.users = users;
    }

    public User registerUser(User user) throws EmailAlreadyTakenException {

        if (isDuplicateEmail(user.getEmail())) {
            throw new EmailAlreadyTakenException("Email is already registered");
        }

        String userId = generateUniqueUserId();

        user.setId(userId);
        users.add(user);
        return user;
    }

    public Project createTask(User user, Project project, String taskTitle) {

        Long taskId = generateUniqueTaskId();
        Task newTask = new Task(taskId, taskTitle, TaskStatus.Created);

        project.getTasks().add(newTask);
        user.getTasks().add(newTask);

        return project;
    }

    public Task getTask(Long id, Project project) {
        for (Task task : project.getTasks()) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        throw new TaskNotFoundException("Task not found");
    }

    public Project updateTask(Task updatedTask, Project project) {

        for (int i = 0; i < project.getTasks().size(); i++) {
            Task task = project.getTasks().get(i);

            if (task.getId().equals(updatedTask.getId())) {

                task.setTitle(updatedTask.getTitle());
                task.setStatus(updatedTask.getStatus());

                return project;
            }
        }

        throw new TaskNotFoundException("Task not found");
    }


    public boolean deleteTask(Long taskId, Project project) {

        for (Task task : project.getTasks()) {

            if (task.getId().equals(taskId)) {

                project.getTasks().remove(task);

                return true;
            }
        }

        return false;
    }




    private String generateUniqueUserId() {

        return UUID.randomUUID().toString();
    }

    private Long generateUniqueTaskId() {
        UUID uuid = UUID.randomUUID();
        return Long.valueOf(uuid.getMostSignificantBits());
    }

    private boolean isDuplicateEmail(String email) {
        for (User existingUser : users) {
            if (existingUser.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
