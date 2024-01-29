package main;

import java.util.ArrayList;
import java.util.List;

public class TaskManagementService {
    private ProjectService projectService;
    private List<User> users;
    private long userIdCounter;

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
    public TaskManagementService() {
        this.projectService = new ProjectService();
        this.users = new ArrayList<>();
        this.userIdCounter = 1L;
    }
    public User registerUser(User user) throws EmailAlreadyTakenException {
        if (isEmailTaken(user.getEmail())) {
            throw new EmailAlreadyTakenException(user.getEmail());
        }

        long userId = generateUniqueId();
        user.setId(String.valueOf(userId));

        users.add(user);
        return user;
    }

    private boolean isEmailTaken(String email) {
        for (User existingUser : users) {
            if (existingUser.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private long generateUniqueId() {
        return userIdCounter++;
    }
    public Task getTask(Long taskId) {
        for (User user : users) {
            for (Task task : user.getTasks()) {
                if (task.getId().equals(taskId)) {
                    return task;
                }
            }
        }
        throw new TaskNotFoundException(taskId);
    }
    public Task createTask(User user, Project project, String taskTitle) {
        Task task = new Task();
        task.setTitle(taskTitle);
        task.setStatus(TaskStatus.CREATED);

        project.getTasks().add(task);
        user.getTasks().add(task);

        return task;
    }
    public boolean deleteTask(Long taskId) {
        for (User user : users) {
            for (Task task : user.getTasks()) {
                if (task.getId().equals(taskId)) {
                    return user.getTasks().remove(task);
                }
            }
        }
        throw new TaskNotFoundException(taskId);
    }
    public Project updateTask(Task task, Project project) {
        boolean taskFound = false;

        for (User user : users) {
            for (Task userTask : user.getTasks()) {
                if (userTask.getId().equals(task.getId())) {
                    userTask.setTitle(task.getTitle());
                    userTask.setStatus(task.getStatus());
                    taskFound = true;
                    break;
                }
            }

            if (taskFound) {
                break;
            }
        }

        if (!taskFound) {
            throw new TaskNotFoundException(task.getId());
        }
        Project updatedProject = projectService.updateProject(project.getId(), project);
        return updatedProject;
    }

}
