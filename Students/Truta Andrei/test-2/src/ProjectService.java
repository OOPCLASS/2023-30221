import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private List<Project> projects = new ArrayList<Project>();

    public List<Project> getProjects() {
        return projects;
    }

    public Project create(String title) {
        //New ID gets assigned in on instantiation, check constructor
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }

        //Check if project with same title already exists
        for (Project project : projects) {
            if (project.getTitle().equals(title)) {
                throw new DuplicateProjectNameException("Project with title " + title + " already exists");
            }
        }

        Project project = new Project(title);
        projects.add(project);
        return project;
    }

    public Project get(Long id) {
        for (Project project : projects) {
            if (project.getId().equals(id)) {
                return project;
            }
        }

        throw new ProjectNotFoundException("Project with ID " + id + " not found");
    }

    public Project update(Long id, Project project) {
        for (Project projectToUpdate : projects) {
            if (projectToUpdate.getId().equals(id)) {
                projectToUpdate.setTitle(project.getTitle());
                projectToUpdate.setTasks(project.getTasks());
                return projectToUpdate;
            }
        }

        throw new ProjectNotFoundException("Project with ID " + id + " not found");
    }

    public Boolean delete(Project project) {
        for (Project projectToDelete : projects) {
            if (projectToDelete.getId().equals(project.getId())) {
                LocalDateTime dateTime2 = project.getCreatedAt();

                for (Task task : projectToDelete.getTasks()) {
                    LocalDateTime dateTime1 = LocalDateTime.now();
                    long diff = ChronoUnit.MONTHS.between(dateTime2, dateTime1);
                    if (task.getStatus() == TaskStatus.IN_PROGRESS && diff < 6) {
                        return false;
                    }
                }

                projects.remove(projectToDelete);
                return true;
            }
        }

        throw new ProjectNotFoundException("Project with ID " + project.getId() + " not found");
    }
}
