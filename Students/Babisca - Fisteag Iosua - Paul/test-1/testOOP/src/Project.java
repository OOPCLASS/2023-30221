import java.util.ArrayList;

public class Project {
    private Integer projectID;
    private String projectName;
    private ArrayList<String> requiredPositions;
    private ArrayList<Employee> teamMembers;

    public Integer getProjectID() {
        return projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public ArrayList<String> getRequiredPositions() {
        return requiredPositions;
    }

    public ArrayList<Employee> getTeamMembers() {
        return teamMembers;
    }

    public Project(Integer projectID, String projectName, ArrayList<String> requiredPositions, ArrayList<Employee> teamMembers) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.requiredPositions = requiredPositions;
        this.teamMembers = teamMembers;
    }

    public Boolean addTeamMember(Employee employee) {
        for (Employee member : teamMembers) {
            if (member.getEmployeePosition() == employee.getEmployeePosition()) {
                System.out.println("Sorry, this position is already occupied.\n");
                return false;
            }
        }
        teamMembers.add(employee);
        return true;
    }

    @Override
    public String toString() {
        String id = "project id: " + projectID.toString() + "\n";
        String projName = "project name: " + projectName + "\n";
        String reqPos = "required positions: " + requiredPositions.toString() + "\n";
        StringBuilder members = new StringBuilder("team members: \n");
        for (Employee teamMember : teamMembers) {
            members.append(teamMember.toString());
        }
        System.out.println("\n");
        return id + projName + reqPos + members;
    }
}
