
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.time.LocalDate;

public class ProjectService {
    private Map<String, Project> projects;
    private Map<String, LocalDate> projectCreationDates;

    public ProjectService() {
        this.projects = new HashMap<>();
        this.projectCreationDates = new HashMap<>();
    }

    public ProjectService(List<Project> list) {
        this.projects = new HashMap<>();
        this.projectCreationDates = new HashMap<>();
        for (Project project : list) {
            addProject(project);
        }
    }

    public List<Project> getProjects() {
        return new ArrayList<>(projects.values());
    }

    public void addProject(Project project) {
        if (project.getTitle() == null || projects.containsKey(project.getTitle())) {
            throw new DuplicateProjectNameException("A project with the same title already exists.");
        }
        projects.put(project.getTitle(), project);
        projectCreationDates.put(project.getTitle(), LocalDate.now());
    }

    public Project getProjectByTitle(String projectTitle) {
        if (projects.containsKey(projectTitle)) {
            return projects.get(projectTitle);
        } else {
            throw new ProjectNotFoundException("Project not found with title: " + projectTitle);
        }
    }

    public void updateProject(Project updatedProject) {
        String projectTitle = updatedProject.getTitle();
        if (projects.containsKey(projectTitle)) {
            projects.put(projectTitle, updatedProject);
        } else {
            throw new ProjectNotFoundException("Project not found with title: " + projectTitle);
        }
    }

    public boolean removeProject(String projectTitle) {
        if (!projects.containsKey(projectTitle)) {
            throw new ProjectNotFoundException("Project not found with title: " + projectTitle);
        }

        if (hasInProgressTasks(projectTitle) && !hasPassedSixMonths(projectTitle)) {
            return false;
        }

        projects.remove(projectTitle);
        projectCreationDates.remove(projectTitle);
        return true;
    }

    private boolean hasInProgressTasks(String projectTitle) {
        Project project = projects.get(projectTitle);
        if (project != null) {
            for (Task task : project.getTasks()) {
                if (TaskStatus.IN_PROGRESS.equals(task.getStatus())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPassedSixMonths(String projectTitle) {
        LocalDate creationDate = projectCreationDates.get(projectTitle);
        if (creationDate != null) {
            LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
            return creationDate.isBefore(sixMonthsAgo);
        }
        return false;
    }
}
