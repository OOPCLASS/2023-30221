package Test;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();


        Employee employee1 = new Employee("Georgel", "Sef");
        Employee employee2 = new Employee("Costel", "argat");

        Project projectA = new Project("Proiectul de inceput", new String[] {"Sef","argat"});
        Project projectB = new Project("Proiectul de final", new String[]{"argat"});


        employeeManagementSystem.assignPeopleToProjects(employee1.getId(), projectA.getId());
        employeeManagementSystem.assignPeopleToProjects(employee2.getId(),projectB.getId());


        employee1.displayInfo();
        System.out.println();
        employee2.displayInfo();
        System.out.println();

        projectA.displayInfo();
        System.out.println();
        projectB.displayInfo();
        System.out.println();

        employeeManagementSystem.displayAllProjects();



        }
    }
