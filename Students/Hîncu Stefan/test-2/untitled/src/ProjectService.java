import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class ProjectService {
    private Map<String, Project<Long>> projects = new HashMap<>();
    private static Long nextId = 1L;

    public Map<String, Project<Long>> getProjects() {
        return projects;
    }

    public Project<Long> createProject() {
        Project<Long> project = new Project();

        project.setId(nextId.toString());
        nextId++;
        project.setCreationDate(LocalDateTime.now());

        for (Project<Long> existingProject : projects.values()) {
            if (existingProject.getTitle().equals(project.getTitle())) {
                throw new DuplicateProjectNameException("A project with the same name already exists.");
            }
        }

        projects.put(project.getId(), project);

        return project;
    }

    public Project<Long> get(String id) {
        Project<Long> project = projects.get(id);

        if (project == null) {
            throw new ProjectNotFoundException("Project with id " + id + " not found.");
        }

        return project;
    }

    public Project<Long> update(String id, Project<Long> project) {
        if (!projects.containsKey(id)) {
            throw new ProjectNotFoundException("Project with id " + id + " not found.");
        }

        projects.put(id, project);

        return project;
    }

    public boolean delete(Project<Long> project) {
        String id = project.getId();

        if (!projects.containsKey(id)) {
            throw new ProjectNotFoundException("Project with id " + id + " not found.");
        }

        boolean hasInProgressTasks = project.getTasks().stream().anyMatch(task -> task.getStatus() == TaskStatus.IN_PROGRESS);

        boolean olderThanSixMonths = ChronoUnit.MONTHS.between(project.getCreationDate(), LocalDateTime.now()) > 6;

        if (hasInProgressTasks && !olderThanSixMonths) {
            return false;
        }

        projects.remove(id);

        return true;
    }
}