import java.util.List;

public class ProjectService {
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Project create(String title) throws DuplicateProjectNameException{

       for  (Project project : projects) {
           if (project.getTitle().compareTo(title) != 0) {
               throw new DuplicateProjectNameException();
           }
       }

       Project project = new Project(title);
       projects.add(project);

       return project;
    }

    public boolean delete(Project project) throws ProjectNotFoundException{

        Project existingProject = get(project.getId());
        if (existingProject != null) {
            List<Task> tasks = project.getTasks();
            for (Task task : tasks) {
                if (task.getStatus() == TaskStatus.IN_PROGRESS) {
                    return false;
                }
            }
            return projects.remove(project);
        }
        return false;
    }

    public Project get(Long id) throws ProjectNotFoundException{
        for (Project project : projects) {
            if (project.getId().equals(id)) {
                return project;
            }
        }

        throw new ProjectNotFoundException();
    }

    public Project update(Long id, Project project) throws ProjectNotFoundException{
        Project existingProject = get(id);
        existingProject.setTitle(project.getTitle());
        return existingProject;
    }
}
