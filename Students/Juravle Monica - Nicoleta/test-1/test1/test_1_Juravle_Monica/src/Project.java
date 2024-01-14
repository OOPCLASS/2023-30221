import java.sql.Array;
import java.util.ArrayList;

public class Project {
    private int id;
    public String name;
    public String[] requiredPositions;
    public Employee[] teamMembers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project(String name, String[] requiredPositions){
        this.name = name;
        this.requiredPositions = requiredPositions;
    }

    public void initializeTeamMembers(){
        this.teamMembers = new Employee[2];
    }

    public int teamMembersLength = 0;

    public void addTeamMember(Employee newTeamMember){

        boolean isPositionRequired = false;
        for (String requiredPosition : requiredPositions){
            if (newTeamMember.position.equals(requiredPosition)){
                isPositionRequired = true;
                break;
            }
        }

        int position = countPosition(newTeamMember.position);
        if (isPositionRequired == false || position >= countRequiredPosition(newTeamMember.position)){
            System.out.println("position not required or already filled for this project");
            return;
        }

        Employee[] newTeamMembers = new Employee[teamMembersLength + 1];
        System.arraycopy(teamMembers, 0, newTeamMembers, 0, teamMembersLength);
        newTeamMembers[teamMembersLength] = newTeamMember;
        teamMembers = newTeamMembers;
        teamMembersLength = teamMembersLength + 1;
    }

    private int countPosition(String position) {
        int count = 0;
        for (Employee teamMember : teamMembers) {
            if (teamMember != null && teamMember.position.equals(position)) {
                count++;
            }
        }
        return count;
    }

    private int countRequiredPosition(String position) {
        int count = 0;
        for (String requiredPosition : requiredPositions) {
            if (requiredPosition.equals(position)) {
                count++;
            }
        }
        return count;
    }

    public void printTeamMembers(){
        System.out.println("Team Members for Project: " + this.name);
        for (Employee teamMember : teamMembers) {
            if (teamMember != null) {
                teamMember.displayInfo();
                System.out.println();
            }
        }
    }

    public void displayInfo(){
        System.out.print("Id: ");
        System.out.println(this.id);

        System.out.print("Name: ");
        System.out.println(this.name);

        System.out.print("Required position: ");
        System.out.println(this.requiredPositions);

        printTeamMembers();
    }
}
