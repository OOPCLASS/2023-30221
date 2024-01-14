import java.util.ArrayList;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees;
    private  ArrayList<Project> projects;

    public EmployeeManagementSystem(){
        this.employees= new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public Employee hirePerson(String name, String position){
        Employee employee = new Employee(name,position);
        employees.add(employee);
        return employee;
    }

    public Project createProject(String name, String[] requiredPositions){
        Project project = new Project(name,requiredPositions);
        projects.add(project);
        return project;
    }

    public Employee findEmployeeById(int id){
        for(Employee i: employees){
            if (i.getId() == id)
                return i;
        }
        return null;
    }

    public Project findProjectById(int id){
        for(Project i: projects){
            if (i.getId() == id)
                return i;
        }
        return null;
    }

    public boolean assignToProject(int employeeId, int projectId){
        Employee emp=findEmployeeById(employeeId);
        Project pro=findProjectById(projectId);
        if(emp==null || pro==null) {
            System.out.println("Proiectul sau angajatul nu exista!");
            return false;
        }
        else {
            return pro.addTeamMember(emp);
        }
    }

    public ArrayList<Employee> searchEmployee(String name, boolean exactMatch){
        ArrayList<Employee> res =new ArrayList<>();
        for (Employee emp : employees)
        {
            if(exactMatch){
                if (emp.getName().equals(name)){
                    res.add(emp);
                }
            }
            else
            {
                if(emp.getName().contains(name))
                    res.add(emp);
            }
        }
        return res;
    }

    public void displayAllProjects(){
        System.out.println("All Projests\n");
        for(Project i : projects){
            i.displayInfo();
        }
    }
}
