package test;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<String> requiredPos1 = new ArrayList<>();
        requiredPos1.add("Project Manager");
        requiredPos1.add("Developer");
        requiredPos1.add("Developer");

        List<String> requiredPos2 = new ArrayList<>();
        requiredPos2.add("Project Manager");
        requiredPos2.add("Project Manager");
        requiredPos2.add("Developer");
        requiredPos2.add("Developer");

        EmployeeManagementSystem managementSystem = new EmployeeManagementSystem();

        //hire 20 persons
        managementSystem.hirePerson("Ana", "Project Manager"); //id = 1
        managementSystem.hirePerson("Alexandra", "Project Manager"); //id = 2
        managementSystem.hirePerson("Monica", "Project Manager"); //id = 3
        managementSystem.hirePerson("Raluca", "Project Manager"); //id = 4
        managementSystem.hirePerson("Clau", "Developer"); //id = 5
        managementSystem.hirePerson("Andreea", "Developer"); //id = 6
        managementSystem.hirePerson("Anais", "Developer"); //id = 7
        managementSystem.hirePerson("Ramona", "Developer"); //id = 8
        managementSystem.hirePerson("Alexandru", "Developer"); //id = 9
        managementSystem.hirePerson("Ema", "Developer"); //id = 10
        managementSystem.hirePerson("Oana", "Developer"); //id = 11
        managementSystem.hirePerson("Andra", "Project Manager"); //id = 12
        managementSystem.hirePerson("Andrei", "Developer"); //id = 13
        managementSystem.hirePerson("Ana", "Developer"); //id = 14
        managementSystem.hirePerson("Ioana", "Developer"); //id = 15
        managementSystem.hirePerson("Maria", "Developer"); //id = 16
        managementSystem.hirePerson("Marius", "Developer"); //id = 17
        managementSystem.hirePerson("Bogdan", "Project Manager"); //id = 18
        managementSystem.hirePerson("Sebastian", "Developer"); //id = 19
        managementSystem.hirePerson("Gabriel", "Developer"); //id = 20

        //create 3 project
        managementSystem.createProject("project1", requiredPos1); // id 1
        managementSystem.createProject("project2", requiredPos1); // id 2
        managementSystem.createProject("project3", requiredPos2); // id 3
        //assign employees to projects
        managementSystem.assignToProject(1, 1);
        managementSystem.assignToProject(2, 1);
        managementSystem.assignToProject(6, 1);
        managementSystem.assignToProject(7, 1);

        managementSystem.assignToProject(20, 2);
        managementSystem.assignToProject(1, 2);
        managementSystem.assignToProject(2, 2);
        managementSystem.assignToProject(6, 2);
        managementSystem.assignToProject(7, 2);

        managementSystem.assignToProject(20, 3);
        managementSystem.assignToProject(1, 3);
        managementSystem.assignToProject(2, 3);
        managementSystem.assignToProject(6, 3);
        managementSystem.assignToProject(7, 3);
        managementSystem.assignToProject(22, 3);

        managementSystem.assignToProject(1, 4);

        managementSystem.displayAllProject();

        List<Employee> employeesFound;
        //employeesFound = managementSystem.searchEmployee("Ana", true);
        employeesFound = managementSystem.searchEmployee("Ana", false);
        for (Employee employee : employeesFound) {
            employee.displayInfo();
        }
    }
}