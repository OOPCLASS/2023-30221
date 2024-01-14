package test_noiembrie2023;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Project projects[] = new Project[3];
        for (int i = 0; i < projects.length; i++) {
            projects[i] = new Project();
        }

        Employee employees[] = new Employee[20];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee();
        }
        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem(Arrays.stream(employees).toList(),
                                                                            Arrays.stream(projects).toList());

        System.out.println("Projects:");
        for (int i = 0; i < projects.length; i++) {
            projects[i].displayInfo();
        }
        System.out.println("Employees:");
        for (int i = 0; i < employees.length; i++) {
            employees[i].displayInfo();
        }
        
        employeeManagementSystem.displayAllProjects();
    }
}