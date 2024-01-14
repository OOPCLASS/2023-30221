package EmployeeManager;

import EmployeeManager.Employee;

import java.util.ArrayList;
import java.util.Arrays;
public class Project {
    private int id;
    private String name;
    private String[] requiredPositions;
    private ArrayList<Employee> teamMembers;

    public Project(String name, String[] requiredPositions, ArrayList<Employee> teamMembers) {
        this.name = name;
        this.requiredPositions = requiredPositions;
        this.teamMembers = new ArrayList<>();
    }

    public Project(int id, String name, String[] requiredPositions) {
        this.id = id;
        this.name = name;
        this.requiredPositions = requiredPositions;
    }

    public boolean addTeamMember(Employee employee) {
        if (Arrays.asList(requiredPositions).contains(employee.getPosition())) {
            teamMembers.add(employee);
            return true;
        }
        return false;
    }
    public void displayInfo()
    {
        System.out.println("EmployeeManager.Project id: " + id);
        System.out.println("EmployeeManager.Project name: " + name);
        System.out.println("Required Positions: " + Arrays.toString(requiredPositions));
        System.out.println("Team Members:");
        for (Employee employee : teamMembers) {
            employee.displayInfo();
        }
    }

    public int getId() {
        return id;
    }
}
