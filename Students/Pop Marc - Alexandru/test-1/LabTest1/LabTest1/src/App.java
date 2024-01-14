public class App {
    public static void main(String[] args) throws Exception {
        EmployeeManagementSystem managementSystem = EmployeeManagementSystem.getInstance();

        String[] positionsProject1 = new String[] {"PM", "Dev", "Dev"}; 
        String[] positionsProject2 = new String[] {"Team Lead", "Dev", "Tester"};
        String[] positionsProject3 = new String[] {"TeamLead", "Dev", "Dev"};


        managementSystem.createProject("Project1", positionsProject1);        
        managementSystem.createProject("Project2", positionsProject2);
        managementSystem.createProject("Project3", positionsProject3);

        managementSystem.hirePerson("Andrei", "Dev");
        managementSystem.hirePerson("Maria", "PM");
        managementSystem.hirePerson("Cristian", "Team Lead");
        managementSystem.hirePerson("Alex", "Tester");
        managementSystem.hirePerson("Ana", "Team Lead");

        for (int i = 0; i < 15; i++) {
            managementSystem.hirePerson("Emplpoyee" + i, "Dev");
        }

        managementSystem.assignToProject(0, 0);        
        managementSystem.assignToProject(1, 0);
        managementSystem.assignToProject(8, 0);
        managementSystem.assignToProject(2, 1);


        managementSystem.displayAllProjects();

        System.out.println(managementSystem.searchEmployee("Andrei", true)[0].getId());
    }
}
