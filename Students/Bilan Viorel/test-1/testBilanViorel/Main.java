import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem employees = new EmployeeManagementSystem();


        employees.hirePerson("John", "Project Manager");
        employees.hirePerson("Madalin Serban", "Project Manager");
        employees.hirePerson("Michael Jackson", "Project Manager");
        employees.hirePerson("Adrian", "Developer");
        employees.hirePerson("Florinel", "Developer");
        employees.hirePerson("Denisa Blond", "Developer");
        employees.hirePerson("Bogdan GPL", "Developer");
        employees.hirePerson("Elon Must", "Developer");
        employees.hirePerson("Messi Goat", "Developer");
        employees.hirePerson("Ecaterina", "Developer");
        employees.hirePerson("Jane Jacks", "QA");
        employees.hirePerson("Aleodor Imparat", "QA");
        employees.hirePerson("Kevin DeBrunetu", "QA");
        employees.hirePerson("Hij Eminem", "QA");
        employees.hirePerson("Pop Marinel", "QA");
        employees.hirePerson("Padurescu Bradut", "QA");
        employees.hirePerson("Kevin DeBrunetu", "Junior");
        employees.hirePerson("Hij Eminem", "Junior");
        employees.hirePerson("Pop Marinel", "Junior");
        employees.hirePerson("Padurescu Bradut", "Junior");



        employees.createProject("Project Instagram", new String[]{"Project Manager", "Developer"});
        employees.createProject("Project BeReal", new String[]{"Project Manager", "Developer", "QA"});
        employees.createProject("Project FaceBook", new String[]{"Project Manager", "QA", "Junior"});


        employees.assignToProject(0, 0);
        employees.assignToProject(1, 1);
        employees.assignToProject(2, 2);
        employees.assignToProject(3, 0);
        employees.assignToProject(4, 0);
        employees.assignToProject(5, 1);
        employees.assignToProject(6, 1);
        employees.assignToProject(7, 1);
        employees.assignToProject(8, 1);
        employees.assignToProject(9, 0);
        employees.assignToProject(10, 1);
        employees.assignToProject(11, 1);
        employees.assignToProject(12, 1);
        employees.assignToProject(13, 2);
        employees.assignToProject(14, 2);
        employees.assignToProject(15, 2);
        employees.assignToProject(16, 2);
        employees.assignToProject(17, 2);
        employees.assignToProject(18, 2);
        employees.assignToProject(19, 2);


        // Displaying all projects
        employees.displayAllProjects();
    }
}