package Test;

import java.util.Arrays;
public class Project {
    private static int next_Id = 1;
    private int id;
    private String name;
    private String[] requiredPositions;
    private Employee[] teamMembers;

    public Project(String name, String[] requiredPositions){
        this.id = next_Id ++;
        this.name = name;
        this.requiredPositions = requiredPositions;
        this.teamMembers = new Employee[0];


    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getRequiredPositions() {
        return requiredPositions;
    }

    public Employee[] getTeamMembers() {
        return teamMembers;
    }

    public boolean addTeamMember(Employee employee) {
        long count = Arrays.stream(teamMembers)
                .filter(member -> member.getPosition().equals(employee.getPosition()))
                .count();
        int requiredCount = (int) Arrays.stream(requiredPositions)
                .filter(position -> position.equals(employee.getPosition()))
                .count();

        if (count < requiredCount){
            teamMembers = Arrays.copyOf(teamMembers, teamMembers.length + 1);
            teamMembers[teamMembers.length - 1] = employee;
            return true;
        }
        else {
            System.out.println("Cannot add " + employee.getPosition() + "to the team.");
            return false;
        }

    }
    public void displayInfo(){
            System.out.println("Id-ul proiectului este: " + id);
            System.out.println("Numele proiectului este: " + name);
            System.out.println("Pozitiile necesare sunt: " + Arrays.toString(requiredPositions));
            System.out.println("Membrii echipei sunt:" +Arrays.toString(teamMembers));
    }

}
