import java.util.*;

public class TaskManagementService {
    private ProjectService projectService = new ProjectService();
    private List<User> users = new ArrayList<User>();

    public ProjectService getProjectService() {
        return projectService;
    }

    public User registerUser(User user) {
        //Unique ID gets assigned on instantiation, check User constructor
        for (User userToCheck : users) {
            if (userToCheck.getEmail().equals(user.getEmail())) {
                throw new EmailAlreadyTakenException("User with email " + user.getEmail() + " already exists");
            }
        }

        users.add(user);
        return user;
    }

    //Creates task for both user and project if and only if BOTH are valid; cannot add a task to a user without a project
    public Task createTask(String title, User user, Project project) {
        if (user == null || project == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        boolean userExists = false;
        for (User userExist : users) {
            if (userExist.getId().equals(user.getId())) {
                userExists = true;
            }
        }
        if (!userExists) {
            throw new UserNotFoundException("User with ID " + user.getId() + " not found");
        }

        boolean projectExists = false;
        for (Project projectExist : projectService.getProjects()) {
            if (projectExist.getId().equals(project.getId())) {
                projectExists = true;
            }
        }

        if (!projectExists) {
            throw new ProjectNotFoundException("Project with ID " + project.getId() + " not found");
        }

        for (Project projectToCheck : projectService.getProjects()) {
            if (projectToCheck.getId().equals(project.getId())) {
                Task task = new Task(title);
                projectToCheck.addTask(task);
                user.addTask(task);
                return task;
            }
        }

        throw new ProjectNotFoundException("Project with ID " + project.getId() + " not found");
    }

    public Task getTask(Long id) {
        for (Project project : projectService.getProjects()) {
            for (Task task : project.getTasks()) {
                if (task.getId().equals(id)) {
                    return task;
                }
            }
        }

        throw new TaskNotFoundException("Task with ID " + id + " not found");
    }

    public Project updateTask(Long id, Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        for (Project projectToCheck : projectService.getProjects()) {
            for (Task taskToCheck : projectToCheck.getTasks()) {
                if (taskToCheck.getId().equals(id)) {
                    //This should also update for the user; we're using references
                    taskToCheck.setTitle(task.getTitle());
                    taskToCheck.setStatus(task.getStatus());
                    return projectToCheck;
                }
            }

        }
        throw new ProjectNotFoundException("Task with ID " + id + " not found");
    }

    public boolean deleteTask(Long id) {
        //Need to also update user
        for (Project project : projectService.getProjects()) {
            for (Task task : project.getTasks()) {
                if (task.getId().equals(id)) {
                    List<Task> projectList = project.getTasks();
                    projectList.remove(task);
                    projectService.update(project.getId(), project);

                    for (User user: users) {
                        for (Task task2 : user.getTasks()) {
                            if (task2.getId().equals(id)) {
                                user.getTasks().remove(task2);
                                return true;
                            }
                        }
                    }
                    return true;
                }
            }
        }

        throw new TaskNotFoundException("Task with ID " + id + " not found");
    }

    public List<Task> getTasks(Long projectId, TaskStatus taskStatus) {
        List<Task> tasks = new ArrayList<Task>();
        for (Project project : projectService.getProjects()) {
            if (project.getId().equals(projectId)) {
                for (Task task : project.getTasks()) {
                    if (task.getStatus().equals(taskStatus)) {
                        tasks.add(task);
                    }
                }
            }
        }

        return tasks;
    }

    public Map<Task, Project> getTasks(TaskStatus taskStatus) {
        Map<Task, Project> tasks = new HashMap<Task, Project>();
        for (Project project : projectService.getProjects()) {
            for (Task task : project.getTasks()) {
                if (task.getStatus().equals(taskStatus)) {
                    tasks.put(task, project);
                }
            }
        }
        return tasks;

    }

}
