public class Main {
    public static void main(String[] args) {
        //EmployeeManagementSys instance
        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();

        Project project1 = employeeManagementSystem.createProject("Project A", new String[]{"Project Manager", "Developer"});
        Project project2 = employeeManagementSystem.createProject("Project B", new String[]{"Developer", "Tester"});
        Project project3 = employeeManagementSystem.createProject("Project C", new String[]{"Project Manager", "Tester"});

        for (int i = 0; i < 20; i++) {
            Employee employee = employeeManagementSystem.hirePerson("Employee" + (i + 1), "Developer");
            employee.displayInfo();
        }
        System.out.println("----------------------");

        employeeManagementSystem.displayAllProjects();
        System.out.println("----------------------");


        employeeManagementSystem.assignToProject(1, 1);
        employeeManagementSystem.assignToProject(2, 1);
        employeeManagementSystem.assignToProject(3, 2);

        employeeManagementSystem.displayAllProjects();

        System.out.println("---------DONE---------");
        System.out.println("----------------------");
    }

}
