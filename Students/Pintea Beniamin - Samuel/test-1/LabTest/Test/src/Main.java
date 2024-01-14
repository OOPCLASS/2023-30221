import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
            EmployeeManagementSystem managementSystem = new EmployeeManagementSystem();

            List<Employee> someEmployees = createEmployees();
            List<Project>  someProjects = createProjects();
            for (Employee employee:someEmployees ) {
                managementSystem.hirePerson(employee.getName(), employee.getPosition(), employee.getId());
            }
            for (Project project: someProjects) {
                managementSystem.createProject(project.getName(), project.getRequiredPosition(), project.getId());
            }

            /// printing all employees;

            for (Employee employee:managementSystem.employees) {
                employee.displayInfo();
            }

            /// printing all projects;

            managementSystem.displayAllProjects();

            String nameToFindExactly = "Employee_2";
            List<Employee> foundEmployees =  managementSystem.searchEmployee(nameToFindExactly, true);
            System.out.println("<<<<<Found Exactly>>>>>");
            for (Employee employee:foundEmployees) {
                employee.displayInfo();
            }

            String nameSubstring = "Empl";
            foundEmployees = managementSystem.searchEmployee(nameToFindExactly, false);
            System.out.println("<<<<<Found Substring>>>>>");
            for (Employee employee:foundEmployees) {
                employee.displayInfo();
            }


    }

    private static List<Employee> createEmployees() {

        List<Employee> employeesList = new ArrayList<>();

        for (int i = 0; i < 20; ++i) {

            int employeeId = i + 1;
            String employeeName = "Employee_" + employeeId;
            String employeePosition;
            if (i % 5 == 0) {
                employeePosition = "Project Manager";
            }
            else {
                employeePosition = "Developer";
            }

            Employee employee = new Employee();

            employee.setId(employeeId);
            employee.setName(employeeName);
            employee.setPosition(employeePosition);

            employeesList.add(employee);

        }

        return employeesList;

    }

    private static List<Project> createProjects() {

        List<Project> projects = new ArrayList<Project>();

        Project project1 = new Project();
        project1.setId(21);
        project1.setName("ProjectName1");
        String[] positionsProject1 = {"Developer", "Developer", "Developer", "Developer", "Project Manager"};
        project1.setRequiredPosition(positionsProject1);

        Project project2 = new Project();
        project2.setId(22);
        project2.setName("ProjectName2");
        String[] positionsProject2 = {"Developer", "Developer", "Developer", "Developer", "Project Manager"};
        project2.setRequiredPosition(positionsProject1);

        Project project3 = new Project();
        project3.setId(23);
        project3.setName("ProjectName3");
        String[] positionsProject3 = {"Developer", "Developer", "Developer", "Project Manager"};
        project3.setRequiredPosition(positionsProject1);

        projects.add(project1);
        projects.add(project2);
        projects.add(project3);

        return projects;

    }


}