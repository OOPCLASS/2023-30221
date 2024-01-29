import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskManagementService {
    private ProjectService projectService;
    private List<User> users;

    public TaskManagementService(ProjectService projectService) {
        this.projectService = projectService;
        this.users = new ArrayList<>();
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public List<User> getUsers() {
        return users;
    }

    public void registerUser(User user) throws EmailAlreadyTakenException {
        if (userExists(user.getEmail())) {
            throw new EmailAlreadyTakenException("Email " + user.getEmail() + " is already taken.");
        }
        long userId = generateUniqueId();
        user.setId(userId);
        users.add(user);
    }

    public void createTask(long userId, long projectId, Task task) {
        if (!userExists(userId) || !projectService.projectExists(projectId)) {
            throw new ProjectNotFoundException("User or Project not found.");
        }

        Project project = null;
        for (Project p : projectService.getProjects()) {
            if (p.getId() == projectId) {
                project = p;
                break;
            }
        }

        if (project == null) {
            throw new ProjectNotFoundException("Project with id " + projectId + " not found.");
        }

        long taskId = generateUniqueId();
        task.setId(taskId);
        project.addTask(task);
        getUserById(userId).addTask(task);
    }

    public Task getTask(long taskId) {
        for (User user : users) {
            for (Task task : user.getTasks()) {
                if (task.getId() == taskId) {
                    return task;
                }
            }
        }

        throw new TaskNotFoundException("Task with id " + taskId + " not found.");
    }

    public void updateTask(long taskId, Task updatedTask) {
        ///Update in utilizatori
        for (User user : users) {
            for (Task task : user.getTasks()) {
                if (task.getId() == taskId) {
                    task.setTitle(updatedTask.getTitle());
                    task.setStatus(updatedTask.getStatus());
                    break; // No need to continue searching once the task is updated
                }
            }
        }

        ///Update in proiecte
        for (Project project : projectService.getProjects()) {
            for (Task task : project.getTasks()) {
                if (task.getId() == taskId) {
                    task.setTitle(updatedTask.getTitle());
                    task.setStatus(updatedTask.getStatus());
                    return; // No need to continue searching once the task is updated
                }
            }
        }

        throw new TaskNotFoundException("Task with id " + taskId + " not found.");
    }

    public boolean deleteTask(long taskId) {
        boolean deleted = false;

        //Stergem task-ul din user
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            Iterator<Task> taskIterator = user.getTasks().iterator();
            while (taskIterator.hasNext()) {
                Task task = taskIterator.next();
                if (task.getId() == taskId) {
                    taskIterator.remove();
                    deleted = true;
                }
            }
            if (user.getTasks().isEmpty()) {
                userIterator.remove();
            }
        }

        // Stergem task-ul din proiecte
        for (Project project : projectService.getProjects()) {
            Iterator<Task> taskIterator = project.getTasks().iterator();
            while (taskIterator.hasNext()) {
                Task task = taskIterator.next();
                if (task.getId() == taskId) {
                    taskIterator.remove();
                    deleted = true;
                }
            }
            if (project.getTasks().isEmpty()) {
                projectService.deleteProject(project.getId());
            }
        }

        return deleted;
    }

    public List<Task> getTasksByProjectAndStatus(long projectId, TaskStatus status) {
        List<Task> tasksWithStatus = new ArrayList<>();

        for (Project project : projectService.getProjects()) {
            if (project.getId() == projectId) {
                for (Task task : project.getTasks()) {
                    if (task.getStatus() == status) {
                        tasksWithStatus.add(task);
                    }
                }
                break;
            }
        }

        return tasksWithStatus;
    }

    public List<Task> getAllTasksByStatus(TaskStatus status) {
        List<Task> tasksWithStatus = new ArrayList<>();

        for (User user : users) {
            for (Task task : user.getTasks()) {
                if (task.getStatus() == status) {
                    tasksWithStatus.add(task);
                }
            }
        }

        for (Project project : projectService.getProjects()) {
            for (Task task : project.getTasks()) {
                if (task.getStatus() == status) {
                    tasksWithStatus.add(task);
                }
            }
        }

        return tasksWithStatus;
    }

    private boolean userExists(long userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return true;
            }
        }
        return false;
    }

    private boolean userExists(String userEmail) {
        for (User user : users) {
            if (user.getEmail().equals(userEmail)) {
                return true;
            }
        }
        return false;
    }

    private User getUserById(long userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        throw new UserNotFoundException("User with id " + userId + " not found.");
    }

    private long generateUniqueId() {
        return System.currentTimeMillis();
    }
}