package main;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private List<Project> projects;
    private long projectIdCounter;

    public ProjectService() {
        this.projects = new ArrayList<>();
        this.projectIdCounter = 1L;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Project createProject(String projectName) {
        if (isDuplicateProjectName(projectName)) {
            throw new DuplicateProjectNameException(projectName);
        }

        Project project = new Project();
        project.setTitle(projectName);
        long projectId = generateUniqueId();
        project.setId(projectId);

        projects.add(project);
        return project;
    }
    private  long generateUniqueId() {

        return projectIdCounter++;
    }

    private boolean isDuplicateProjectName(String projectName) {
        for (Project project : projects) {
            if (project.getTitle().equals(projectName)) {
                return true;
            }
        }
        return false;
    }
    public Project getProject(Long projectId) {
        for (Project project : projects) {
            if (project.getId().equals(projectId)) {
                return project;
            }
        }
        throw new ProjectNotFoundException(projectId);
    }
    public Project updateProject(Long projectId, Project updatedProject) {
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            if (project.getId().equals(projectId)) {
                project.setTitle(updatedProject.getTitle());
                project.setTasks(updatedProject.getTasks());
                return project;
            }
        }
        throw new ProjectNotFoundException(projectId);
    }

    public boolean deleteProject(Project project) {
        if (!projects.contains(project)) {
            throw new ProjectNotFoundException(project.getId());
        }

        if (hasInProgressTasks(project) && !isSixMonthsPassed(project.getCreationDateTime())) {
            return false;
        }

        projects.remove(project);
        return true;
    }
    private boolean hasInProgressTasks(Project project) {
        for (Task task : project.getTasks()) {
            if (task.getStatus() == TaskStatus.IN_PROGRESS) {
                return true;
            }
        }
        return false;
    }
    private boolean isSixMonthsPassed(LocalDateTime creationDateTime) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        long sixMonthsInMillis = 6L * 30 * 24 * 60 * 60 * 1000;
        return ChronoUnit.MILLIS.between(creationDateTime, currentDateTime) > sixMonthsInMillis;
    }
}
