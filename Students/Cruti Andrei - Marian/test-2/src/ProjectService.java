import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class ProjectService {
    private List<Project> projects;

    public ProjectService(List<Project> projects) {
        this.projects = projects;
    }

    public ProjectService() {
        this.projects = new ArrayList<Project>();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Project createProject(String title, LocalDate creationDate) {
        checkForDuplicateTitle(title);
        Project project = new Project(title, creationDate);
        this.projects.add(project);
        return project;
    }

    public boolean deleteProject(Project project) {
        if(this.projects.contains(project)){
            for (Task i : project.getTasks()) {
                if (TaskStatus.TaskStatusEnum.IN_PROGRESS.equals(i.getStatus())
                && project.getCreationDate().isAfter(LocalDate.now().minusMonths(6))) {
                    return false;
                }
            }
            return this.projects.remove(project);
        } else throw new ProjectNotFoundException("Project '" + project.getTitle() + "' not found.");
    }

    public Project getProjectByID(String ID) {
        Long projectID = Long.getLong(ID);

        for (Project i : this.projects) {
            if(projectID.equals(i.getId())) {
                return i;
            }
        }
        throw new ProjectNotFoundException("Project with ID '" + ID + "' not found.");
    }

    public Project updateProject(String ID, Project project) {
        Project oldProject = getProjectByID(ID);
        for(Project i: this.projects) {
            if(i == oldProject) {
                i = project;
            }
        }
        return project;
    }

    private void checkForDuplicateTitle(String title) {
        if (isDuplicateTitle(title)) {
            throw new DuplicateProjectNameException("Project with name '" + title + "' already exists.");
        }
    }

    private boolean isDuplicateTitle(String title) {
        for(Project i: this.projects) {
            if(title.equals(i.getTitle()))
                return true;
        }
        return false;
    }
}
