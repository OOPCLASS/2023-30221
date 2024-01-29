import java.util.*;

public class TaskManagementService {
    private ProjectService projectService;
    private Set<User> users;

    public TaskManagementService() {
        this.projectService = new ProjectService();
        this.users = new HashSet<>();
    }

    public User registerUser(User user) throws EmailAlreadyTakenException {
        if (isEmailTaken(user.getEmail())) {
            throw new EmailAlreadyTakenException("Email already taken: " + user.getEmail());
        }
        String newUserId = String.valueOf(generateUniqueId());
        user.setId(newUserId);

        users.add(user);

        return user;
    }

    private boolean isEmailTaken(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public Project createTask(User user, Project project) {
        Long newTaskId = generateUniqueId();
        Task newTask = new Task(newTaskId, "New Task" + newTaskId, TaskStatus.CREATED);

        project.addTask(newTask);
        user.addTask(newTask);
        projectService.update(project.getId(), project);

        return project;
    }

    public Task getTask(Long id) {
        for (Project project : projectService.getProjects()) {
            for (Task task : project.getTasks()) {
                if (task.getId().equals(id)) {
                    return task;
                }
            }
        }
        throw new TaskNotFoundException("Task not found with ID: " + id);
    }

    public Project updateTask(Task task, Project project) {
        Task existingTask = getTask(task.getId());

        existingTask.setTitle(task.getTitle());
        existingTask.setStatus(task.getStatus());

        projectService.update(project.getId(), project);

        return project;
    }

    public boolean deleteTask(Long id) {
        Task task = getTask(id);
        Project project = null;

        for (Project p : projectService.getProjects()) {
            if (p.getTasks().contains(task)) {
                project = p;
                break;
            }
        }
        if (project != null) {
            project.removeTask(task);
            projectService.update(project.getId(), project);
            return true;
        }
        return false;
    }


    public List<Task> getTasks(Long projectID, TaskStatus taskStatus) {
        List<Task> matchingTasks = new ArrayList<>();

        for (Project project : projectService.getProjects()) {
            for (Task task : project.getTasks()) {
                if (task.getId().equals(projectID) && task.getStatus() == taskStatus) {
                    matchingTasks.add(task);
                }
            }
        }

        return matchingTasks;
    }


    public List<Task> getTasksByStatus(TaskStatus status) {
        List<Task> tasksWithStatus = new ArrayList<>();

        for (Project project : projectService.getProjects()) {
            for (Task task : project.getTasks()) {
                if (task.getStatus() == status) {
                    tasksWithStatus.add(task);
                }
            }
        }

        return tasksWithStatus;
    }


    private TaskNotFoundException throwTaskNotFoundException(Long id) {
        return new TaskNotFoundException("Task not found with ID: " + id);
    }

    private Long generateUniqueId() {
        UUID uuid = UUID.randomUUID();
        return Long.valueOf(uuid.toString());
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
