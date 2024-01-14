package main;

public class EmployeeManagementSystem {
    private Employee[] employees;
    private Project[] projects;

    public EmployeeManagementSystem()
    {
        this.employees= new Employee[100];
        this.projects=new Project[20];
    }
    public Employee hirePerson(String name,String position)
    {
        Employee employee=new Employee(name,position);
        for(int i=0;i< employees.length;i++)
            if(employees[i]==null)
            {
                employees[i]=employee;
                return employee;
            }
        System.out.println("There are no jobs available");
        return null;

    }

    public Project createProject(String name,String[] requiredPositions)
    {
        Project project = new Project(name, requiredPositions);

        for (int i = 0; i < projects.length; i++) {
            if (projects[i] == null) {
                projects[i] = project;
                return project;
            }
        }

        System.out.println("Maximum number of projects reach");
        return null;
    }

    public boolean assignToProject(int employeeId,int projectId)
    {
        if(employeeId<1 || employees.length<employeeId|| projectId<1 || projects.length<projectId)
        {
            System.out.println("Project id or employeeId is invalid");
            return false;
        }
        Employee employee=employees[employeeId-1];
        Project project=projects[projectId-1];
        return project.addTeamMember(employee);
    }

    public void displayAllProjects()
    {
        for(int i=0;i<projects.length;i++)
        {
            Project project=projects[i];
            project.displayInfo();
        }
    }


}
