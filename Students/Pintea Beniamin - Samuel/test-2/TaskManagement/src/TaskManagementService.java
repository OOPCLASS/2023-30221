import java.util.ArrayList;
import java.util.List;

public class TaskManagementService {
    private ProjectService projectService;
    private List<User> users = new ArrayList<>();

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

    public User registerUser(User user) throws EmailAlreadyTakenException{

        for (User existingUser: users) {
            if (existingUser.getEmail().compareTo(user.getEmail()) != 0) {
                throw new EmailAlreadyTakenException();
            }
        }

        users.add(user);
        return user;
    }

    public Project createTask(User user, Project project, Task task) throws ProjectNotFoundException {

        Project existingProject = projectService.get(project.getId());

        if (existingProject == null) {
            Task newTask = new Task(task.getTitle(), task.getStatus());
            user.getTasks().add(newTask);
        }

        return project;
    }

    public Task getTask(Long id, Project project) throws TaskNotFoundException, ProjectNotFoundException{

        Project existingProject = projectService.get(project.getId());

        if (existingProject != null) {
            List<Task> tasks = project.getTasks();
            for (Task task : tasks) {
                if (task.getId().equals(id)) {
                    return task;
                }
            }
        }

        throw new TaskNotFoundException();
    }

    public Task updateTask(Task task, Project project) throws TaskNotFoundException, ProjectNotFoundException{
        Project existingProject = projectService.get(project.getId());

        if (existingProject != null) {
            List<Task> tasks = project.getTasks();
            for (Task existingTask : tasks) {
                if (existingTask.getId().equals(task.getId())) {
                    existingTask.setId(task.getId());
                    existingTask.setStatus(task.getStatus());
                    return existingTask;
                }
            }
        }

        throw new TaskNotFoundException();
    }

    public boolean deleteTask(Long id, Project project)  {
        try {
            Task task = getTask(id, project);
            if (task != null) {
                return project.getTasks().remove(task);
            }
        } catch (TaskNotFoundException | ProjectNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Task> getTasks(Long projectId, TaskStatus  taskStatus) throws ProjectNotFoundException{
        Project project = projectService.get(projectId);
        List<Task> tasksWithStatus = new ArrayList<>();
        if (project != null) {
            List<Task> tasksForProject = project.getTasks();

            for (Task task : tasksForProject) {
                TaskStatus status = task.getStatus();
                if (status == taskStatus) {
                    tasksWithStatus.add(task);
                }
            }
        }
        return tasksWithStatus;
    }
}
