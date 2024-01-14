///
/// URSU GEORGE
///
public class Main {
    public static void main(String[] args) {

        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        Employee emp1 = ems.hirePerson("Ursu George", "DEV");
        Employee emp2 = ems.hirePerson("Alin All-IN", "SOFTDEV");
        Employee emp3 = ems.hirePerson("Pop Andrei", "SOFTDEV");
        Employee emp4 = ems.hirePerson("Pop Mircea", "DEV");
        Employee emp5 = ems.hirePerson("Matei Ban", "SOFTDEV");
        Employee emp6 = ems.hirePerson("Goerde gor", "DEV");
        Employee emp7 = ems.hirePerson("Macaran Alin", "PRJ-MANAGER");
        Employee emp8 = ems.hirePerson("Ginge Dinte", "SOFTDEV");
        Employee emp9 = ems.hirePerson("Java Scripter", "PRJ-MANAGER");
        Employee emp10 = ems.hirePerson("Hop SASA", "DEV");
        Employee emp11 = ems.hirePerson("Mircea Pop", "PRJ-MANAGER");
        Employee emp12 = ems.hirePerson("Bamba Lina", "SOFTDEV");
        Employee emp13 = ems.hirePerson("Nagarro ceo", "SOFTDEV");
        Employee emp14 = ems.hirePerson("Alin Bobo", "PRJ-MANAGER");
        Employee emp15 = ems.hirePerson("Andrei Marc", "SECURITY");
        Employee emp16 = ems.hirePerson("Truta Andrei", "DEV");
        Employee emp17 = ems.hirePerson("Axinte Alin", "SOFTDEV");
        Employee emp18 = ems.hirePerson("Andreea Laz", "DEV");
        Employee emp19 = ems.hirePerson("Diana POp", "SOFTDEV");
        Employee emp20 = ems.hirePerson("Vasile Pop", "PRJ-MANAGER");

        Project prj1 = ems.createProject("Prj ALFA", new String[]{"DEV", "DEV", "SOFTDEV", "PRJ-MANAGER", "SOFTDEV", "DEV", "SOFTDEV"});
        Project prj2 = ems.createProject("Prj BETA", new String[]{"SECURITY", "SOFTDEV", "PRJ-MANAGER", "PRJ-MANAGER"});
        Project prj3 = ems.createProject("Prj GAMMA", new String[]{"PRJ-MANAGER", "PRJ-MANAGER", "DEV", "DEV"});

        ems.assignToProject(emp1.getId(), prj1.getId());
        ems.assignToProject(emp2.getId(), prj1.getId());
        ems.assignToProject(emp3.getId(), prj1.getId());
        ems.assignToProject(emp4.getId(), prj1.getId());
        ems.assignToProject(emp5.getId(), prj2.getId());
        ems.assignToProject(emp6.getId(), prj1.getId());
        ems.assignToProject(emp7.getId(), prj2.getId());
        ems.assignToProject(emp8.getId(), prj1.getId());
        ems.assignToProject(emp9.getId(), prj2.getId());
        ems.assignToProject(emp10.getId(), prj1.getId());
        ems.assignToProject(emp11.getId(), prj1.getId());
        ems.assignToProject(emp12.getId(), prj1.getId());
        ems.assignToProject(emp13.getId(), prj1.getId());
        ems.assignToProject(emp14.getId(), prj3.getId());
        ems.assignToProject(emp15.getId(), prj2.getId());
        ems.assignToProject(emp16.getId(), prj3.getId());
        ems.assignToProject(emp17.getId(), prj1.getId());
        ems.assignToProject(emp18.getId(), prj3.getId());
        ems.assignToProject(emp19.getId(), prj1.getId());
        ems.assignToProject(emp20.getId(), prj3.getId());


        System.out.println("--------------------");
        ems.displayAllProjects();

        ems.printSearchEMP("Ursu George", true);
        ems.printSearchEMP("Ursu george", true);

        ems.printSearchEMP("Goerde gor", true);
    }
}