package utcn.ro;

import java.util.Arrays;

public class EmployeeManagementSystem {
    private static Integer nextID = 0;
    private Employee[] employees;
    private Project[] projects;

    public EmployeeManagementSystem() {
        this.employees = new Employee[0];
        this.projects = new Project[0];
    }

    private Integer getNextID() {
        return nextID++;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Project[] getProjects() {
        return projects;
    }

    public void setProjects(Project[] projects) {
        this.projects = projects;
    }

    public void hirePerson(String name, String position) {
        Employee[] newEmployees = new Employee[this.employees.length + 1];
        for (int i = 0; i < this.employees.length; i++) {
            newEmployees[i] = this.employees[i];
        }
        newEmployees[this.employees.length] = new Employee(this.getNextID(), name, position);
        this.employees = newEmployees;
    }

    public void createProject(String name, String[] requiredPositions) {
        Project[] newProjects = new Project[projects.length + 1];
        for (int i = 0; i < this.projects.length; i++) {
            newProjects[i] = this.projects[i];
        }
        newProjects[this.projects.length] = new Project(this.getNextID(), name, requiredPositions);
        this.projects = newProjects;
    }

    public boolean assignToProject(Integer employeeId, Integer projectId) {
        Project currentProject = null;
        Employee currentEmployee = null;
        for (int i = 0; i < this.projects.length; i++) {
            if(this.projects[i].getProjectId().equals(projectId)) {
                currentProject = this.projects[i];
                break;
            }
        }

        if(currentProject == null) {
            System.out.println("PROJECT NOT FOUND");
            return false;
        }

        for (int i = 0; i < this.employees.length; i++) {
            if(this.employees[i].getEmployeeId().equals(employeeId)) {
                currentEmployee = this.employees[i];
                break;
            }
        }

        if(currentEmployee == null) {
            System.out.println("EMPLOYEE NOT FOUND");
            return false;
        }

        for (int i = 0; i < currentProject.getTeamMembers().length; i++) {
            if(currentEmployee.getEmployeeId().equals(currentProject.getTeamMembers()[i].getEmployeeId())) {
                System.out.println("THIS EMPLOYEE IS ALREADY ASSIGNED TO THIS PROJECT");
                return false;
            }
        }

        for (int i = 0; i < currentProject.getRequiredPositions().length; i++) {
            if(currentEmployee.getPosition().equals(currentProject.getRequiredPositions()[i])) {
                currentProject.addTeamMember(currentEmployee);
                return true;
            }
        }

        System.out.println("THIS EMPLOYEE DOES NOT FIT THE PROJECT'S REQUIREMENTS");
        return false;
    }

    public Employee[] searchEmployee(String name, boolean exactMatch) {
        Employee[] list = new Employee[0];
        for(int i = 0; i < this.employees.length; i++) {
            if((exactMatch) ? name.equals(this.employees[i].getName()) :
                    this.employees[i].getName().contains(name)) {
                Employee[] newList = new Employee[list.length + 1];
                for (int j = 0; j < list.length; j++) {
                    newList[j] = list[j];
                }
                newList[list.length] = this.employees[i];
                list = newList;
            }
        }
        return list;
    }

    public void displayAllProjects() {
        for (int i = 0; i < this.projects.length; i++) {
            this.projects[i].displayInfo();
        }
    }
}
