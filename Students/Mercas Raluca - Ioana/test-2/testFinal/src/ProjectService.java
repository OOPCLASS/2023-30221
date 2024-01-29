import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ProjectService {
    List<Project> projects;
    private static final AtomicLong projectCounter = new AtomicLong(1);

    public ProjectService() {
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Project create(String title) {
        long projectId = projectCounter.getAndIncrement();
        for(Project project: projects) {
            if(project.getTitle().equals(title)) {
                throw new DuplicateProjectNameException("There already exists a project with the exact same name");
            }
        }
        Project newProject = new Project(projectId, title);
        projects.add(newProject);
        return newProject;
    }

    public Project get(Long id){
        for(Project project: projects) {
            if(project.getId().equals(id)) {
                return project;
            }
        }
        throw new ProjectNotFoundException("There is no project with the provided ID");
    }

    public Project update(Long id, Project project) {
        for(Project pr: projects) {
            if(pr.getId().equals(id)) {
                pr.setTasks(project.getTasks());
                pr.setTitle(project.getTitle());
                return pr;
            }
        }
        throw new ProjectNotFoundException("There is no project with the provided ID");
    }

    public boolean delete(Project project) {
        boolean found = false;
        for(Project pr: projects) {
            if(pr.getId().equals(project.getId())) {
                found = true;
            }
        }
        if(!found) {
            throw new ProjectNotFoundException("There is no project with the provided ID");
        }
        List<Task> tasks = project.getTasks();
        Duration projectDuration = Duration.between(project.getStartDate(), LocalDateTime.now());
        long months = projectDuration.toDays() / 30;
        if(months > 6) {
            projects.remove(project);
        } else {
            for(Task task: tasks) {
                if(task.getStatus().equals(TaskStatus.IN_PROGRESS)) {
                    return false;
                }
            }
        }
        return true;
    }
}
