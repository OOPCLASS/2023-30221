import java.util.ArrayList;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Project> projects = new ArrayList<Project>();

    public Employee hirePerson(String name, String position) {
        Employee employee = new Employee();

        employee.setName(name);
        employee.setPosition(position);
        employees.add(employee);

        return employee;
    }

    public Project createProject(ArrayList<String> name, ArrayList<String> requiredPositions) {
        Project project = new Project();

        if (!name.isEmpty()) {
            project.setName(name.get(0));
            name.remove(0);
            project.requiredPositions.addAll(requiredPositions);
            return project;
        }

        System.out.println("Can't create project!");
        return null;
    }

    public Employee searchEmployeeById(int employeeId) {
        for (Employee employee : this.employees) {
            if (employee.getId() == employeeId)
                return employee;
        }

        System.out.println("This employee doesn't exist!");
        return null;
    }

    public Project searchProjectById(int projectId) {
        for (Project project : this.projects) {
            if (project.getId() == projectId)
                return project;
        }

        System.out.println("This project doesn't exist!");
        return null;
    }

    public boolean assignToProject(int employeeId, int projectId) {
        Employee employee = searchEmployeeById(employeeId);
        Project project = searchProjectById(projectId);

        if (employee != null && project != null) {
            project.addTeamMember(employee);
            return true;
        }

        return false;
    }

    public void displayAllProjects() {
        for (Project project : this.projects)
            project.displayInfo();
    }

    public ArrayList<Employee> searchEmployee(String name, boolean exactMatch) {
        ArrayList<Employee> found = new ArrayList<Employee>();

        if (exactMatch) {
            for (Employee employee : this.employees) {
                if (employee.getName().equals(name))
                    found.add(employee);
            }
        } else {
            for (Employee employee : this.employees) {
                if (employee.getName().contains(name))
                    found.add(employee);
            }
        }

        return found;
    }
}
