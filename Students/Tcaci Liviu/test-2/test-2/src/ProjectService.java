import java.time.LocalDateTime;
import java.util.*;

public class ProjectService {
    private Map<Long, Project> projects = new HashMap<>();
    private Long nextID = 1L; // unique id for each project

    Project create(String title) {
        for (Project project : projects.values()) {
            if (project.getTitle().equals(title)) {
                throw new DuplicateProjectNameException("A project with this name already exists");
            }
        }

        Project newProject = new Project();
        newProject.setId(nextID++);
        newProject.setTitle(title);
        newProject.setTasks(new ArrayList<>());
        newProject.setCreationTime(LocalDateTime.now());
        projects.put(newProject.getId(), newProject);
        return newProject;
    }

    boolean delete(long id) {
        Project project = get(id);
        for (Task task : project.getTasks()) {
            if (task.getStatus() == TaskStatus.IN_Progress
                    && project.getCreationTime().plusMonths(6).isAfter(LocalDateTime.now())) {
                return false; // cannot delete project with tasks in progress that are less than 6 months old
            }
        }
        projects.remove(id);
        return true;
    }

    Project get(Long id) {
        Project project = projects.get(id);
        if (project == null) {
            throw new ProjectNotFoundException("Project with id " + id + " not found");
        }
        return project;
    }

    Project update(Long id, String newTitle) {
        Project project = get(id);
        for (Project otherProject : projects.values()) {
            if (otherProject.getTitle().equals(newTitle) && !otherProject.getId().equals(project.getId())) {
                throw new DuplicateProjectNameException("A project with this name already exists");
            }
        }
        project.setTitle(newTitle);
        return project;
    }


    Map<Long, Project> getAllProjects() {
        return projects;
    }

}