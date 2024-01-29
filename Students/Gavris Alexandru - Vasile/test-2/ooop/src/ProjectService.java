import org.w3c.dom.events.EventException;

import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private List<Project> projects=new ArrayList<Project>();
    private int idd=1;
    public void create(String title,List<Task> tasks)
    {
        int ok=1;
        Project tempProject=new Project();
        tempProject.setID(idd);
        idd++;
        for(Project p:this.projects)
        {
            if(p.getTitle().equals(title))
            {
                System.out.println("DuplicateProjectNameException");
                ok=0;
            }
        }
        if(ok==1)
            tempProject.setTitle(title);
        tempProject.setTasks(tasks);

        this.projects.add(tempProject);
    }
    public Project get(int id)
    {

        for(Project p:this.projects)
        {
            if(p.getID()==id)
            {
                return p;

            }
        }
        System.out.println("ProjectNotFoundException");
        return null;


    }
    public Project update(int id,Project project)
    {
        Project proj=this.get(id);
        proj.setTitle(project.getTitle());
        proj.setTasks(project.getTasks());
        return proj;
    }
    public boolean delete (Project project)
    {
       Project p=this.get(project.getID());
       if(p!=null)
       {
           List<Task> listTask=project.getTasks();
           if(project.getMonths()<6)
               for(Task t:listTask)
                    if(t.getStatus().equals(Task.TaskStatus.IN_PROGRESS))
                        return false;


           this.projects.remove(p);
           return true;
       }
       return false;
    }

}
