import java.lang.invoke.VarHandle;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee(123, "Paul", "developer");
        Employee employee2 = new Employee(746, "Vanessa", "designer");
        Employee employee3 = new Employee(702, "Stephen", "tester");
        Employee employee4 = new Employee(643, "John", "tester");
        Employee employee5 = new Employee(655, "Mark", "tester");
        Employee employee6 = new Employee(986, "Ana", "tester");
        Employee employee7 = new Employee(254, "Alex", "tester");
        Employee employee8 = new Employee(677, "Daniel", "tester");
        Employee employee9 = new Employee(642, "Ion", "tester");
        Employee employee10 = new Employee(978, "Popa", "tester");
        Employee employeee11 = new Employee(387, "Iris", "tester");
        Employee employee12 = new Employee(384, "Vlad", "tester");
        Employee employee13 = new Employee(290, "Ioana", "tester");
        Employee employee14 = new Employee(102, "Alexandra", "tester");
        Employee employee15 = new Employee(101, "Stefania", "tester");
        Employee employee16 = new Employee(105, "Roberta", "tester");
        Employee employee17 = new Employee(107, "Bogdan", "tester");
        Employee employee18 = new Employee(206, "Ionut", "tester");
        Employee employee19 = new Employee(398, "Mihai", "tester");
        Employee employee20 = new Employee(908, "Lelu", "tester");

        ArrayList<String> reqPos_1 = new ArrayList<>();
        reqPos_1.add("developer");
        reqPos_1.add("designer");

        ArrayList<String> reqPos_2 = new ArrayList<>();
        reqPos_2.add("developer");
        reqPos_2.add("designer");

        ArrayList<String> reqPos_3 = new ArrayList<>();
        reqPos_3.add("developer");
        reqPos_3.add("designer");

        ArrayList<Employee> teamMembers_1 = new ArrayList<>();
        teamMembers_1.add(employee4);
        teamMembers_1.add(employee5);
        teamMembers_1.add(employee3);

        ArrayList<Employee> teamMembers_2 = new ArrayList<>();
        teamMembers_2.add(employee9);
        teamMembers_2.add(employee20);
        teamMembers_2.add(employeee11);

        ArrayList<Employee> teamMembers_3 = new ArrayList<>();
        teamMembers_3.add(employee18);
        teamMembers_3.add(employee16);

        Project project1 = new Project(123, "web IDE", reqPos_1, teamMembers_1);
        Project project2 = new Project(456, "2d game", reqPos_2, teamMembers_2);
        Project project3 = new Project(789, "web-site", reqPos_3, teamMembers_3);

        EmployeeManagementClass management = new EmployeeManagementClass();
    }
}