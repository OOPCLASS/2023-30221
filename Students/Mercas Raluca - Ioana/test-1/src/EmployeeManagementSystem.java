import java.util.ArrayList;

public class EmployeeManagementSystem {
    public ArrayList<Employee> employees;
    public ArrayList<Project> projects;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        projects = new ArrayList<>();
    }

    public Employee hirePerson(String name, String position) {
        Employee employee = new Employee(employees.size(), name, position);
        employees.add(employee);
        return employee;
    }

    public Project createProject(String name, ArrayList<String> requiredPosition) {
        Project project = new Project(projects.size(), name, requiredPosition);
        projects.add(project);
        return project;
    }

    public boolean assignToProject(int employeeId, int projectId) {
        int found = 0;
        for(Employee employee: employees) {
            if(employee.getId() == employeeId) {
                found = 1;
                for(Project project: projects) {
                    if(project.getId() == projectId) {
                        project.addTeamMember(employee);
                        return true;
                    }
                }
                System.out.println("Error: Project not found!");
            }
        }
        if(found == 0) {
            System.out.println("Error: Employee not found!");
        }
        return false;
    }

    public ArrayList<Employee> searchEmployee(String name, boolean exactMatch) {
        exactMatch = false;
        ArrayList<Employee> myEmployees = new ArrayList<>();
        for(Employee employee: employees) {
            if(employee.getName().equals(name)) {
                myEmployees.add(employee);
                exactMatch = true;
            }
        }
        if(!exactMatch) {
            System.out.println("No employee was found.");
        }
        return myEmployees;
    }

    public void displayAllProjects() {
        for(Project project: projects) {
            project.displayInfo();
        }
    }



}
