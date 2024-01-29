import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

class ProjectService {
    private List<Project> projects;

    public ProjectService() {
        this.projects = new ArrayList<>();
    }

    public Project create(String title) {
        // Check for duplicate project names
        if (projects.stream().anyMatch(p -> p.getTitle().equals(title))) {
            throw new DuplicateProjectNameException("Project with the same name already exists");
        }

        // Create a new project with a unique ID
        Long newId = generateUniqueId();
        Project newProject = new Project(newId, title, new ArrayList<>());
        projects.add(newProject);

        return newProject;
    }

    private Long generateUniqueId() {
        // Replace this with a proper ID generation logic (e.g., using UUID)
        // For simplicity, using the current time in milliseconds as a placeholder
        return System.currentTimeMillis();
    }

    public boolean delete(Long projectId) {
        Project projectToDelete = getProjectById(projectId);

        // Check if there are tasks with status IN_PROGRESS
        if (projectToDelete.getTasks().stream().anyMatch(task -> task.getStatus() == TaskStatus.IN_PROGRESS)) {
            // Check if it's been more than 6 months since project creation
            if (!canDeleteProject(projectToDelete)) {
                return false;  // Cannot delete project
            }
        }

        // Remove the project from the list
        return projects.remove(projectToDelete);
    }

    public Project get(Long projectId) {
        return getProjectById(projectId);
    }

    public Project update(Long projectId, Project updatedProject) {
        Project existingProject = getProjectById(projectId);

        // Update the existing project with the new data
        existingProject.setTitle(updatedProject.getTitle());
        existingProject.setTasks(updatedProject.getTasks());

        return existingProject;
    }

    private Project getProjectById(Long projectId) {
        return projects.stream()
                .filter(p -> p.getId().equals(projectId))
                .findFirst()
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with ID: " + projectId));
    }

    private boolean canDeleteProject(Project project) {
        LocalDate projectCreationDate = LocalDate.now().minusMonths(6);
        return project.getCreationDate().isBefore(projectCreationDate);
    }
    public List<Project> getProjects() {
        return projects;
    }
}
