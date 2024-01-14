package EmployeeManager;

import EmployeeManager.Employee;
import EmployeeManager.EmployeeManagementSystem;

public class Main {
    public static void main(String[] args) {

        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Employee emp1 = ems.hirePerson("Calin Alexandru", "EmployeeManager.Project Manager");
        Employee emp2 = ems.hirePerson("Robert Nicolae", "Developer");

        Project project1 = ems.createProject("EmployeeManager.Project A", new String[]{"EmployeeManager.Project Manager", "Developer"});
        Project project2 = ems.createProject("EmployeeManager.Project B", new String[]{"Developer", "Tester"});

        ems.assignToProject(emp1.getId(), project1.getId());
        ems.assignToProject(emp2.getId(), project1.getId());
        ems.assignToProject(emp2.getId(), project2.getId());

        ems.displayAllProjects();

        Employee[] searchResult = ems.searchEmployee("Calin Alexandru", true);
        System.out.println("Search Result:");
        for (Employee employee : searchResult) {
            employee.displayInfo();
        }
    }
}