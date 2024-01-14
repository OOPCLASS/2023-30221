
public class Main {

	public static void main(String[] args) {
		EmployeeManagementSystem system = new EmployeeManagementSystem();

        system.hirePerson("Andrei", "Project Manager");
        system.hirePerson("Marcel", "Project Manager");
        system.hirePerson("Ana", "Project Manager");
        system.hirePerson("Alex", "Developer");
        system.hirePerson("Darius", "Developer");
        system.hirePerson("Cosmin", "Developer");
        system.hirePerson("Raul", "Developer");
        system.hirePerson("David", "Developer");
        system.hirePerson("George", "Developer");
        system.hirePerson("Liviu", "Developer");
        system.hirePerson("Roxana", "Developer");
        system.hirePerson("Ioana", "Developer");
        system.hirePerson("Daniela", "Developer");
        system.hirePerson("Mihai", "Developer");
        system.hirePerson("Matei", "Developer");
        system.hirePerson("Monica", "Developer");
        system.hirePerson("Raluca", "Developer");
        system.hirePerson("Alexandru", "Developer");
        system.hirePerson("Silvia", "Developer");
        system.hirePerson("Sorin", "Developer");

        
        system.createProject("Proiect1",new String[] {"Project Manager","Developer"});
        system.createProject("Proiect2",new String[] {"Project Manager","Developer"});
        system.createProject("Proiect3",new String[] {"Project Manager","Developer"});
        system.assignToProject(0, 0);
        system.assignToProject(1, 1);
        system.assignToProject(2, 2);
        system.assignToProject(3, 0);
        system.assignToProject(4, 0);
        system.assignToProject(5, 0);
        system.assignToProject(6, 0);
        system.assignToProject(7, 1);
        system.assignToProject(8, 1);
        system.assignToProject(9, 1);
        system.assignToProject(10, 1);
        system.assignToProject(11, 1);
        system.assignToProject(12, 2);
        system.assignToProject(13, 2);
        system.assignToProject(14, 2);
        system.assignToProject(15, 2);
        system.assignToProject(16, 1);
        system.assignToProject(17, 2);
        system.assignToProject(18, 0);
        
        
        system.displayAllProjects();

	}
}
