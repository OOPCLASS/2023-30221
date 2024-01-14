import utcn.ro.*;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem sys = new EmployeeManagementSystem();
        sys.createProject("Game Engine", new String[]{"Project Manager", "Graphic Designer", "Intern", "Developer"});
        sys.createProject("AI Model", new String[]{"Project Manager", "Data Scientist", "Intern", "Developer"});
        sys.createProject("Something random", new String[]{"Project Manager", "Intern", "Developer", "Developer"});

        sys.hirePerson("John", "Data Scientist");
        sys.hirePerson("Johnny", "Intern");
        sys.hirePerson("Mishu", "Developer");
        sys.hirePerson("Sergiu", "Intern");
        sys.hirePerson("Jova", "Graphic Designer");
        sys.hirePerson("Ion", "Janitor");
        sys.hirePerson("Marioara", "Janitor");
        sys.hirePerson("Trevor", "Developer");
        sys.hirePerson("Franklin", "Project Manager");
        sys.hirePerson("Maria", "Intern");
        sys.hirePerson("Ioana", "Developer");
        sys.hirePerson("Dan", "Project Manager");
        sys.hirePerson("Silviu", "Project Manager");
        sys.hirePerson("Ana", "Developer");
        /*sys.hirePerson();
        sys.hirePerson();
        sys.hirePerson();
        sys.hirePerson();
        sys.hirePerson();
        sys.hirePerson();*/

        sys.assignToProject(3, 1);
        sys.assignToProject(4, 2);
        sys.assignToProject(5, 0);
        sys.assignToProject(6, 0);

        for (Employee a: sys.searchEmployee("John", false)) {
            a.displayInfo();
        }

        sys.displayAllProjects();
    }
}