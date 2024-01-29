import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private static Long nrProjects = 0L;
    private List<Project> projects;

    public ProjectService(){
        projects = new ArrayList<>();
    }

    public Project create(String projectName) throws  DuplicateProjectNameException{
        for(Project project: projects){
            if(project.getTitle().equals(projectName)){
                throw new DuplicateProjectNameException("Project with the same name already exists!");
            }
        }
        Long projectId = 10 * (nrProjects++);
        Project newProject = new Project(projectId);
        newProject.setTitle(projectName);
        newProject.setCreationDate(LocalDateTime.now());
        projects.add(newProject);
        return newProject;
    }

    public boolean delete(Project project) throws ProjectNotFoundException{
        if(!projects.contains(project)){
            throw new ProjectNotFoundException("Project not found!");
        }

        if(hasTasksInProgress(project) && !isSixMonthsPassed(project.getCreationDate())){
            return false;
        }
        projects.remove(project);
        return true;
    }

    public boolean hasTasksInProgress(Project project) {
        for (Task task : project.getTasks()) {
            if (task.getStatus() == TaskStatus.IN_PROGRESS) {
                return true;
            }
        }
        return false;
    }

    public boolean isSixMonthsPassed(LocalDateTime creationDate) {
        LocalDateTime sixMonthsAgo = LocalDateTime.now().minusMonths(6);
        return creationDate.isBefore(sixMonthsAgo);
    }

    public Project get(Long id) throws ProjectNotFoundException{
        for(Project project: projects){
            if(project.getId().equals(id)){
                return project;
            }
        }
        throw new ProjectNotFoundException("Project not found!");
    }

    public Project update(Long id, Project project) throws ProjectNotFoundException{
        for(int i = 0; i < projects.size(); i++){
            Project currentProject = projects.get(i);
            if(currentProject.getId().equals(id)){
                projects.set(i, project);
                return project;
            }
        }
        throw new ProjectNotFoundException("Project not found!");
    }

    public Project getProjectByTask(Task task) {
        for (Project project : projects) {
            if (project.getTasks().contains(task)) {
                return project;
            }
        }
        throw new ProjectNotFoundException("Project not found for the given task.");
    }


}
