import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        system.hirePerson("Cosmin","Manager");
        system.hirePerson("Viorel","Employee");
        system.hirePerson("Sebastian","Manager");
        system.hirePerson("Alex","Manager");
        system.hirePerson("Matei","Employee");
        system.hirePerson("Ana","Employee");
        system.hirePerson("Alexandra","Manager");
        system.hirePerson("Rares","Employee");
        system.hirePerson("Paul","Manager");
        system.hirePerson("Paula","Employee");
        system.hirePerson("Gabriel","Employee");
        system.hirePerson("Gabriela","Employee");
        system.hirePerson("Ion","Employee");
        system.hirePerson("Ioan","Project Manager");
        system.hirePerson("Ioana","Manager");
        system.hirePerson("Vasile","Project Manager");
        system.hirePerson("Mihai","Manager");
        system.hirePerson("Raluca","Employee");
        system.hirePerson("Ionela","Employee");
        system.hirePerson("Gheorghe","Employee");

        system.createProject("Project1",new String[]{"Project Manager","Manager"});
        system.createProject("Project2",new String[]{"Project Manager","Employee"});
        system.createProject("Project3",new String[]{"Employee"});

        system.assignToProject(3,1);
        ArrayList<Employee> emp = system.searchEmployee("Paul",false);
        for (Employee i: emp) {
            i.displayInfo();
        }
        system.displayAllProjects();

    }
}