import java.util.Arrays;

class EmployeeManagementSystem {
    private Employee[] employees;
    private Project[] projects;

    public EmployeeManagementSystem() {
        this.employees = new Employee[2];
        this.projects = new Project[2];
    }

    public Employee hirePerson(String name, String position) {
        Employee employee = new Employee(name, position);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return employee;
            }
        }

        employees = Arrays.copyOf(employees, employees.length * 2);
        employees[employees.length / 2] = employee;
        return employee;
    }

    public Project createProject(String name, String[] requiredPositions) {
        Project project = new Project(name, requiredPositions);
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] == null) {
                projects[i] = project;
                return project;
            }
        }

        projects = Arrays.copyOf(projects, projects.length * 2);
        projects[projects.length / 2] = project;
        return project;
    }

    public boolean assignToProject(int employeeId, int projectId) {
        // Assume employeeId and projectId are valid indices in the arrays
        Employee employee = employees[employeeId];
        Project project = projects[projectId];
        return project.addTeamMember(employee);
    }

    public Employee[] searchEmployee(String name, boolean exactMatch) {
        // Implement search logic here
        // For simplicity, returning all employees for now
        return Arrays.copyOf(employees, employees.length);
    }

    public void displayAllProjects() {

        System.out.println("_____________________________\n");
        for (Project project : projects) {
            if (project != null) {
                project.displayInfo();
                System.out.println("_____________________________\n");
            }
        }
    }
}
