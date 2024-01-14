import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();

        Project project1 = employeeManagementSystem.createProject("Project 1", new String[]{"Project_Manager", "Developer", "Developer", "Tester"});
        Project project2 = employeeManagementSystem.createProject("Project 2", new String[]{"Project_Manager", "Developer"});
        Project project3 = employeeManagementSystem.createProject("Project 3", new String[]{"Project_Manager", "Developer", "Tester"});

        Employee employee1 = employeeManagementSystem.hirePerson("Person 1", "Tester");
        Employee employee2 = employeeManagementSystem.hirePerson("Person 2", "Developer");
        Employee employee3 = employeeManagementSystem.hirePerson("Person 3", "Tester");
        Employee employee4 = employeeManagementSystem.hirePerson("Person 4", "Project_Manager");
        Employee employee5 = employeeManagementSystem.hirePerson("Person 5", "Developer");
        Employee employee6 = employeeManagementSystem.hirePerson("Person 6", "Project_Manager");
        Employee employee7 = employeeManagementSystem.hirePerson("Person 7", "Project_Manager");
        Employee employee8 = employeeManagementSystem.hirePerson("Person 8", "Developer");
        Employee employee9 = employeeManagementSystem.hirePerson("Person 9", "Tester");
        Employee employee10 = employeeManagementSystem.hirePerson("Person 10", "Developer");
        Employee employee11 = employeeManagementSystem.hirePerson("Person 11", "Project_Manager");
        Employee employee12 = employeeManagementSystem.hirePerson("Person 12", "Tester");
        Employee employee13 = employeeManagementSystem.hirePerson("Person 13", "Developer");
        Employee employee14 = employeeManagementSystem.hirePerson("Person 14", "Developer");
        Employee employee15 = employeeManagementSystem.hirePerson("Person 15", "Project_Manager");
        Employee employee16 = employeeManagementSystem.hirePerson("Person 16", "Tester");
        Employee employee17 = employeeManagementSystem.hirePerson("Person 17", "Project_Manager");
        Employee employee18 = employeeManagementSystem.hirePerson("Person 18", "Tester");
        Employee employee19 = employeeManagementSystem.hirePerson("Person 19", "Developer");
        Employee employee20 = employeeManagementSystem.hirePerson("Person 20", "Project_Manager");

        for (Employee employee : employeeManagementSystem.getEmployees()) {
            employee.displayInfo();
        }
        System.out.println("\n");
        employeeManagementSystem.displayAllProjects();
        System.out.println("\n");
        employeeManagementSystem.assignToProject(employee1.getId(), project1.getId());
        employeeManagementSystem.assignToProject(employee2.getId(), project1.getId());
        employeeManagementSystem.assignToProject(employee1.getId(), project2.getId());
        employeeManagementSystem.displayAllProjects();
    }
}