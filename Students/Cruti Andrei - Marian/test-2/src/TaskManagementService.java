import java.util.ArrayList;
import java.util.List;

public class TaskManagementService {
    private ProjectService projectService;
    private List<User> users;

    public TaskManagementService() {
        this.projectService = new ProjectService();
        this.users = new ArrayList<User>();
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User registerUser(User user) {
        checkForDuplicateEmail(user.getEmail());
        this.users.add(user);
        return user;
    }

    private void checkForDuplicateEmail(String email) {
        if (isDuplicateEmail(email)) {
            throw new EmailAlreadyTakenException("The email '" + email + "' is already being used by another user.");
        }
    }

    private boolean isDuplicateEmail(String email) {
        for(User i: this.users) {
            if(email.equals(i.getEmail()))
                return true;
        }
        return false;
    }

    public Project createTask(User user, Project project, String title) {
        Task task = new Task(title);
        project.addTask(task);
        user.addTask(task);
        return project;
    }

    public Task getTaskByID(Long ID) {
        for (Project e : this.projectService.getProjects()) {
            for (Task i : e.getTasks()) {
                if(ID.equals(i.getId())) {
                    return i;
                }
            }
        }
        throw new TaskNotFoundException("Task with ID '" + ID + "' not found");
    }

    public boolean deleteTask(Long ID) {
        Task task = getTaskByID(ID);
        for (Project e : this.projectService.getProjects()) {
            e.deleteTask(task);
        }
        for(User e : this.users) {
            e.deleteTask(task);
        }
        return true;
    }

    public List<Task> getTasks (Long projectID, TaskStatus.TaskStatusEnum taskStatus) {
        List<Task> tasks = new ArrayList<Task>();
        for(Task e : this.projectService.getProjectByID(projectID.toString()).getTasks()) {
            if(taskStatus.equals(e.getStatus())) {
                tasks.add(e);
            }
        }
        return tasks;
    }


}
