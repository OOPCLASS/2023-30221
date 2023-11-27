package demo;
import java.util.Arrays;

public class Project1 {
    private static int nextProjectId1 = 1;

    private int idProject1;
    private String nameProject1;
    private String[] requiredPositions1;
    private Employee1[] teamMembers1;
    private int teamSize1;

    public Project1(String nameProject1, String[] requiredPositions1) {
        this.idProject1 = nextProjectId1++;
        this.nameProject1 = nameProject1;
        this.requiredPositions1 = requiredPositions1;
        this.teamMembers1 = new Employee1[2]; // Initial size
        this.teamSize1 = 0;
    }

    public int getIdProject1() {
        return idProject1;
    }

    public String getNameProject1() {
        return nameProject1;
    }

    public String[] getRequiredPositions1() {
        return requiredPositions1;
    }

    public boolean addTeamMember(Employee1 employee) {
        // Check if the team member's position is required for the project
        for (String requiredPosition : requiredPositions1) {
            if (requiredPosition.equals(employee.getPosition1())) {
                // Check if there is enough space in the teamMembers array
                if (teamSize1 < teamMembers1.length) {
                    teamMembers1[teamSize1++] = employee;
                    return true;
                } else {
                    // Double the size of the array
                    teamMembers1 = Arrays.copyOf(teamMembers1, teamMembers1.length * 2);
                    teamMembers1[teamSize1++] = employee;
                    return true;
                }
            }
        }
        return false;
    }

    public void displayInfo() {
        System.out.println("Project ID: " + getIdProject1() + ", Name: " + getNameProject1());
        System.out.println("Required Positions: " + String.join(", ", getRequiredPositions1()));
        System.out.println("Team Members:");
        if (teamSize1 > 0) {
            for (int i = 0; i < teamSize1; i++) {
                teamMembers1[i].displayInfo();
            }
        } else {
            System.out.println("No team members assigned yet.");
        }
    }
}
