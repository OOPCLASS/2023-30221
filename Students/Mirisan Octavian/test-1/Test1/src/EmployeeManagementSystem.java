import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem
{
    List<Employee> employees;
    List<Project> projects;

    private int idEmployee = 1;
    private int idProject =1;

    public EmployeeManagementSystem()
    {
        employees = new ArrayList<>();
        projects = new ArrayList<>();
    }


    public void hirePerson(String name,String position)
    {
        Employee newEmployee = new Employee(idEmployee,name,position);

        employees.add(newEmployee);
        idEmployee++;

    }

    public void createProject(String name,String[] requiredPositions)
    {
        Project newProject= new Project(idProject,name,requiredPositions);

        projects.add(newProject);
        idProject++;
    }

    public boolean assignToProject(int employeeId, int projectId)
    {
        Employee employee = findEmployeeById(employeeId);
        Project project= findProjectById(projectId);

       int ok1=0;
       int ok2=0;

       for(int i=0;i<employees.size();i++)
       {
           if(employeeId==employees.get(i).id)
               ok1=1;
       }
       for(int i=0;i<projects.size();i++)
       {
           if(employeeId==projects.get(i).id)
               ok2=1;
       }

       if(ok1==1 && ok2==1)
       {
           return project.addTeamMember(employee);
       }
       else
       {
           System.out.println("Project or/and employee not found!");
           return false;
       }

    }

    public Employee[] searchEmployee(String name,boolean exactMatch)
    {
        Employee[] result = new Employee[employees.size()];
        int index=0;

        if(exactMatch == true)
        {
            for (int i = 0; i < employees.size(); i++)
            {

                if (employees.get(i).name.equals(name))
                {
                    result[index].position = employees.get(i).position;
                    result[index].name = employees.get(i).name;
                    result[index].id = employees.get(i).id;
                }
            }
        }
        return result;

    }

    public void displayAllProjects()
    {
        System.out.println("All projects:");

        for(int i=0;i<projects.size();i++)
        {
            projects.get(i).displayInfo();
        }
    }


    private Employee findEmployeeById(int id)
    {
        for(int i=0;i<employees.size();i++)
        {
            if(employees.get(i).id==id)
                return employees.get(i);
        }

        return null;

    }

    private Project findProjectById(int id)
    {
        for(int i=0;i<projects.size();i++)
        {
            if(projects.get(i).id==id)
                return projects.get(i);
        }

        return null;

    }




}
