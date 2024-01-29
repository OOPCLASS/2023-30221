package pack;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


import pack.EmailAlreadyTakenException;

public class TaskManagementService {
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Task> tasks = new HashMap<>();
    private Map<Integer, Project> projects = new HashMap<>(); // Am adăugat variabila projects

    public void registerUser(User user) throws EmailAlreadyTakenException {
        if (users.values().stream().anyMatch(existingUser -> existingUser.getEmail().equals(user.getEmail()))) {
            throw new EmailAlreadyTakenException("Email already taken: " + user.getEmail());
        }
        users.put(user.getId(), user);
    }

    public void createTask(int taskId, String taskName, TaskStatus status, int projectId) {
        if (tasks.containsKey(taskId)) {
            throw new RuntimeException("Task ID must be unique");
        }
        Task task = new Task(taskId, taskName, status);
        tasks.put(taskId, task);

        // Adaugă task-ul la proiect
        Project project = projects.get(projectId);
        if (project != null) {
            project.addTask(task);
        }
    }

    public Task getTask(int taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new RuntimeException("Task not found");
        }
        return tasks.get(taskId);
    }

    public void updateTask(int taskId, String newName, TaskStatus newStatus) {
        if (!tasks.containsKey(taskId)) {
            throw new RuntimeException("Task not found");
        }

        Task task = tasks.get(taskId);
        task.setName(newName);
        task.setStatus(newStatus);
    }

    public boolean deleteTask(int taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new RuntimeException("Task not found");
        }

        Task task = tasks.get(taskId);
        tasks.remove(taskId);

        // Găsește și elimină task-ul din proiecte
        for (Project project : projects.values()) {
            if (project.getTasks().remove(task)) {
                // S-a găsit și eliminat task-ul dintr-un proiect
                return true;
            }
        }

        // Task-ul nu a fost găsit în niciun proiect
        return false;
    }

    public List<Task> getTasksByStatus(int projectId, TaskStatus status) {
        Project project = projects.get(projectId);

        if (project != null) {
            List<Task> tasksByStatus = new ArrayList<>();

            for (Task task : project.getTasks()) {
                if (task.getStatus() == status) {
                    tasksByStatus.add(task);
                }
            }

            return tasksByStatus;
        } else {
            // Proiectul nu a fost găsit, aruncă o excepție corespunzătoare
            throw new ProjectNotFoundException("Project not found with ID: " + projectId);
        }
    }

    public Map<Project, List<Task>> getTasksByStatusAcrossProjects(TaskStatus status) {
        Map<Project, List<Task>> tasksByStatusMap = new HashMap<>();

        for (Project project : projects.values()) {
            List<Task> tasksByStatus = new ArrayList<>();

            for (Task task : project.getTasks()) {
                if (task.getStatus() == status) {
                    tasksByStatus.add(task);
                }
            }

            tasksByStatusMap.put(project, tasksByStatus);
        }

        return tasksByStatusMap;
    }
}
