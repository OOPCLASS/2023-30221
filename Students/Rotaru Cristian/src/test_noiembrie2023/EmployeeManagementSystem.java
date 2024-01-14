package test_noiembrie2023;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {

    private List<Employee> employees;
    private List<Project> projects;

    public EmployeeManagementSystem() {
        employees = new ArrayList<Employee>();
        projects = new ArrayList<Project>();
    }

    public EmployeeManagementSystem(List<Employee> employees, List<Project> projects) {
        this.employees = employees;
        this.projects = projects;
    }

    public Employee hirePerson(String name, String position) {
        Employee newEmployee = new Employee(name, position);
        employees.add(newEmployee);

        return newEmployee;
    }

    public Project createProject(String name, List<String> requiredPositions) {
        Project newProject = new Project();
        newProject.setName(name);
        newProject.setRequiredPositions(requiredPositions);
        projects.add(newProject);

        return newProject;
    }

    public boolean assignToProject(int employeeId, int projectId) {
        for (Employee employee: employees) {
            if (employee.getId() == employeeId) {

                for (Project project: projects) {
                    if(project.getId() == projectId){
                        if(project.addTeamMember(employee) == true)
                            return true;
                        else
                            return false;
                    }
                }

            }
        }
        return false;
    }

    public List<Employee> searchEmployee(String name, boolean exactMatch) {
        List<Employee> searches= new ArrayList<Employee>();

        if(exactMatch == true) {
            for (Employee employee: employees) {
                if(employee.getName().equals(name))
                    searches.add(employee);
            }
        }
        else {
            for (Employee employee: employees) {
                if(employee.getName().toLowerCase().contains(name))
                    searches.add(employee);
            }
        }

        return searches;
    }

    public String toString(){
        String s = "Employees:" + this.employees + "\n";

        s += "Projects:" + this.projects + "\n";
        return s;
    }

    public void displayAllProjects() {
        System.out.println("Projects in management system:");
        for (Project project: projects) {
            project.displayInfo();
        }

    }



}
