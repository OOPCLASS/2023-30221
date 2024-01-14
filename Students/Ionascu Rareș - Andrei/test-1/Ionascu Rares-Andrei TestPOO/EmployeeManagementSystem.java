import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {


    private Employee[] employees;
    private Project[] projects;
    private int employeeCount;
    private int projectCount;

    public EmployeeManagementSystem(int maxEmployees, int maxProjects) {
        this.employees = new Employee[maxEmployees];
        this.projects = new Project[maxProjects];
        this.employeeCount = 0;
        this.projectCount = 0;
    }

    public Employee hirePerson(String name, String position) {
        int id = employeeCount + 1;
        Employee newEmployee = new Employee();
        newEmployee.getInfo(id, name, position);
        employees[employeeCount++] = newEmployee;
        return newEmployee;
    }

    public Project createProject(String name, String[] requiredPositions) {
        int id = projectCount + 1;
        Project newProject = new Project(id, name, requiredPositions, requiredPositions.length);
        projects[projectCount++] = newProject;
        return newProject;
    }

    public boolean assignToProject(int employeeId, int projectId) {
        Employee employee = findEmployeeById(employeeId);
        Project project = findProjectById(projectId);

        if (employee != null && project != null) {
            return project.addTeamMember(employee);
        } else {
            return false;
        }
    }


    private Employee findEmployeeById(int employeeId) {
        for (int i = 0; i < employeeCount; i++) {
            Employee employee = employees[i];
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    private Project findProjectById(int projectId) {
        for (int i = 0; i < projectCount; i++) {
            Project project = projects[i];
            if (project.getId() == projectId) {
                return project;
            }
        }
        return null;
    }





}
