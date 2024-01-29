import java.util.ArrayList;
import java.util.List;

public class TaskManagementService {
    private ProjectService projectService;
    private List<User> users = new ArrayList<>();
    public static Long nextTasktId = 1L;

    public TaskManagementService() {

    }

    public User registerUser(User user) {
        for (User i : users) {
            if (i.getEmail().equals(user.getEmail())) {
                throw new EmailAlreadyTakenException("An email like this already exists");
            }
        }
        this.users.add(user);
        return user;
    }

    public Task createTask(String title, User user, Project project) {
        if (user == null || project == null) {

            throw new IllegalArgumentException("User or project cannot be null");
        }
        for (Task i : user.getTasks()) {
            if (i == null) {
                break;
            }
            if (i.getTitle().equals(title)) {
                throw new DuplicateTaskNameException("Task name already exists");
            }
        }
        for (Task i : project.getTasks()) {
            if (i == null) {
                break;
            }
            if (i.getTitle().equals(title)) {
                throw new DuplicateTaskNameException("Task name already exists");
            }
        }
        Long id = nextTasktId;
        Task task = new Task(title, id, TaskStatus.CREATED);
        user.getTasks().add(task);
        return task;
    }

    public Task getTask(Long id) {
        for (User i : users) {
            for (Task taskk : i.getTasks()) {
                if (taskk.getId() == id) {
                    return taskk;
                }
            }
        }
        throw new DuplicateTaskNameException("No task found");
    }

    public Task updateTask(Task task, Project project, TaskStatus status, String title) {
        Task tasks = getTask(task.getId());
        tasks.setStatus(status);
        tasks.setTitle(title);
        return tasks;
    }

    public Boolean deleteTask(Long id) {
        Task task = getTask(id);
        if (task == null) {
            throw new DuplicateTaskNameException("No taks found to delete");
        }
        for (User i : users) {
            for (Task taskk : i.getTasks()) {
                if (taskk.getId() == id) {
                    i.getTasks().remove(taskk);
                    return true;
                }
            }
        }
        return false;
    }

    public List<Task> getTasks(Long projectId, TaskStatus taskStatus) {
        Project project = projectService.get(projectId.toString());
        List<Task> foundTasks = new ArrayList<>();
        for (Task i : project.getTasks()) {
            if (i.getStatus() == taskStatus) {
                foundTasks.add(i);
            }
        }
        return foundTasks;
    }


    private Long getNextProjectId() {
        Long aux = nextTasktId;
        nextTasktId = aux + 1L;
        return aux;
    }
}
