package Test;

import java.util.Arrays;
public class EmployeeManagementSystem {
    private Employee[] employees;
    private Project[] projects;

    public EmployeeManagementSystem(){
        this.employees = new Employee[2];
        this.projects = new Project[2];

    }

    public Employee hirePeople(String name, String position){
        Employee employee = new Employee(name, position);

        if (employees.length == Arrays.stream(employees).filter(e -> e != null).count()){
            employees = Arrays.copyOf(employees, employees.length * 2);
        }

        for(int i = 0; i < employees.length; i++){
            if(employees[i] == null){
                employees[i] = employee;
                break;
            }
        }
        return employee;

    }

    public Project createProject(String name, String[] requiredPositions){
        Project project = new Project(name, requiredPositions);

        if(projects.length == Arrays.stream(projects).filter(e -> e != null).count()){
            projects = Arrays.copyOf(projects, projects.length * 2);
        }

        for (int i = 0; i < projects.length; i++){
            if(projects[i] == null){
                projects[i] = project;
                break;

            }
        }
        return project;
    }
    public boolean assignPeopleToProjects(int employeeID, int projectID){
        Employee employee = searchEmployeeByID(employeeID);
        Project project = searchProjectByID(projectID);

        if (employee != null && project != null){
            return project.addTeamMember(employee);
        }
        else{
            System.out.println("Couldn`t find project or employee");
            return false;
        }
    }
    public Employee[] searchEmployee(String name, boolean exactCharacters){
        if(exactCharacters){
            return Arrays.stream(employees)
                    .filter(e -> e!= null && e.getName().equals(name)).toArray(Employee[]::new);
        }
        else {
            String lowerCaseName = name.toLowerCase();
            return Arrays.stream(employees).filter(e -> e != null && e.getName().toLowerCase().contains(lowerCaseName))
                    .toArray(Employee[]::new);
        }
    }

    public void displayAllProjects(){
        for(Project project : projects) {
            if (project != null) {
                project.displayInfo();
                System.out.println();
            }
        }
    }

    private Employee searchEmployeeByID(int employeeID){
        return Arrays.stream(employees)
                .filter(e -> e != null && e.getId() == employeeID).findFirst().orElse(null);
    }
    private Project searchProjectByID(int projectID){
        return Arrays.stream(projects)
                .filter(e -> e != null && e.getId() == projectID).findFirst().orElse(null);
    }
}
