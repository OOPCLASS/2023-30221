
import java.util.HashMap;
import java.util.Map;
public class ProjectService {
    private Map<Long, Project> projects;

    public ProjectService() {
        this.projects = new HashMap<>();
    }

    public void createProject(Project project) {
        if (projects.containsKey(project.getProjectId())) {
            throw new DuplicateProjectNameException("Duplicate project name: " + project.getProjectName());
        }
        projects.put(project.getProjectId(), project);
    }

    public Project getProject(long projectId) {
        if (!projects.containsKey(projectId)) {
            throw new ProjectNotFoundException("Project not found with ID: " + projectId);
        }
        return projects.get(projectId);
    }

    public void updateProject(long projectId, Project updatedProject) {
        if (!projects.containsKey(projectId)) {
            throw new ProjectNotFoundException("Project not found with ID: " + projectId);
        }
        projects.put(projectId, updatedProject);
    }
    public boolean deleteProject(long projectId) {
        Project project = projects.get(projectId);
        if (project == null) {
            throw new ProjectNotFoundException("Project not found with ID: " + projectId);
        }

        boolean hasInProgressTasks = project.getTasks().stream()
                .anyMatch(task -> task.getStatus() == TaskStatus.IN_PROGRESS);

        if (hasInProgressTasks) {
            return false;
        }

        projects.remove(projectId);
        return true;
    }

}
