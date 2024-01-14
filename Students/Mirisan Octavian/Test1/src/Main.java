import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        String[] requiredPositions ={"Project Manager","Developer"};

        String[] positions1 = {"Project Manager","Developer","Developer","Developer",};
        String[] positions2 = {"Project Manager","Developer","Developer"};
        String[] positions3 = {"Project Manager","Project Manager","Developer","Developer","Developer"};

        Project project1 = new Project(1,"Project1",positions1);
        Project project2 = new Project(2,"Project2",positions2);
        Project project3 = new Project(3,"Project3",positions3);

        Employee employee1 = new Employee(1,"Mircea",requiredPositions[1]);
        Employee employee2 = new Employee(2,"Dan",requiredPositions[1]);
        Employee employee3 = new Employee(3,"Marcel",requiredPositions[0]);
        Employee employee4 = new Employee(4,"Mihai",requiredPositions[1]);
        Employee employee5 = new Employee(5,"Radu",requiredPositions[1]);
        Employee employee6 = new Employee(6,"Bogdan",requiredPositions[1]);
        Employee employee7 = new Employee(7,"Alin",requiredPositions[1]);
        Employee employee8 = new Employee(8,"Marius",requiredPositions[0]);
        Employee employee9 = new Employee(9,"Mircea",requiredPositions[1]);
        Employee employee10 = new Employee(10,"Andreea",requiredPositions[1]);
        Employee employee11 = new Employee(11,"Razvan",requiredPositions[1]);
        Employee employee12 = new Employee(12,"Alexandra",requiredPositions[0]);
        Employee employee13 = new Employee(13,"Tudor",requiredPositions[1]);
        Employee employee14 = new Employee(14,"Teodora",requiredPositions[1]);
        Employee employee15 = new Employee(15,"Liviu",requiredPositions[1]);
        Employee employee16 = new Employee(16,"Dan",requiredPositions[1]);
        Employee employee17 = new Employee(17,"Dumitru",requiredPositions[0]);

        EmployeeManagementSystem managementSystem = new EmployeeManagementSystem();
        managementSystem.employees= new ArrayList<>();
        managementSystem.projects= new ArrayList<>();

        managementSystem.hirePerson(employee1.name,employee1.position);
        managementSystem.hirePerson(employee17.name, employee17.position);
        managementSystem.hirePerson(employee15.name, employee15.position);
        managementSystem.hirePerson(employee4.name, employee4.position);

        managementSystem.createProject("Project1",requiredPositions);
        managementSystem.createProject("Project2",requiredPositions);
        managementSystem.createProject("Project3",requiredPositions);

        managementSystem.displayAllProjects();

        managementSystem.assignToProject(employee1.id,project1.id);
        managementSystem.assignToProject(employee17.id,project1.id);
        managementSystem.assignToProject(employee15.id,project1.id);

        managementSystem.searchEmployee("Mircea",true);


    }
}
