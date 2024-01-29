import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TaskManagementService {
    private ProjectService projectService;

    private Set<User> users = new HashSet<User>();

    public TaskManagementService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public User registerUser(User user) throws EmailAlreadyTakenException {
        for (User currentUser : users) {
            if (currentUser.getEmail() == user.getEmail()) {
                throw new EmailAlreadyTakenException();
            }
        }

        users.add(user);

        return user;
    }

    public Task createTask(User user, Project project, String title) {
        User currentUser = getUser(user.getId());

        Project currentProject = projectService.get(project.getId());
        
        Task task = new Task(title);

        currentUser.addTask(task);
        currentProject.addTask(task);

        return task;
    }

    public Task getTask(Long id) {
        for (User user : users) {
            for (Task task : user.getTasks()) {
                if (task.getId() == id) {
                    return task;
                }
            }
        }

        throw new TaskNotFoundException();
    }

    public Task updateTask(Task task, Project project) {
        Project currentProject = projectService.get(project.getId());

        for (Task currentTask : currentProject.getTasks()) {
            if (currentTask.getId() == task.getId()) {
                currentTask = task;
                return task;
            }
        }

        throw new TaskNotFoundException();
    }

    public boolean deleteTask(Long id) {
        boolean taskFound = false;

        for (User user : users) {
            Iterator<Task> iterator = user.getTasks().iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (task.getId() == id) {
                    user.deleteTask(task);
                    taskFound = true;
                    break;
                }
            }
        }

        if (!taskFound) {
            return false;
        }

        taskFound = false;

        for (Project project : projectService.getProjects()) {
            Iterator<Task> iterator = project.getTasks().iterator();
            while (iterator.hasNext()) {
                Task currentTask = iterator.next();
                if (currentTask.getId() == id) {
                    project.removeTask(currentTask);
                    taskFound = true;
                    break;
                }
            }
        }

        if (!taskFound) {
            return false;
        }
        
        return true;
    }

    public List<Task> getTasks(Long projectId, TaskStatus taskStatus) {
        Project project = projectService.get(projectId);

        List<Task> tasks = new ArrayList<Task>();

        for (Task task : project.getTasks()) {
            if (task.getStatus() == taskStatus) {
                tasks.add(task);
            }
        }

        return tasks;
    }

    private User getUser(String id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        throw new UserNotFoundException();
    }
}
