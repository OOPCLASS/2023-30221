package taskManagementSystem;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ProjectService {

    private Map<Long, Project> projects = new HashMap<>();
    private static Long projectID = 0L;

    public Project create(String title) {
        for (Project project : projects.values())
            if (project.getTitle().equals(title)) {
                throw new DuplicateProjectNameException("A project with this name already exists");
            }
        Project newProject = new Project(generateID(), title);
        projects.put(newProject.getId(), newProject);
        return newProject;
    }

    public Project get(Long id) {
        if (!projects.containsKey(id)) {
            throw new ProjectNotFoundException("The project with id: " + id + " does not exist");
        }
        return projects.get(id);
    }

    public Project update(Long id, Project updatedProject) {
        if (!projects.containsKey(id)) {
            throw new ProjectNotFoundException("The project with id: " + id + " does not exist");
        }
        projects.replace(id, updatedProject);
        return projects.get(id);
    }

    public boolean delete(Project project) {
        Project foundProject = null;
        for (Project p : projects.values())
            if (p.equals(project)) {
                foundProject = p;
            }
        if (foundProject == null) {
            throw new ProjectNotFoundException("The project does not exist");
        }

        LocalDate dateAfter6Months = foundProject.getCreatedDate().plusMonths(6);
        if (dateAfter6Months.isBefore(LocalDate.now())) {
            projects.remove(foundProject.getId());
            return true;
        }

        for (Task task : foundProject.getTasks())
            if (task.getStatus() == TaskStatus.IN_PROGRESS) {
                return false;
            }

        projects.remove(foundProject.getId());
        return true;
    }

    private static Long generateID() {
        return projectID++;
    }

    public Map<Long, Project> getProjects() {
        return projects;
    }
}
