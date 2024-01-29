import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private List<Project> projects;

    public ProjectService() {
        projects = new ArrayList<Project>();
    }

    public Project create(String title) {
        for (Project project : projects) {
            if (project.getTitle() == title) {
                throw new DuplicateProjectNameException();
            }
        }

        Project project = new Project(title);

        projects.add(project);

        return project;
    }

    public Project get(Long id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                return project;
            }
        }

        throw new ProjectNotFoundException();
    }

    public Project update(Long id, Project project) {
        for (Project currentProject : projects) {
            if (currentProject.getId() == id) {
                currentProject = project;
            }
        }

        throw new ProjectNotFoundException();
    }

    public boolean delete(Project project) {
        for (Project currentProject : projects) {
            if (currentProject.getId() == project.getId()) {
                Period period = Period.between(currentProject.getCreatedDate(), LocalDate.now());

                if (period.toTotalMonths() > 6) {
                    projects.remove(currentProject);
                    return true;
                }

                for (Task task : currentProject.getTasks()) {
                    if (task.getStatus() == TaskStatus.IN_PROGRESS) {
                        return false;
                    }
                }

                projects.remove(currentProject);
                return true;
            }
        }

        throw new ProjectNotFoundException();
    }

    public List<Project> getProjects() {
        return projects;
    }
}
