package pack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();

        // Create 20 employees
        for (int i = 1; i <= 20; i++) {
            employeeManagementSystem.hirePerson(i, "Employee" + i, "Position" + i);
        }

        // Create 3 projects
        for (int i = 1; i <= 3; i++) {
            String[] requiredPositions = {"Position" + i};
            employeeManagementSystem.createProject(i, "Project" + i, requiredPositions);
        }

        // Assign employees to projects
        for (int i = 1; i <= 20; i++) {
            int projectId = i % 3 + 1; // Assign employees to projects in a cyclic manner
            employeeManagementSystem.assingToProject(i, projectId);
        }

        // Display information
        employeeManagementSystem.displayALLProjects();
    }
}