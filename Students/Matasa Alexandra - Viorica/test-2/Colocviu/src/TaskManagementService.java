import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManagementService {
    private static int nrUsers = 0;
    private static long nrTasks = 0;
    private ProjectService projectService;
    private List<User> users;

    public TaskManagementService(ProjectService projectService){
        this.projectService = projectService;
        users = new ArrayList<>();
    }

    public User registerUser(User user) throws EmailAlreadyTakenException{
        for(User currentUser: users){
            if(currentUser.getEmail().equals(user.getEmail())){
                throw new EmailAlreadyTakenException("Email already taken: " + user.getEmail());
            }
        }
        String userId = "U"+nrUsers++;
        user.setId(userId);
        users.add(user);
        return user;
    }

    public Project createTask(User user, Project project){
        Long taskId = 100*nrTasks++;
        Task newTask = new Task(taskId);
        newTask.setStatus(TaskStatus.CREATED);

        project.addTask(newTask);
        return project;
    }

    public Task getTask(Long id) throws TaskNotFoundException{
        for(User user: users){
            for (Task task : user.getTasks()) {
                if (task.getId().equals(id)) {
                    return task;
                }
            }
        }
        throw new TaskNotFoundException("Task not found with ID: " + id);
    }

    public Project updateTask(Task task, Project project) throws TaskNotFoundException{
        for(Task currentTask: project.getTasks()){
            if(currentTask.getId().equals(task.getId())){
                currentTask.setTitle(task.getTitle());
                currentTask.setStatus(task.getStatus());
                return project;
            }
        }
        throw new TaskNotFoundException("Task not found!");
    }

    public boolean deleteTask(Long id) throws TaskNotFoundException{
        for(User user: users){
            for(Task task: user.getTasks()){
                if(task.getId().equals(id)){
                    user.getTasks().remove(task);
                    return true;
                }
            }
        }
       throw new TaskNotFoundException("Task not found!");
    }

    public List<Task> getTasks(Long projectId, TaskStatus taskStatus){
        Project project = projectService.get(projectId);
        List<Task> tasksSearched = new ArrayList<>();
        for(Task task: project.getTasks()){
            if(task.getStatus().equals(taskStatus)){
                tasksSearched.add(task);
            }
        }
        return tasksSearched;
    }

    public Map<Project, List<Task>> getTasks(TaskStatus taskStatus){
        Map<Project, List<Task>> projectTasks = new HashMap<>();
        for(User user: users){
            for(Task task: user.getTasks()){
                if(task.getStatus().equals(taskStatus)){
                    Project project = projectService.getProjectByTask(task);
                    if(projectTasks.containsKey(project)){
                        projectTasks.get(project).add(task);
                    }
                    else{
                        List<Task> listTask = new ArrayList<>();
                        listTask.add(task);
                        projectTasks.put(project, listTask);
                    }
                }
            }
        }
        return projectTasks;
    }
}
