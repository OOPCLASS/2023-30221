import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
public class ProjectService {
    private List<Project>projects;
    private static final AtomicInteger projectIdCounter = new AtomicInteger(1);
    public ProjectService() {
        this.projects = new ArrayList<>();
    }
    public void createProject(Project project) throws DuplicateProjectNameException {
        if (projects.stream().anyMatch(p -> p.getName().equals(project.getName()))) {
            throw new DuplicateProjectNameException();
        }
        project.setId(generateUniqueId());
        projects.add(project);
    }

    public Project getProjectById(int projectId) throws ProjectNotFoundException {
        return projects.stream()
                .filter(p -> p.getId() == projectId)
                .findFirst()
                .orElseThrow(ProjectNotFoundException::new);
    }

    public void updateProject(Project project) throws ProjectNotFoundException {
        int index = findProjectIndexById(project.getId());
        if (index == -1) {
            throw new ProjectNotFoundException();
        }
        projects.set(index, project);
    }

    public boolean deleteProject(int projectId) throws ProjectNotFoundException {
        Project project = getProjectById(projectId);

        if (project.getTasks().stream().anyMatch(task -> task.getStatus() == TaskStatus.IN_PROGRESS)) {
            return false;
        }

        long sixMonthsInMillis = 6 * 30 * 24 * 60 * 60 * 1000L;
        if (System.currentTimeMillis() - project.getCreationDate().getTime() < sixMonthsInMillis) {
            return false;
        }

        projects.remove(project);
        return true;
    }

    private int generateUniqueId() {
        // Generate unique ID logic
        return projectIdCounter.getAndIncrement();
    }

    private int findProjectIndexById(int projectId) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId() == projectId) {
                return i;
            }
        }
        return -1;
    }
}
