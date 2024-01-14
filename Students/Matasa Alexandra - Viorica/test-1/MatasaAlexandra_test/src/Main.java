// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();

        Project project1 = employeeManagementSystem.createProject("Mobile apps", new String[]{"Project Manager", "Developer", "Developer"});
        Project project2 = employeeManagementSystem.createProject("Database Management System", new String[]{"Project Manager", "Developer"});
        Project project3 = employeeManagementSystem.createProject("Web Development", new String[]{"Project Manager", "Frontend Developer", "Backend Developer"});
        project1.displayInfo();

        Employee employee1 = employeeManagementSystem.hirePerson("Andrei Popescu", "Project Manager");
        Employee employee2 = employeeManagementSystem.hirePerson("Maria Andronescu", "Developer");
        Employee employee3 = employeeManagementSystem.hirePerson("Ioan Nichita", "Frontend Developer");
        Employee employee4 = employeeManagementSystem.hirePerson("Ioana Tataru", "Backend Developer");
        Employee employee5 = employeeManagementSystem.hirePerson("Vasile Taranu", "Developer");
        employee1.displayInfo();

        employeeManagementSystem.assignToProject(employee1.getId(), project1.getId());
        employeeManagementSystem.assignToProject(employee2.getId(), project1.getId());
        employeeManagementSystem.assignToProject(employee3.getId(), project2.getId());
        employeeManagementSystem.assignToProject(employee4.getId(), project3.getId());
        employeeManagementSystem.assignToProject(employee5.getId(), project2.getId());

        employeeManagementSystem.displayAllProjects();

        Employee[] matchingEmployees = employeeManagementSystem.searchEmployee("Andrei Popescu", true);
        System.out.println("Matching Employees:");
        for (Employee employee : matchingEmployees) {
            employee.displayInfo();
        }

        

    }
}