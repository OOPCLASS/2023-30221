import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private List<Project> projects;

    public ProjectService() {
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Project getProjectById(long projectId) {
        for (Project project : projects) {
            if (project.getId() == projectId) {
                return project;
            }
        }
        throw new ProjectNotFoundException("Project with id " + projectId + " not found.");
    }

    public boolean projectExists(long projectId) {
        for (Project project : projects) {
            if (project.getId() == projectId) {
                return true;
            }
        }
        return false;
    }

    public void addProject(Project project) {
        for (Project existingProject : projects) {
            if (existingProject.getTitle().equals(project.getTitle())) {
                throw new DuplicateProjectNameException("Project with name " + project.getTitle() + " already exists.");
            }
        }
        long projectId = generateUniqueId();
        project.setId(projectId);
        projects.add(project);
    }

    public void updateProject(Project project) {
        long projectId = project.getId();
        boolean projectExists = false;
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId() == projectId) {
                projects.set(i, project);
                projectExists = true;
                break;
            }
        }
        if (!projectExists) {
            throw new ProjectNotFoundException("Project with id " + projectId + " not found.");
        }
    }

    public boolean deleteProject(long projectId) {
        Project projectToDelete = null;
        for (Project project : projects) {
            if (project.getId() == projectId) {
                projectToDelete = project;
                break;
            }
        }

        if (projectToDelete == null) {
            throw new ProjectNotFoundException("Project with id " + projectId + " not found.");
        }

        List<Task> inProgressTasks = new ArrayList<>();
        for (Task task : projectToDelete.getTasks()) {
            if (task.getStatus() == TaskStatus.IN_PROGRESS) {
                inProgressTasks.add(task);
            }
        }

        if (!inProgressTasks.isEmpty() && projectCreatedMoreThan6MonthsAgo(projectToDelete)) {
            projects.remove(projectToDelete);
            return true;
        } else {
            return false;
        }
    }

    private boolean projectCreatedMoreThan6MonthsAgo(Project project) {
        LocalDateTime projectCreationDateTime = project.getCreationDateTime();
        long monthsDifference = ChronoUnit.MONTHS.between(projectCreationDateTime, LocalDateTime.now());
        return monthsDifference >= 6;
    }

    ///returneza un long care reprezinta timpul care a trecut in milisecunde din data 1970-01-01 astfel id-urile o sa fie unice deoarece nu se genereaza 2 in aceasi milisecunda
    private long generateUniqueId() {
        return System.currentTimeMillis();
    }
}