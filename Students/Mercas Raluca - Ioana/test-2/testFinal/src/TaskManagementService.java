import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class TaskManagementService {
    private ProjectService projectService;
    private List<User> users;
    private static final AtomicLong userCounter = new AtomicLong(100);
    private static final AtomicLong taskCounter = new AtomicLong(1000);


    public TaskManagementService(ProjectService projectService, List<User> users) {
        this.projectService = projectService;
        this.users = users;
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

    public User registerUser(User user) throws EmailAlreadyTakenException {
        String userId = "U" + userCounter.getAndIncrement();
        User newUser = new User(userId);
        for(User user1: users) {
            if(user1.getEmail().equals(user.getEmail())) {
                throw new EmailAlreadyTakenException("Cannot have two users with the same email!");
            }
        }
        users.add(user);
        return user;
    }

    public Project createTask(User user, Project project, String title) {
        long taskId = taskCounter.getAndIncrement() + project.getId();
        Task newTask = new Task(taskId);
        newTask.setStatus(TaskStatus.CREATED);
        newTask.setTitle(title);
        List<Task> tasks = project.getTasks();
        tasks.add(newTask);
        project.setTasks(tasks);
        return project;
    }

    public Task getTask(Long id) {
//        boolean found = false;
        List<Project> projects = projectService.getProjects();
        for(Project project: projects) {
            List<Task> tasks = project.getTasks();
            for(Task task: tasks) {
                if(task.getId().equals(id)) {
//                    found = true;
                    return task;
                }
            }
        }
        throw new TaskNotFoundException("There is no task with the provided id");
    }

    public Project updateTask(Task task, Project project) {
        List<Task> tasks = project.getTasks();
        for(Task task1: tasks) {
            if(task1.getId().equals(task1.getId())) {
                task1.setTitle(task.getTitle());
                task1.setStatus(task.getStatus());
                project.setTasks(tasks);
                return project;
            }
        }
        throw new ProjectNotFoundException("Project not found");
    }

    public boolean deleteTask(Long id) {
        List<Project> projects = projectService.getProjects();
        for(Project project: projects) {
            List<Task> tasks = project.getTasks();
            Iterator<Task> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (task.getId().equals(id)) {
                    iterator.remove();
                    project.setTasks(tasks);
                    return true;
                }
            }
        }
        throw new TaskNotFoundException("There is no task with the provided id");
    }

    public List<Task> getTasks(Long projectId, TaskStatus taskStatus) {
        List <Task> tasksToReturn = new ArrayList<>();
        List<Project> projects = projectService.getProjects();
        for(Project project: projects) {
            if(project.getId().equals(projectId)) {
                List<Task> tasks = project.getTasks();
                for(Task task: tasks) {
                    if(task.getStatus().equals(taskStatus)) {
                        tasksToReturn.add(task);
                    }
                }
            }
        }
        if(!tasksToReturn.isEmpty()) {
            return tasksToReturn;
        }
        throw new TaskNotFoundException("Cannot find any tasks with the provided status");
    }

    public Map<Project, List<Task>> getTasksByStatus(TaskStatus taskStatus) {
        Map<Project, List<Task>> tasksByProject = new HashMap<>();
        List<Project> projects = projectService.getProjects();
        for (Project project : projects) {
            List<Task> tasks = project.getTasks();
            List<Task> tasksWithStatus = new ArrayList<>();
            for (Task task : tasks) {
                if (task.getStatus().equals(taskStatus)) {
                    tasksWithStatus.add(task);
                }
            }
            if (!tasksWithStatus.isEmpty()) {
                tasksByProject.put(project, tasksWithStatus);
            }
        }
        if (!tasksByProject.isEmpty()) {
            return tasksByProject;
        }
        throw new TaskNotFoundException("Cannot find any tasks with the provided status");
    }
}
