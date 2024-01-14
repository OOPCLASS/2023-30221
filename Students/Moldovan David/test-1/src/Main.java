import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        Employee emp1 = ems.hirePerson("Moldovan David", "Project Manager");
        Employee emp2 = ems.hirePerson("Alexandrescu", "Developer");
        Employee emp3 = ems.hirePerson("Andrei", "Developer");
        Employee emp4 = ems.hirePerson("Ilie", "Developer");
        Employee emp5 = ems.hirePerson("Maria", "Tester");
        Employee emp6 = ems.hirePerson("Cosmin", "Tester");
        Employee emp7 = ems.hirePerson("Darius", "Tester");
        Employee emp8 = ems.hirePerson("Beni", "Project Manager");
        Employee emp9 = ems.hirePerson("Lucian", "Developer");
        Employee emp10 = ems.hirePerson("George", "Developer");
        Employee emp11 = ems.hirePerson("Marius", "Developer");
        Employee emp12 = ems.hirePerson("Ronaldo", "Tester");
        Employee emp13 = ems.hirePerson("Messi", "Tester");
        Employee emp14 = ems.hirePerson("Hagi", "Tester");
        Employee emp15 = ems.hirePerson("Basescu", "Project Manager");
        Employee emp16 = ems.hirePerson("Iliescu", "Developer");
        Employee emp17 = ems.hirePerson("Constantinescu", "Developer");
        Employee emp18 = ems.hirePerson("Boc", "Developer");
        Employee emp19 = ems.hirePerson("Dumitrescu", "Tester");
        Employee emp20 = ems.hirePerson("Scarlatescu", "Tester");

        Project project1 = ems.createProject("Project A", new String[]{"Project Manager", "Developer","Tester"});
        Project project2 = ems.createProject("Project B", new String[]{"Project Manager", "Developer", "Tester"});
        Project project3 = ems.createProject("Project C", new String[]{"Project Manager", "Developer", "Tester"});

        ems.assignToProject(emp1.getId(), project1.getId());
        ems.assignToProject(emp2.getId(), project1.getId());
        ems.assignToProject(emp3.getId(), project1.getId());
        ems.assignToProject(emp4.getId(), project1.getId());
        ems.assignToProject(emp5.getId(), project1.getId());
        ems.assignToProject(emp6.getId(), project1.getId());
        ems.assignToProject(emp7.getId(), project1.getId());
        ems.assignToProject(emp8.getId(), project2.getId());
        ems.assignToProject(emp9.getId(), project2.getId());
        ems.assignToProject(emp10.getId(), project2.getId());
        ems.assignToProject(emp11.getId(), project2.getId());
        ems.assignToProject(emp12.getId(), project2.getId());
        ems.assignToProject(emp13.getId(), project2.getId());
        ems.assignToProject(emp14.getId(), project2.getId());
        ems.assignToProject(emp15.getId(), project3.getId());
        ems.assignToProject(emp16.getId(), project3.getId());
        ems.assignToProject(emp17.getId(), project3.getId());
        ems.assignToProject(emp18.getId(), project3.getId());
        ems.assignToProject(emp19.getId(), project3.getId());
        ems.assignToProject(emp20.getId(), project3.getId());


        ems.displayAllProjects();


    }
}
