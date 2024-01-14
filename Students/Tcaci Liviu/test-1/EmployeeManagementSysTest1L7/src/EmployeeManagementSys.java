import java.util.ArrayList;
import java.util.List;

class EmployeeManagementSystem {
    private List<Employee> employees;
    private List<Project> projects;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    //NewEmployeeHire
    public Employee hirePerson(String name, String position) {
        int newEmployeeId = employees.size() + 1;
        Employee newEmployee = new Employee(newEmployeeId, name, position);
        employees.add(newEmployee);
        return newEmployee;
    }

    //NewProjectCreate
    public Project createProject(String name, String[] requiredPositions) {
        int newProjectId = projects.size() + 1;
        Project newProject = new Project(newProjectId, name, requiredPositions);
        projects.add(newProject);
        return newProject;
    }

    public boolean assignToProject(int employeeId, int projectId) {
        Employee employee = getEmployeeById(employeeId);
        Project project = getProjectById(projectId);

        if (employee != null && project != null) {
            return project.addTeamMember(employee);
        }

        return false;
    }

    // Search through the employees array and return all instances matching the searched name
    public List<Employee> searchEmployee(String name, boolean exactMatch) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (exactMatch && employee.getName().equalsIgnoreCase(name)) {
                result.add(employee);
            } else if (!exactMatch && employee.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(employee);
            }
        }
        return result;
    }

    //AllProjectDisplay
    public void displayAllProjects() {
        for (Project project : projects) {
            project.displayInfo();
        }
    }

    //getters and setters
    private Employee getEmployeeById(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    private Project getProjectById(int projectId) {
        for (Project project : projects) {
            if (project.getId() == projectId) {
                return project;
            }
        }
        return null;
    }
}
