import java.util.ArrayList;
import java.util.Arrays;
public class EmployeeManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Project> projects = new ArrayList<>();

    public Employee hirePerson(String name, String position){
        int idEmployee = employees.size();
        Employee newEmployee = new Employee(idEmployee, name, position);
        employees.add(newEmployee);
        return newEmployee;
    }

    public Project createProject(String name, String[] requiredPositions){
        int idProject = projects.size();
        Project newProject = new Project(idProject,name,requiredPositions);
        projects.add(newProject);
        return newProject;
    }

    public boolean assignToProject(int employeeId, int projectId){
        Employee employee = findEmployeeById(employeeId);
        Project project = findProjectById(projectId);
        if (employee == null || project == null) {
            System.out.println("Employee or project not found!");
            return false;
        }
        return project.addTeamMember(employee);
    }

    private Employee findEmployeeById(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    private Project findProjectById(int projectId) {
        for (Project project : projects) {
            if (project.getId() == projectId) {
                return project;
            }
        }
        return null;
    }

    public Employee[] searchEmployee(String name, boolean exactMatch) {
        ArrayList<Employee> matchingEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (exactMatch && employee.getName().equals(name)) {
                matchingEmployees.add(employee);
            } else if (!exactMatch && employee.getName().contains(name)) {
                matchingEmployees.add(employee);
            }
        }
        return matchingEmployees.toArray(new Employee[matchingEmployees.size()]);
    }

    public void displayAllProjects(){
        for(Project project: projects){
            project.displayInfo();
        }
    }


}
