package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.*;

// Am ales ca si colectie o lista, unde ii pun users
public class TaskManagementService {
    private ProjectService projectService;
    private List<User> users;

    public TaskManagementService(ProjectService projectService, List<User> users) {
        this.projectService = projectService;
        this.users = users;
    }

    public User registerUser(User user) {
        users.add(user);
        return user;
    }

    public Project createTask(User user, Project project, String title) {
        Task task = new Task(title, TaskStatus.CREATED);
        project.addTask(task);
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
        throw new TaskNotFoundException("Task with ID " + id + " not found.");
    }

    public Project updateTask(Task task, Project project) {
        Task existingTask = getTask(task.getId());
        existingTask.setTitle(task.getTitle());
        existingTask.setStatus(task.getStatus());
        return project;
    }

    public boolean deleteTask(Long id) {
        for (Project project : projectService.getProjects()) {
            List<Task> tasks = project.getTasks();
            tasks.removeIf(task -> task.getId().equals(id));
        }
        return true; // Întotdeauna returnăm true dacă ștergerea a avut succes
    }

    public List<Task> getTasks(Long projectId, TaskStatus taskStatus) {
        try {
            Project project = projectService.get(projectId);
            List<Task> filteredTasks = new ArrayList<>();
            for (Task task : project.getTasks()) {
                if (task.getStatus().equals(taskStatus)) {
                    filteredTasks.add(task);
                }
            }
            return filteredTasks;
        } catch (ProjectNotFoundException e) {
            throw new TaskNotFoundException("Project with ID " + projectId + " not found.", e);
        }
    }

    // TaskManagementService
    public List<Task> getTasksByStatus(TaskStatus taskStatus) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Project project : projectService.getProjects()) {
            filteredTasks.addAll(project.getTasks().stream()
                    .filter(task -> task.getStatus() == taskStatus)
                    .collect(Collectors.toList()));
        }
        return filteredTasks;
    }


}
