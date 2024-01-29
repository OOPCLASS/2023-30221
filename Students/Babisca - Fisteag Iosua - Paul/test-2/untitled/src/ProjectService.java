import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProjectService {
    private List<Project<Long>> projects;

    public ProjectService() {
        this.projects = new ArrayList<>();
    }

    public Project<Long> createProject(Project<Long> project) {
        for (Project<Long> existingProject : projects) {
            if (existingProject.getTitle().equals(project.getTitle())) {
                throw new DuplicateProjectNameException("A project with the same name already exists.");
            }
        }
        project.setId(UUID.randomUUID().toString());
        project.setCreationDate(LocalDateTime.now());
        projects.add(project);
        return project;
    }

    public Project<Long> getProject(String id) {
        for (Project<Long> existingProject : projects) {
            if (existingProject.getId().equals(id)) {
                return existingProject;
            }
        }
        throw new ProjectNotFoundException("Project with id " + id + " not found.");
    }

    public Project<Long> updateProject(String id, Project<Long> project) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId().equals(id)) {
                projects.set(i, project);
                return project;
            }
        }
        throw new ProjectNotFoundException("Project with id " + id + " not found.");
    }

    public boolean deleteProject(String id) {
        for (Project<Long> existingProject : projects) {
            if (existingProject.getId().equals(id)) {
                long monthsSinceCreation = ChronoUnit.MONTHS.between(existingProject.getCreationDate(), LocalDateTime.now());
                if (monthsSinceCreation > 6 || !existingProject.getTasks().stream().anyMatch(task -> task.getStatus() == TaskStatus.IN_PROGRESS)) {
                    projects.remove(existingProject);
                    return true;
                }
                return false;
            }
        }
        throw new ProjectNotFoundException("Project with id " + id + " not found.");
    }


}