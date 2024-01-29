package taskManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManagementService {
    private ProjectService projectService;
    private Map<String, User> users = new HashMap<>();

    public TaskManagementService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public User registerUser(User user) throws EmailAlreadyTakenException {
        for (User u : users.values())
            if (u.getEmail().equals(user.getEmail())) {
                throw new EmailAlreadyTakenException("A user already has this email");
            }

        users.put(user.getId(), user);
        return user;
    }

    public Project createTask(User user, Project project, String title) {
        if (!projectService.getProjects().containsValue(project)) {
            throw new ProjectNotFoundException("This project does not exist");
        }
        if (!users.containsValue(user)) {
            throw new UserNotFound("This user does not exist");
        }
        Task newTask = new Task((project.getId() + 1) * 100 + project.generateTaskID(), title);
        user.getTasks().add(newTask);
        project.getTasks().add(newTask);
        projectService.update(project.getId(), project);
        return projectService.get(project.getId());
    }

    public Task getTask(Long id) {
        Task foundTask = null;
        for (Project project : projectService.getProjects().values()) {
            for (Task task : project.getTasks())
                if (task.getId().equals(id)) {
                    foundTask = task;
                }
        }
        if (foundTask == null) {
            throw new TaskNotFoundException("The task with id: " + id + " does not exist");
        }
        return foundTask;
    }

    public Project updateTask(Task updatedTask, Project project) {
        Task foundTask = null;
        for (Task task : project.getTasks())
            if (task.getId().equals(updatedTask.getId())) {
                foundTask = task;
            }
        if (foundTask == null) {
            throw new TaskNotFoundException("The task with id: " + updatedTask.getId() + " does not exist");
        }
        project.getTasks().remove(foundTask);
        project.getTasks().add(updatedTask);
        projectService.update(project.getId(), project);
        return projectService.get(project.getId());
    }

    public boolean deleteTask(Long id) {
        Task foundTask = null;
        Project foundProject = null;
        for (Project project : projectService.getProjects().values()) {
            for (Task task : project.getTasks())
                if (task.getId().equals(id)) {
                    foundTask = task;
                    foundProject = project;
                }
        }
        if (foundTask == null) {
            throw new TaskNotFoundException("The task with id: " + id + " does not exist");
        }
        if (foundTask.getStatus().equals(TaskStatus.IN_PROGRESS)) {
            return false;
        }

        foundProject.getTasks().remove(foundTask);
        projectService.update(foundProject.getId(), foundProject);
        return true;
    }

    public List<Task> getTasks(Long projectID, TaskStatus taskStatus) {
        if (!projectService.getProjects().containsKey(projectID)) {
            throw new ProjectNotFoundException("The project with id: " + projectID + " does not exist");
        }
        Project project = projectService.getProjects().get(projectID);
        List<Task> tasks = new ArrayList<>();
        for (Task task : project.getTasks()) {
            if (task.getStatus().equals(taskStatus)) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    public Map<Project, Task> getTasks(TaskStatus taskStatus) {
        Map<Project, Task> tasks = new HashMap<>();
        for (Project project : projectService.getProjects().values()) {
            for (Task task : project.getTasks())
                if (task.getStatus().equals(taskStatus)) {
                    tasks.put(project, task);
                }
        }
        return tasks;
    }

    public void displayDetails() {
        for (Project project : projectService.getProjects().values()) {
            System.out.println("project " + project.getTitle() + " " + project.getId());
            for (Task task : project.getTasks())
                System.out.println("    task " + task.getTitle() + " " + task.getId() + " " + task.getStatus());
        }
        for (User user : users.values()) {
            System.out.println(user.getId() + " " + user.getEmail());
            for (Task task : user.getTasks())
                System.out.println("    task " + task.getTitle() + " " + task.getId() + " " + task.getStatus());
        }
    }
}
