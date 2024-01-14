package test;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private static int counter = 0;
    private int id;
    private String name;
    private List<Position> requiredPositions;
    private List<Employee> teamMembers;
    public Project() {
        this.id = ++counter;
        requiredPositions = new ArrayList<>();
        teamMembers = new ArrayList<>();
    }

    public Project(String name) {
        this.id = ++counter;
        requiredPositions = new ArrayList<>();
        teamMembers = new ArrayList<>();
        this.name = name;
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

    public List<Position> getRequiredPositions() {
        return requiredPositions;
    }

    public void setRequiredPositions(List<Position> requiredPositions) {
        this.requiredPositions = requiredPositions;
    }

    public boolean checkIfPositionNeeded(Position pos){
        int countRequired = 0;
        int countTotal = 0;
        for (Position requiredPosition : requiredPositions) {
                if(requiredPosition.equals(pos)){
                    countRequired++;
                }
        }
        for (Employee teamMember : teamMembers) {
                if(teamMember.getPosition().equals(pos)){
                    countTotal++;
                }
        }
        return countRequired < countTotal;
    }
    public boolean addTeamMember(Employee employee) {
        if (checkIfPositionNeeded(employee.getPosition())) {
            teamMembers.add(employee);
            return true;
        } else {
            System.out.println("Cannot add  member, position not needed");
            return false;
        }
    }

    public void displayInfo(){
        System.out.println("Project info: " + id + " " + name);
        System.out.println("Required Positions: " + requiredPositions);
        System.out.println("Team Members: ");
        for (Employee member : teamMembers) {
            System.out.println(member.getName() + " (" + member.getPosition() + ")");
        }
    }
}
