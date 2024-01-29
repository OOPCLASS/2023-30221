import java.util.HashMap;
import java.util.Map;
public class ProjectService {
    private Map<Long, Project> projects;
    private Long projectIdGenerator;

    public ProjectService() {
        this.projects = new HashMap<>();
        this.projectIdGenerator = 1L;
    }

    public Map<Long, Project> getProjects() {
        return projects;
    }

    public Project create(Project project) throws DuplicateProjectNameException {
        if (projects.values().stream().anyMatch(p -> p.getTitle().equals(project.getTitle()))) {
            throw new DuplicateProjectNameException("Project with title " + project.getTitle() + " already exists");
        }
        Long projectId = projectIdGenerator++;
        project.setId(projectId);
        projects.put(projectId, project);
        return project;
    }

    public boolean delete(Project project) throws ProjectNotFoundException {
        if (!projects.containsKey(project.getId())) {
            throw new ProjectNotFoundException("Project with id " + project.getId() + " not found");
        }
        if (project.getTasks().stream().anyMatch(task -> task.getStatus() == TaskStatus.IN_PROGRESS)) {
            return false;
        }
        Long sixMonthsInMillis = 6 * 30 * 24 * 60 * 60 * 1000L;
        if (System.currentTimeMillis() - project.getCreationTime() < sixMonthsInMillis) {
            return false;
        }
        projects.remove(project.getId());
        return true;
    }

    public Project get(Long id) throws ProjectNotFoundException {
        Project project = projects.get(id);
        if (project == null) {
            throw new ProjectNotFoundException("Project with id " + id + " not found");
        }
        return project;
    }

    public Project update(Long id, Project updatedProject) throws ProjectNotFoundException {
        if (!projects.containsKey(id)) {
            throw new ProjectNotFoundException("Project with id " + id + " not found");
        }
        updatedProject.setId(id);
        projects.put(id, updatedProject);
        return updatedProject;
    }
}
