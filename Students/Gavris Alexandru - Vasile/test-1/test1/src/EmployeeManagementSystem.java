import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {
    //private Employee[] employees;
    //private Project[] projects;
    private List<Employee> employees = new ArrayList<Employee>();
    private List<Project> projects =new ArrayList<Project>();
    private Employee e;
    private Project p;
    public void hirePerson(String name, String position,int i)
    {
        Employee e=new Employee(name,position,i);
        this.employees.add(e);

    }
    public void createProject(String name,String[] requiredPositions,int i){
            Project p=new Project(name,requiredPositions,i);
            this.projects.add(p);
    }
    public boolean assignToProject(int  employeeID,int projectID){
        for(Employee E:employees)
        {
            if(e.getId()==employeeID)
            {
                for(Project P:projects)
                    if(p.getId()==projectID)
                    {
                        p=P;
                        break;
                    }
                e=E;
                break;
            }
        }

        if(this.p.AddEmployee(e))
            return true;
        return false;
    }
    public void SearchEmployee(String name,Boolean exactMatch){

    }
    public void displayAllProjects()
    {
        for(Project p:projects)
            p.displayInfo();

    }
}
