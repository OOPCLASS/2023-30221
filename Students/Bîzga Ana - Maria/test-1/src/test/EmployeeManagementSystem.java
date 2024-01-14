package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeManagementSystem {
    private List<Employee> employees;
    private List<Project> projects;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public Employee hirePerson(String name, String position) {
        Employee newEmployee = new Employee(employees.size() + 1, name, position);
        employees.add(newEmployee);
        return newEmployee;
    }

    public Project createProject(String name, List<String> requiredPosition) {
        Project newProject = new Project(projects.size() + 1, name, requiredPosition);
        projects.add(newProject);
        return newProject;
    }

    public boolean assignToProject(int employeeId, int projectId) {
        boolean existEmployee = false;
        boolean existProject = false;
        for (Employee employee : employees)
            if (employee.getId() == employeeId) {
                existEmployee = true;
                break;
            }
        for (Project project : projects)
            if (project.getId() == projectId) {
                existProject = true;
                break;
            }
        if (!existEmployee) {
            System.out.println("Employee with id: " + employeeId + " does not exist");
            return false;
        }
        if (!existProject) {
            System.out.println("Project with id: " + projectId + " does not exist");
            return false;
        }
        return projects.get(projectId - 1).addTeamMember(employees.get(employeeId - 1));
    }

    public List<Employee> searchEmployee(String name, boolean exactMatch) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (exactMatch) {
                if (Objects.equals(employee.getName(), name))
                    foundEmployees.add(employee);
            } else {
                if (employee.getName().toLowerCase().contains(name.toLowerCase()))
                    foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }

    public void displayAllProject() {
        for (Project project : projects)
            project.displayInfo();
    }
}
