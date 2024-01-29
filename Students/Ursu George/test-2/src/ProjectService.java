import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProjectService {
    private List<Project> projects = new ArrayList<>();
    public static Long nextProjectId = 1L;

    public ProjectService() {

    }

    public Project create(String title) {
        if (nextProjectId == 24L) {
            // throw new exception
            return null;
        } else {
            for (Project i : projects) {
                if (i.getTitle().equals(title)) {
                    throw new DuplicateProjectNameException("A project with same name already exists");
                }
            }
            Long id = this.getNextProjectId();
            /*List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                tasks.add(new Task());
            }*/
            Project project = new Project(id, title, null);
            this.projects.add(project);
            return project;
        }
    }

    public Boolean delete(Project project) {
        if (project == null) {
            throw new ProjectNotFoundException("No project foujnd to delete");
        } else {
            if (LocalDate.now().getMonthValue() - project.getCreationDate().getMonthValue() >= 6) {
                for (Project i : projects) {
                    if (i == project) {
                        this.projects.remove(i);
                        return true;
                    }
                }
            } else {
                for (Task i : project.getTasks()) {
                    if (i.getStatus() == TaskStatus.IN_PROGRESS) {
                        return false;
                    }
                }
            }

        }
        return false;
    }

    public Project get(String id) {
        Iterator aux = this.projects.iterator();

        Project project = null;
        do {
            if (!aux.hasNext()) {
                throw new ProjectNotFoundException("No project found");
            }
            project = (Project) aux.next();
        } while (!(project.getId().toString()).equals(id));
        return project;
    }

    public Project update(String id, Project project) {
        Project projectModified = this.get(id);
        projectModified.setTitle(project.getTitle());
        projectModified.setTasks(project.getTasks());
        return projectModified;
    }


    private Long getNextProjectId() {
        Long aux = nextProjectId;
        nextProjectId = aux + 1L;
        return aux;
    }
}
