package EmployeeManager;

import EmployeeManager.Employee;

import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees;
    private ArrayList<Project> projects;

    public EmployeeManagementSystem(ArrayList<Employee> employees, ArrayList<Project> projects) {
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
    }
    public EmployeeManagementSystem() {
    }
    public Employee hirePerson(String name, String position) {
        int i;
        if(this.employees == null)
        {
            i=0;
            this.employees = new ArrayList<>();
            this.projects = new ArrayList<>();
        }
        else {
            i=employees.size();
        }
        Employee employee = new Employee(i + 1, name, position);
        employees.add(employee);
        return employee;
    }

    public Project createProject(String name, String[] requiredPositions) {
        Project project = new Project(projects.size() + 1, name,requiredPositions);
        projects.add(project);
        return project;
    }

    public boolean assignToProject(int employeeId, int projectId) {
        Employee employee = findEmployeeById(employeeId);
        Project project = findProjectById(projectId);

        if (employee != null && project != null) {
            return project.addTeamMember(employee);
        }
        return false;
    }
    public Employee[] searchEmployee(String name, boolean exactMatch) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (exactMatch && employee.getName().equals(name)) {
                result.add(employee);
            } else if (!exactMatch && employee.getName().contains(name)) {
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

    private Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    private Project findProjectById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                return project;
            }
        }
        return null;
    }

}
