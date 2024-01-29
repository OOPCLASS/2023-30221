import java.util.ArrayList;
import java.util.List;

public class ProjectService
{

    private List<Project> projects;


    public ProjectService()
    {
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects()
    {
        return projects;
    }

    public void setProjects(List<Project> projects)
    {
        this.projects = projects;
    }





    public Project create() throws Exceptions.DuplicateProjectNameException
    {
        long id= generateId();

        Project project = new Project(id,"Title",new ArrayList<>());



        for(Project iterator: projects)
        {
            if(iterator.getTitle().equals(project.getTitle()))
            {
                throw new Exceptions.DuplicateProjectNameException("This project's title already exists");
            }
        }


        projects.add(project);

        return project;
    }




    public boolean delete(Project project) throws Exceptions.ProjectNotFoundException
    {
        if (!projects.contains(project)) {
            throw new Exceptions.ProjectNotFoundException("This project does not exist.");
        }

        // Verificăm dacă există sarcini cu statusul IN_PROGRESS
        if (tasksInProgressExist(project)) {
            return false;
        }

        projects.remove(project);
        return true;
    }

    private boolean tasksInProgressExist(Project project) {
        for (Task task : project.getTasks()) {
            if (task.getStatus() == TaskStatus.IN_PROGRESS) {
                return true;
            }
        }
        return false;
    }


    public Project get(String id) throws Exceptions.ProjectNotFoundException
    {
        long projectID = Long.parseLong(id);

        for(Project project: projects)
        {
            if(project.getId().equals(projectID))
            {
                return project;
            }
        }

        throw new Exceptions.ProjectNotFoundException("Project with ID " + id + " does not exist");
    }



    public Project update(String id, Project project) throws Exceptions.ProjectNotFoundException
    {
        int projectID = Integer.parseInt(id);

        for(Project iterator: projects)
        {
            if(projectID == iterator.getId())
            {
                projects.set(projectID,project);
                return project;
            }
        }


        throw new Exceptions.ProjectNotFoundException("Project with id " + id + " does not exist");
    }




    private Long generateId()
    {
        return Long.valueOf(System.currentTimeMillis());
    }

}
