import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ProjectService {
    private List<Project> projects;

    public ProjectService() {
        this.projects = new ArrayList<>();
    }

    public Project create(String title) {

        Long projectId = generateUniqueProjectId();

        if (isDuplicateProjectName(title)) {
            throw new DuplicateProjectNameException("Project with the same name already exists");
        }

        Project project = new Project(projectId, title, new ArrayList<>());
        projects.add(project);
        return project;
    }

    public boolean delete(Project project) {

        if (!projects.contains(project)) {
            throw new ProjectNotFoundException("Project not found");
        }

        if (hasTasksInProgress(project)) {
            return false;
        }

        return false;
    }

    public Project get(Long id) {
        for (Project project : projects) {
            if (project.getId().equals(id)) {
                return project;
            }
        }
        throw new ProjectNotFoundException("Project not found");
    }

    public Project update(Long id, Project updatedProject) {
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            if (project.getId().equals(id)) {
                projects.set(i, updatedProject);
                return updatedProject;
            }
        }
        throw new ProjectNotFoundException("Project not found");
    }

    public List<Task> getTasksByStatus(Long projectId, TaskStatus status) {
        Project project = get(projectId);
        List<Task> tasksWithStatus = new ArrayList<>();

        for (Task task : project.getTasks()) {
            if (task.getStatus() == status) {
                tasksWithStatus.add(task);
            }
        }

        return tasksWithStatus;
    }

    public List<Task> getAllTasksByStatus(TaskStatus status) {
        List<Task> tasksWithStatus = new ArrayList<>();

        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (task.getStatus() == status) {
                    tasksWithStatus.add(task);
                }
            }
        }

        return tasksWithStatus;
    }


    private Long generateUniqueProjectId() {
        UUID uuid = UUID.randomUUID();
        return Long.valueOf(uuid.getMostSignificantBits());
    }



    private boolean isDuplicateProjectName(String title) {
        for (Project project : projects) {
            if (project.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasTasksInProgress(Project project) {
        for (Task task : project.getTasks()) {
            if (task.getStatus() == TaskStatus.In_Progress) {
                return true;
            }
        }
        return false;
    }

}
