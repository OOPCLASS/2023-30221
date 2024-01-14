package test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {
    private List<Employee> employees;
    private List<Project> projects;
    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        projects = new ArrayList<>();;
    }
    public Employee hirePerson (String name, Position position){
        Employee employee =  new Employee();
        employee.setName(name);
        employee.setPosition(position);
        employees.add(employee);
        return employee;
    }

    public Project createProject (String name, List<Position> requiredPositions){
        Project project = new Project();
        project.setName(name);
        project.setRequiredPositions(requiredPositions);
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
    public boolean assignToProject (int employeeID, int projectID){
        Employee employee = findEmployeeByID(employeeID);
        Project project = findProjectByID(projectID);
        if (employee != null && project != null) {
            project.addTeamMember(employee);
            return true;
        }
        return false;
    }
    public List<Employee> searchEmployee(String name, boolean exactMatch) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (exactMatch) {
                if (employee.getName().matches(name)) {
                    result.add(employee);
                }
            } else if (employee.getName().contains(name)) {
                    result.add(employee);
                }
        }
        return result;
    }
    public void displayAllProjects() {
        for (Project project : projects) {
            project.displayInfo();
        }
    }
}
