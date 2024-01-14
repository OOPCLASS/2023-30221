public class EmployeeManagementSystem {
    private int employeesSize = 2;
    private int numberOfEmployees = 0;

    private Employee[] employees = new Employee[employeesSize];

    private int projectsSize = 2;
    private int numberOfProjects = 0;

    private Project[] projects = new Project[projectsSize];

    private static EmployeeManagementSystem employeeManagementSystem;

    private EmployeeManagementSystem() {
        
    }

    public static EmployeeManagementSystem getInstance() {
        if (employeeManagementSystem == null) {
            employeeManagementSystem = new EmployeeManagementSystem();
        }

        return employeeManagementSystem;
    }

    public Employee hirePerson(String name, String position) {
        Employee employee = new Employee(name, position);

        if (numberOfEmployees < employeesSize) {
            employees[numberOfEmployees++] = employee;
        }
        else {
            employees = increaseEmployeesSize(employees, employeesSize);
            employeesSize *= 2;
            employees[numberOfEmployees++] = employee;
        }

        return employee;
    }

    public Project createProject(String name, String[] requiredPositions) {
        Project project = new Project(name, requiredPositions);

        if (numberOfProjects < projectsSize) {
            projects[numberOfProjects++] = project;
        }
        else {
            projects = increaseProjectsSize(projects, projectsSize);
            projectsSize *= 2;
            projects[numberOfProjects++] = project;
        }

        return project;
    }

    public boolean assignToProject(int employeeId, int projectId) {
        Employee employee = getEmployeeById(employeeId);
        if (employee == null) {
            System.out.println("Employee with ID " + employeeId + " not found!");
            return false;
        }

        Project project = getProjectById(projectId);
        if (project == null) {
            System.out.println("Project with ID " + projectId + " not found!");
            return false;
        }

        return project.addTeamMember(employee);
    }

    public Employee[] searchEmployee(String name, boolean exactMatch) {
        Employee[] searchedEmployees = new Employee[numberOfEmployees];

        if (exactMatch) {
            int k = 0;
            for (Employee employee : employees) {
                if (employee != null && employee.getName() == name) {
                    searchedEmployees[k++] = employee;
                }
            }
        }
        else {
            int k = 0;
            for (Employee employee : searchedEmployees) {
                if (employee != null && employee.getName().toLowerCase().contains(name.toLowerCase())) {
                    searchedEmployees[k++] = employee;
                }
            }
        }

        return searchedEmployees;
    }

    public void displayAllProjects() {
        System.out.println("All projects' info:");
        for (Project project : projects) {
            if (project != null) {
                project.displayInfo();
            }
        }
    }

    private Employee getEmployeeById(int id) {
        for (int i = 0; i < numberOfEmployees; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }

        return null;
    }

    private Project getProjectById(int id) {
        for (int i = 0; i < numberOfProjects; i++) {
            if (projects[i].getId() == id) {
                return projects[i];
            }
        }

        return null;
    }

    private Employee[] increaseEmployeesSize(Employee[] employees, int currentSize) {
        Employee[] newEmployees = new Employee[currentSize * 2];

        for (int i = 0; i < currentSize; i++) {
            newEmployees[i] = employees[i];
        }

        return newEmployees;
    }

    private Project[] increaseProjectsSize(Project[] projects, int currentSize) {
        Project[] newProjects = new Project[currentSize * 2];

        for (int i = 0; i < currentSize; i++) {
            newProjects[i] = projects[i];
        }

        return newProjects;
    }
}
