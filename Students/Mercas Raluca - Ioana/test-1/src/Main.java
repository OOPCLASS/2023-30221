import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();

        Employee employee1 = new Employee(1, "Marry", "Manager");
        Employee employee2 = new Employee(2, "Bob", "Full stack developer");
        Employee employee3 = new Employee(3, "Ana", "Front end developer");
        Employee employee4 = new Employee(4, "Chris", "Front end developer");
        Employee employee5 = new Employee(5, "name5", "Back end developer");
        Employee employee6 = new Employee(6, "name6", "Back end developer");
        Employee employee7 = new Employee(7, "name7", "Back end developer");
        Employee employee8 = new Employee(8, "name8", "Back end developer");



        ArrayList<String> requiredPositions1 = new ArrayList<>();
        requiredPositions1.add("Manager");
        requiredPositions1.add("Front end developer");
        Project project1 = new Project(101, "Web Design", requiredPositions1);
        project1.addTeamMember(employee1);
        project1.addTeamMember(employee2);
        project1.addTeamMember(employee3);
        project1.addTeamMember(employee4);


        ArrayList<String> requiredPositions2 = new ArrayList<>();
        requiredPositions2.add("Full stack developer");

        ArrayList<String> requiredPositions3 = new ArrayList<>();
        requiredPositions3.add("Back end developer");

        Project project2 = new Project(102, "Personal project", requiredPositions2);
        Project project3 = new Project(103, "Cyber Security", requiredPositions3);


        employee3.displayInfo();
        project1.displayInfo();
        project2.displayInfo();

    }
}
