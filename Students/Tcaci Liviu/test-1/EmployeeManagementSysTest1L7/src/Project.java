import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id;
    private String name;
    private String[] requiredPositions;
    private List<Employee> teamMembers;

    public Project(int id, String name, String[] requiredPositions) {
        this.id = id;
        this.name = name;
        this.requiredPositions = requiredPositions;
        this.teamMembers = new ArrayList<>();
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public boolean addTeamMember(Employee employee) {
        if (isPositionRequired(employee.getPosition())) {
            teamMembers.add(employee);
            return true;
        }
        return false;
    }

    // ProjectInfoDisplay
    public void displayInfo() {
        System.out.println("Project ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Required Positions: " + String.join(", ", requiredPositions));
        System.out.println("Team Members:");
        for (Employee teamMember : teamMembers) {
            System.out.println("  - " + teamMember.getName() + " (ID: " + teamMember.getId() + ")");
        }
        System.out.println("----------------------");
    }

    //ProjectRequiredCheck
    private boolean isPositionRequired(String position) {
        for (String requiredPosition : requiredPositions) {
            if (requiredPosition.equalsIgnoreCase(position)) {
                return true;
            }
        }
        return false;
    }
}
