package demo;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

public class ProjectService {
    private Map<Long, Project> projects;

    public ProjectService() {
        this.projects = new HashMap<>();
    }

    public Project create(String title) {
        if (projectExists(title)) {
            throw new DuplicateProjectNameException("Sorry! Project already exists");
        }

        Project project = new Project();
        project.setId(generateUniqueId());
        project.setTitle(title);
        projects.put(project.getId(), project);

        return project;
    }

    public boolean delete(Project project) {
        if (!projects.containsKey(project.getId())) {
            throw new ProjectNotFoundException("Project with ID " + project.getId() + " not found");
        }

        if (hasTasksInProgress(project)) {
            return false;
        }

        return projects.remove(project.getId()) != null;
    }

    public Project get(Long id) {
        Project project = projects.get(id);
        if (project == null) {
            throw new ProjectNotFoundException("Project with ID " + id + " not found.");
        }
        return project;
    }

    public Project update(Long id, Project updatedProject) {
        if (projects.containsKey(id)) {
            Project existingProject = projects.get(id);
            existingProject.setTitle(updatedProject.getTitle());
            return existingProject;
        } else {
            throw new ProjectNotFoundException("Project with ID " + id + " not found.");
        }
    }

    private boolean projectExists(String title) {
        return projects.values().stream().anyMatch(p -> p.getTitle().equals(title));
    }

    private Long generateUniqueId() {
        long id = 1;
        while (projects.containsKey(id)) {
            id++;
        }
        return id;
    }

    private boolean hasTasksInProgress(Project project) {
        return project.getTasks().stream().anyMatch(task -> task.getStatus() == TaskStatus.IN_PROGRESS);
    }

    public List<Task> getTasks(Long projectId, TaskStatus taskStatus) {
        try {
            Project project = this.get(projectId);
            List<Task> filteredTasks = new ArrayList<>();
            for (Task task : project.getTasks()) {
                if (task.getStatus().equals(taskStatus)) {
                    filteredTasks.add(task);
                }
            }
            return filteredTasks;
        } catch (ProjectNotFoundException e) {
            throw new TaskNotFoundException("Task with ID " + projectId + " not found.", e);
        }
    }

    public Collection<Project> getProjects() {
        return projects.values();
    }
}
