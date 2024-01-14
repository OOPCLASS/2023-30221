package test_noiembrie2023;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private static int idIndex = 1;
    private int id;
    private String name;
    private List<String> requiredPositions;
    private List<Employee> teamMembers;


    public Project() {
        this.id = idIndex++;
        this.name = "Unknown";
        this.requiredPositions = new ArrayList<String>();
        this.teamMembers = new ArrayList<Employee>();

    }
    public Project(String name, List<String> requiredPositions,
                   List<Employee> teamMembers) {
        this.id = idIndex++;
        this.name = name;
        this.requiredPositions = requiredPositions;
        this.teamMembers = teamMembers;

    }

    public boolean addTeamMember(Employee employee) {
        if (this.requiredPositions.contains(employee.getPosition())) {
            this.teamMembers.add(employee);
            this.requiredPositions.remove(employee.getPosition());
            return true;
        }

        return false;

    }

    public String toString() {
        String s = "The project:\n" + "ID:" + this.id + " Name:" + this.name + "\n";

        s += requiredPositions + "\n" + teamMembers + "\n";
        return s;
    }

    public void displayInfo() {
        System.out.println(this.toString());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRequiredPositions() {
        return requiredPositions;
    }

    public void setRequiredPositions(List<String> requiredPositions) {
        this.requiredPositions = requiredPositions;
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

}
