package Colocviuoopfinal;

import java.util.stream.Collectors;
import java.util.*;


abstract class AbstractEntity<ID> {
    private ID id;

    public AbstractEntity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }
}


enum TaskStatus {
    CREATED,
    IN_PROGRESS,
    DONE
}


class Task extends AbstractEntity<Long> {
    private String title;
    private TaskStatus status;

    public Task(Long id, String title, TaskStatus status) {
        super(id);
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }
}


class Project extends AbstractEntity<Long> {
    private String title;
    private List<Task> tasks;

    public Project(Long id, String title) {
        super(id);
        this.title = title;
        this.tasks = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}


class User extends AbstractEntity<String> {
    private String email;
    private List<Task> tasks;

    public User(String email) {
        super(email);
        this.email = email;
        this.tasks = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}


class DuplicateProjectNameException extends RuntimeException {
    public DuplicateProjectNameException(String message) {
        super(message);
    }
}


class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String message) {
        super(message);
    }
}


class EmailAlreadyTakenException extends Exception {
    public EmailAlreadyTakenException(String message) {
        super(message);
    }
}


class ProjectService {
    private Map<Long, Project> projects = new HashMap<>();

    public Project createProject(String title) {
        
        if (projects.values().stream().anyMatch(p -> p.getTitle().equals(title))) {
            throw new DuplicateProjectNameException("Project with the same name already exists.");
        }

        Project project = new Project(nextId(), title);
        projects.put(project.getId(), project);
        return project;
    }

    public Project getProject(Long projectId) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new ProjectNotFoundException("Project with ID " + projectId + " not found.");
        }
        return project;
    }

    public void updateProject(Long projectId, Project updatedProject) {
        Project project = getProject(projectId);
        
    }

    public boolean deleteProject(Long projectId) {
        Project project = getProject(projectId);

        
        boolean inProgressTasksExist = project.getTasks().stream()
                .anyMatch(task -> task.getStatus() == TaskStatus.IN_PROGRESS);

        
        long currentTime = System.currentTimeMillis();
        long projectCreationTime = currentTime - project.getId(); // For demonstration purposes
        boolean moreThanSixMonthsPassed = currentTime - projectCreationTime > 6 * 30 * 24 * 60 * 60 * 1000L;

        if (!inProgressTasksExist || moreThanSixMonthsPassed) {
            projects.remove(projectId);
            return true; 
        } else {
            return false; 
        }
    }

    private Long nextId() {
        return projects.keySet().stream().max(Comparator.naturalOrder()).orElse(0L) + 1;
    }
}


class TaskManagementService {
    private ProjectService projectService;
    private Map<String, User> users = new HashMap<>();

    public TaskManagementService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public User registerUser(String email) throws EmailAlreadyTakenException {
        if (users.containsKey(email)) {
            throw new EmailAlreadyTakenException("User with the same email already registered.");
        }

        User user = new User(email);
        users.put(email, user);
        return user;
    }

    public Task createTask(User user, Project project, String taskTitle, TaskStatus status) {
        if (user == null || project == null) {
            throw new IllegalArgumentException("User and Project cannot be null.");
        }

        Task task = new Task(nextTaskId(), taskTitle, status);
        user.addTask(task);
        project.addTask(task);
        return task;
    }

    public Task getTask(Long taskId) {

        return null;
    }

    public void updateTask(Task task, Project project) {
        if (task == null || project == null) {
            throw new IllegalArgumentException("Task and Project cannot be null.");
        }

       
    }

    public void deleteTask(Long taskId) {

    }

    public List<Task> getTasks(Long projectId, TaskStatus status) {
        Project project = projectService.getProject(projectId);
        return project.getTasks().stream()
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }

    
    public List<Task> getTasksByStatus(TaskStatus status) {
       
        return null;
    }

    private Long nextTaskId() {
        return users.values().stream()
                .flatMap(user -> user.getTasks().stream())
                .map(Task::getId)
                .max(Comparator.naturalOrder())
                .orElse(0L) + 1;
    }
}



public class MainJv {
 public static void main(String[] args) {
     ProjectService projectService = new ProjectService();
     TaskManagementService taskManagementService = new TaskManagementService(projectService);

    
     Project project = projectService.createProject("Project A");
     User user = taskManagementService.registerUser("user@example.com");
     Task task = taskManagementService.createTask(user, project, "Task 1", TaskStatus.CREATED);

     
     taskManagementService.updateTask(task, project);

     
     projectService.updateProject(project.getId(), new Project(project.getId(), "New Project Title"));

     
     List<Task> tasksInProject = taskManagementService.getTasks(project.getId(), TaskStatus.IN_PROGRESS);

     
     displayProjectInfo(project);

     try {
       
         User duplicateUser = taskManagementService.registerUser("user1@example.com");
     } catch (EmailAlreadyTakenException e) {
         System.out.println("Error: " + e.getMessage());
     }

     try {
         
         Project nonExistentProject = projectService.getProject(999L);
     } catch (ProjectNotFoundException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }

 
 private static void displayProjectInfo(Project project) {
     
     System.out.println("Project ID: " + project.getId());
     System.out.println("Project Title: " + project.getTitle());
     System.out.println("Number of Tasks: " + project.getTasks().size());
 }
}
