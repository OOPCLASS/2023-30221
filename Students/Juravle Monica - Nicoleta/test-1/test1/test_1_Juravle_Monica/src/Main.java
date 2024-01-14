public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem employeeManagementSys = new EmployeeManagementSystem();

        Employee employee1 = employeeManagementSys.hirePerson("John", "Project Manager");
        Employee employee2 = employeeManagementSys.hirePerson("Maria", "Developer");
        Employee employee3 = employeeManagementSys.hirePerson("Johnny", "Chief");
        Employee employee4 = employeeManagementSys.hirePerson("Mary", "Project Manager");
        Employee employee5 = employeeManagementSys.hirePerson("Ariana", "Developer");
        Employee employee6 = employeeManagementSys.hirePerson("Steve", "Chief");
        Employee employee7 = employeeManagementSys.hirePerson("Alex", "Chief");
        Employee employee8 = employeeManagementSys.hirePerson("Alex2", "Project Manager");
        Employee employee9 = employeeManagementSys.hirePerson("Alex3", "Chief");
        Employee employee10 = employeeManagementSys.hirePerson("Ana", "Developer");
        Employee employee11 = employeeManagementSys.hirePerson("Ana2", "Project Manager");
        Employee employee12 = employeeManagementSys.hirePerson("Ana3", "Chief");
        Employee employee13 = employeeManagementSys.hirePerson("Sebastian", "Chief");
        Employee employee14 = employeeManagementSys.hirePerson("Elon", "Developer");
        Employee employee15 = employeeManagementSys.hirePerson("name1", "Chief");
        Employee employee16 = employeeManagementSys.hirePerson("name2", "Project Manager");
        Employee employee17 = employeeManagementSys.hirePerson("name3", "Chief");
        Employee employee18 = employeeManagementSys.hirePerson("name4", "Developer");
        Employee employee19 = employeeManagementSys.hirePerson("name5", "Project Manager");
        Employee employee20 = employeeManagementSys.hirePerson("name6", "Developer");

        Project project1 = employeeManagementSys.createProject("Car app", new String[]{"Developer", "Developer", "Chief", "Project Manager", "Project Manager"});
        Project project2 = employeeManagementSys.createProject("Phone app", new String[]{"Developer", "Developer", "Developer", "Developer", "Developer", "Chief", "Project Manager", "Project Manager"});
        Project project3 = employeeManagementSys.createProject("Laptop app", new String[]{"Developer", "Developer", "Developer", "Developer", "Chief", "Project Manager", "Project Manager", "Project Manager"});

        employee1.displayInfo();
        employee2.displayInfo();
        employee3.displayInfo();
        employee4.displayInfo();
        employee5.displayInfo();
        employee6.displayInfo();
        employee7.displayInfo();
        employee8.displayInfo();
        employee9.displayInfo();
        employee10.displayInfo();

        project1.displayInfo();
        project2.displayInfo();
        project3.displayInfo();

        employeeManagementSys.displayAllProjects();

        employeeManagementSys.searchEmployee("Steve", true);
        employeeManagementSys.searchEmployee("name6", true);
    }
}