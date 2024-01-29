import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ProjectService {
    private Map<Long, Project> projects = new HashMap<>();

    public Map<Long, Project> getProjects() {
        return projects;
    }

    private Long generateUniqueID(){
        Random random = new Random();
        Long randomNumber = random.nextLong(100);

        return randomNumber;
    }

    public Project createProject(String title){

        for (Project exisingProjects : projects.values())
            if (exisingProjects.getTitle().equals(title))
                throw new DuplicateProjectNameException("Another project has the same name");

        Project newProject = new Project(generateUniqueID(), title);
        projects.put(newProject.getId(), newProject);
        return newProject;
    }

    public Project getProject(Long id){
        if (!projects.containsKey(id))
            throw new ProjectNotFoundException("Project "+id+" doesn't exist");
        return projects.get(id);
    }

    public Project updateProject(Long id, Project updatedProject){
        if (!projects.containsKey(id))
            throw new ProjectNotFoundException("Project "+id+" doesn't exist");
        projects.replace(id, updatedProject);
        return updatedProject;
    }


    public boolean deleteProject(Long id) throws ProjectDeleteException{
        if (!projects.containsKey(id))
            throw new ProjectNotFoundException("Project "+id+" doesn't exist");

        Project projectToDelete = projects.get(id);

        if (!canProjectBeDeleted(projectToDelete.getId()))
            return false;

        projects.remove(id);
        return true;

    }
    private boolean canProjectBeDeleted(Long id){
        Project project = projects.get(id);

        if (!projects.containsKey(id))
            throw new ProjectNotFoundException("Project "+id+" doesn't exist");

        long daysSinceCreation = Duration.between(project.getTimeOfCreation(), LocalDateTime.now()).toDays();

        if (daysSinceCreation > 180)
            return true;

        for (Task task : project.getTasks())
            if (task.getStatus().equals(TaskStatus.IN_PROGRESS))
                return true;

        return false;
    }


}
