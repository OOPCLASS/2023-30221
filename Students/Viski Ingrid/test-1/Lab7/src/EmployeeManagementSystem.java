import java.util.ArrayList;
public class EmployeeManagementSystem {
    private ArrayList<Employee> employees;
    private ArrayList<Project> projects;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    private int generateEmployeeID() {
        return employees.size() + 1;
    }

    public Employee hirePerson(String name, String position) {
        Employee employee = new Employee();
        employee.setId(generateEmployeeID());
        employee.setName(name);
        employee.setPosition(Employee.Position.valueOf(position.toUpperCase()));
        employees.add(employee);
        return employee;
    }

    private int generatePositionID() {
        return projects.size() + 1;
    }

    public Project createProject(String name, String[] requiredPosition) {
        Project project = new Project();
        project.setId(generatePositionID());
        project.setName(name);
        project.setRequiredPosition(requiredPosition);
        projects.add(project);
        return project;
    }

    private Employee findEmployeeByID(int employeeID) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeID) {
                return employee;
            }
        }
        return null;
    }

    private Project findProjectByID(int projectID) {
        for (Project project : projects) {
            if (project.getId() == projectID) {
                return project;
            }
        }
        return null;
    }

    public boolean assignToProject(int employeeID, int projectID) {
        Employee employee = findEmployeeByID(employeeID);
        Project project = findProjectByID(projectID);
        if (employee == null || project == null) {
            System.out.println("Employee or project not found");
            return false;
        }
        return project.addTeamMember(employee);
    }

    public Employee[] searchEmployee(String name, boolean exactMatch) {
        ArrayList<Employee> searchResult = new ArrayList<>();
        for (Employee employee : employees) {
            if (exactMatch) {
                if (employee.getName().equalsIgnoreCase(name)) {
                    searchResult.add(employee);
                }
            }
        }
        return searchResult.toArray(new Employee[0]);
    }

    public void displayAllProjects() {
        System.out.println("All projects: ");
        for (Project project : this.projects) {
            project.displayInfo();
        }
    }
}
