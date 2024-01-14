package test;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem managementSystem = new EmployeeManagementSystem();

        Project project1 = new Project("Project 1");
        Project project2 = new Project("Project 2");
        Project project3 = new Project("Project 3");

        Employee employee1 = managementSystem.hirePerson("Ana Banana", Position.PROJECT_MANAGER);
        Employee employee2 = managementSystem.hirePerson("Jane Mark", Position.DEVELOPER);
        Employee employee3 = managementSystem.hirePerson("Alice Canal", Position.TESTER);
        Employee employee4 = managementSystem.hirePerson("John Cena", Position.DESIGNER);
        Employee employee5 = managementSystem.hirePerson("Bob Anderson", Position.PROJECT_MANAGER);
        Employee employee6 = managementSystem.hirePerson("David Andre", Position.DEVELOPER);
        Employee employee7 = managementSystem.hirePerson("Ion Gavrea", Position.TESTER);
        Employee employee8 = managementSystem.hirePerson("Ana Pom", Position.DESIGNER);
        Employee employee9 = managementSystem.hirePerson("Daniel Mircea", Position.PROJECT_MANAGER);
        Employee employee10 = managementSystem.hirePerson("Mihai Eminescu", Position.DEVELOPER);
        Employee employee11 = managementSystem.hirePerson("Lucian Blaga", Position.TESTER);
        Employee employee12 = managementSystem.hirePerson("Ion Pamant", Position.DESIGNER);
        Employee employee13 = managementSystem.hirePerson("Eliade Mircea", Position.PROJECT_MANAGER);
        Employee employee14 = managementSystem.hirePerson("Taylor Swift", Position.DEVELOPER);
        Employee employee15 = managementSystem.hirePerson("Mihai Alb", Position.TESTER);
        Employee employee16 = managementSystem.hirePerson("Dua Lipa", Position.DESIGNER);
        Employee employee17 = managementSystem.hirePerson("Min Yoongi", Position.PROJECT_MANAGER);
        Employee employee18 = managementSystem.hirePerson("Ed Sheeran", Position.DEVELOPER);
        Employee employee19 = managementSystem.hirePerson("Joe Biden", Position.TESTER);
        Employee employee20 = managementSystem.hirePerson("Traian Basescu", Position.DESIGNER);

        List<Employee> searchResult = managementSystem.searchEmployee("Ana", false);
        System.out.println("Search result: ");
        for (Employee result : searchResult) {
            System.out.println(result.getName());
        }
        List<Employee> searchResult2 = managementSystem.searchEmployee("Dua Lipa", true);
        System.out.println("Search result: ");
        for (Employee result : searchResult2) {
            System.out.println(result.getName());
        }
    }
}