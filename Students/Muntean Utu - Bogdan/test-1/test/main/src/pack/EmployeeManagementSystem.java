package pack;

import java.util.ArrayList;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees;
    private ArrayList<Project> projects;
    public EmployeeManagementSystem(){
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
    }
    public Employee hirePerson(int id,String name, String position){
        Employee employee = new Employee(id, name, position);
        employees.add(employee);
        return employee;
    }
    public Project createProject(int id,String name, String[] requiredPositions){
        Project project = new Project(id,name,requiredPositions);
        projects.add(project);
        return project;
    }
    public boolean assingToProject(int employeeID, int projectID) {
        Employee employee = null;
        for (Employee emp : employees) {
            if (emp.getId() == employeeID) {
                employee = emp;
                break;
            }
        }
        Project project = null;
        for (Project prj : projects) {
            if (prj.getId() == projectID) {
                project = prj;
                break;
            }
        }
        if(employee != null && project != null)
            return project.addTeamMember(employee);
        else{
            System.out.println("Employee or Project not found.");
            return false;
        }
    }
    public Employee findEmployeeById(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null;
    }
    public Project findProjectById(int projectId) {
        for (Project project : projects) {
            if (project.getId() == projectId) {
                return project;
            }
        }
        return null;
    }
    public void displayALLProjects(){
        System.out.println("ALL Projects:");
        for(Project project: projects)
            project.displayInfo();
    }
}
