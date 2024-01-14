package demo;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees;
    private ArrayList<Project> projects;

    //Constructor
    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>(2);
        this.projects = new ArrayList<>(2);
    }
    // Getters and setters
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

    //Methods
    public Employee hirePerson(String nameEmployee, String position) {
        Employee employee = new Employee(nameEmployee, position);
        employees.add(employee);
        return employee;
    }

    public Project createProject(String nameProject, String[] requiredPositions) {
        // Validate inputs
        if (nameProject == null || nameProject.trim().isEmpty() || requiredPositions == null || requiredPositions.length == 0) {
            System.out.println("Project is not created.");
            return null;
        }
        Project project = new Project(nameProject, requiredPositions);
        projects.add(project);
        System.out.println("Project created: " + project.getNameProject());
        return project;
    }

    public boolean assignToProject(int employeeId, int projectId) {
        Employee employee = getEmployeeById(employeeId);
        Project project = getProjectById(projectId);

        if (employee != null && project != null) {
            return project.addTeamMember(employee);
        }

        return false;
    }

    public Employee[] searchEmployee(String name, boolean exactMatch) {
        ArrayList<Employee> result = new ArrayList<>();

        for (Employee employee : employees) {
            if (exactMatch && employee.getNameEmployee().equals(name)) {
                result.add(employee);
            } else if (!exactMatch && employee.getNameEmployee().contains(name)) {
                result.add(employee);
            }
        }

        return result.toArray(new Employee[0]);
    }

    public void displayAllProjects() {
        for (Project project : projects) {
            project.displayInfo();
        }
    }

    private Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getIdEmployee() == id) {
                return employee;
            }
        }
        return null;
    }

    private Project getProjectById(int id) {
        for (Project project : projects) {
            if (project.getIdProject() == id) {
                return project;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //Here I create new objets
        // The main instance EmployeeManagementSystem
        EmployeeManagementSystem e_m_system = new EmployeeManagementSystem();
            for (int i = 0; i < 20; i++) {
                e_m_system.hirePerson("Employee Number: " + (i + 1), "Position" + (i % 3 + 1));
            }
            for (int i = 0; i < 3; i++) {
                String[] positions = {"Pos1", "Pos2", "Pos3"};
                e_m_system.createProject("Project" + (i + 1), positions);
            }
            e_m_system.displayAllProjects();

    }
}