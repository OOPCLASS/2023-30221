import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ProjectService {
    private Set<Project> projects;

    public ProjectService() {
        this.projects = new HashSet<>();
    }

    public Project create() {
        Long newProjectId = generateUniqueId();
        Project newProject = new Project(newProjectId, new ArrayList<>());

        for (Project existingProject : projects) {
            if (existingProject.getId().equals(newProjectId)) {
                throw new DuplicateProjectNameException("A project with the same ID already exists.");
            }
        }

        projects.add(newProject);
        return newProject;
    }

    public boolean delete(Project project) {
        if (!projects.contains(project)) {
            throw new ProjectNotFoundException("Project not found.");
        }

        if (hasInProgressTasks(project)) {
            return false;
        }

        if (isProjectOlderThanSixMonths(project)) {
            projects.remove(project);
            return true;
        }

        return false;
    }

    public Project get(Long id) {
        for (Project project : projects) {
            if (project.getId().equals(id)) {
                return project;
            }
        }
        throw new ProjectNotFoundException("Project not found with ID: " + id);
    }

    public Project update(Long id, Project updatedProject) {
        Project existingProject = get(id);

        existingProject.setTasks(updatedProject.getTasks());

        return existingProject;
    }
    private boolean hasInProgressTasks(Project project) {
        for (Task task : project.getTasks()) {
            if (TaskStatus.IN_PROGRESS.equals(task.getStatus())) {
                return true;
            }
        }
        return false;
    }

    private boolean isProjectOlderThanSixMonths(Project project) {
        LocalDateTime projectCreationTime = project.getCreationTime();
        LocalDateTime sixMonthsAgo = LocalDateTime.now().minus(6, ChronoUnit.MONTHS);

        return projectCreationTime.isBefore(sixMonthsAgo);
    }


    private static Long generateUniqueId() {
        UUID uuid = UUID.randomUUID();
        return Long.valueOf(uuid.toString());
    }

    public Project getProjectByTaskID(Long taskId) {
        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (task.getId().equals(taskId)) {
                    return project;
                }
            }
        }
        throw new ProjectNotFoundException("No project found for task with ID: " + taskId);
    }


    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}