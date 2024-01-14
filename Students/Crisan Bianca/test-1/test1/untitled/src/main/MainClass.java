package main;

public class MainClass {
    public static void main(String[] args) {
        EmployeeManagementSystem system=new EmployeeManagementSystem();

        Employee person1=system.hirePerson("Ana","Manager");
        Employee person2=system.hirePerson("Maria","Developer");
        Employee person3=system.hirePerson("George","Manager");
        Employee person4=system.hirePerson("Dan","Director");
        Employee person5=system.hirePerson("Sebi","Manager");
        Employee person6=system.hirePerson("Cristina","Tester");
        Employee person7=system.hirePerson("Bianca","Developer");

        Project project1 = system.createProject("Project1", new String[]{"Manager", "Developer"});
        Project project2 = system.createProject("Project2", new String[]{"Manager", "Tester"});
        Project project3 = system.createProject("Project3", new String[]{"Director", "Developer"});

        system.displayAllProjects();
    }
}
