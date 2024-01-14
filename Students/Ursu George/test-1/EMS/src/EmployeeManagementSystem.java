///
/// URSU GEORGE
///

import java.util.List;
import java.util.ArrayList;

public class EmployeeManagementSystem {
    private List<Employee> employees;
    private List<Project> projects;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public Employee hirePerson(String name, String position) {
        Employee employee = new Employee(name, position);
        employees.add(employee);
        return employee;
    }

    public Project createProject(String name, String[] requiredPosition) {
        Project project = new Project(name, requiredPosition);
        projects.add(project);
        return project;
    }

    public boolean assignToProject(int employeeId, int projectId) {
        Employee employee = findObj(employeeId, employees);
        Project project = findObj(projectId, projects);
        if (employee != null && project != null)
            return project.addTeamMember(employee);
        return false;
    }

    public List<Employee> searchEmployee(String Name, boolean exactMatch) {
        List<Employee> resultMatch = new ArrayList<>();

        for (Employee employee : employees)
            if (exactMatch == true && employee.getName().equals(Name) == true)
                resultMatch.add(employee);
            else if (exactMatch == false && employee.getName().equals(Name) == true)
                resultMatch.add(employee);

        return resultMatch;
    }

    public void printSearchEMP(String name, boolean exactMatch) {
        List<Employee> searchResult = this.searchEmployee(name, exactMatch);
        if (searchResult.isEmpty() == true) {
            System.out.println("No employeee found with the name " + name);
            return;
        }
        System.out.println("Search Result for " + name + " : ");
        for (Employee employee : searchResult)
            employee.displayInfo();
    }

    public void displayAllProjects() {
        for (Project proj : projects)
            proj.displayInfo();
    }

    private <LIST> LIST findObj(int id, List<LIST> list) {
        for (LIST objects : list) {
            if (objects instanceof Employee && ((Employee) objects).getId() == id)
                return objects;
            else if (objects instanceof Project && ((Project) objects).getId() == id)
                return objects;

        }
        System.out.println("ERR : Object could not be found");
        return null;
    }

}
