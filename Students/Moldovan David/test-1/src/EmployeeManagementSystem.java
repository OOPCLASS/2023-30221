import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeManagementSystem {
    private List<Employee> employees;
    private List<Project> projects;

    public EmployeeManagementSystem(){
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();

    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Employee hirePerson(String name, String position){
        Employee newEmployee = new Employee(name,position);
        employees.add(newEmployee);
        return newEmployee;

    }

    public Project createProject(String name, String[] requiredPosition){
        Project newProject = new Project(name,requiredPosition);
        projects.add(newProject);
        return newProject;
    }

    public boolean assignToProject(int employeeId, int projectId){
        Employee employee = findEmployeeById(employeeId);
        Project project = findProjectById(projectId);
        if(employee != null && project != null){
            return project.addTeamMember(employee);
        }
        return false;
    }

    public Employee[] searchEmployee(String name, boolean match){
        List<Employee> gasit = new ArrayList<>();
        for(Employee employee : employees){
            if(match) {
                if (employee.getName().equals(name)) {
                    gasit.add(employee);
                }
            }else {
                    if(employee.getName().contains(name)){
                        gasit.add(employee);
                    }
                }

        }
        return gasit.toArray(new Employee[0]);

    }

    public void displayAllProjects(){
        for (Project project : projects){
            project.displayInfo();
            System.out.println("\n");
        }
    }

    private Employee findEmployeeById(int employeeId){
        for (Employee employee: employees){
            if(employee.getId() == employeeId){
                return employee;
            }
        }
        return null;

    }

    private Project findProjectById(int projectID){
        for (Project project: projects){
            if(project.getId() == projectID){
                return project;
            }
        }
        return null;

    }
}
