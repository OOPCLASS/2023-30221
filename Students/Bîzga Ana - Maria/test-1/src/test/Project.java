package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project {
    private int id;
    private String name;
    private List<String> requiredPosition;
    private List<Employee> teamMembers;

    public Project(int id, String name, List<String> requiredPosition) {
        this.id = id;
        this.name = name;
        this.requiredPosition = requiredPosition;
        this.teamMembers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getRequiredPosition() {
        return requiredPosition;
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public boolean addTeamMember(Employee employee) {
        int positions = 0;
        int occupiedpositions = 0;
        for (Employee searchemployee : teamMembers)
            if (Objects.equals(searchemployee.getPosition(), employee.getPosition()))
                occupiedpositions++;
        for (String pos : requiredPosition)
            if (Objects.equals(employee.getPosition(), pos))
                positions++;
        if (occupiedpositions < positions) {
            teamMembers.add(employee);
            return true;
        }
        return false;
    }

    public void displayInfo() {
        System.out.println("Project name : " + name);
        System.out.println("Participating employees: ");
        for (Employee employee : teamMembers) {
            employee.displayInfo();
        }
    }
}
