import java.util.ArrayList;
import java.util.List;

public class Project {

    private int id;
    private String name;

    public String[] requiredPositions;
    List<Employee> teamMembers = new ArrayList<Employee>();

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

    public String[] getRequiredPosition() {
        return requiredPositions;
    }

    public void setRequiredPosition(String[] requiredPositions) {
        this.requiredPositions = requiredPositions;
    }

    public boolean addTeamMember(Employee employee) {
        String employeePosition = employee.getPosition();
        for (String requiredPosition: requiredPositions) {
            if (employeePosition.equals(requiredPosition)) {
                return teamMembers.add(employee);
            }
        }
        return false;
    }

    public void displayInfo() {
        System.out.println("Displaying Project Details");
        System.out.println("Project Info:");
        System.out.println("ProjectId = " + this.getId());
        System.out.println("ProjectName = " + this.getName());
        System.out.println("Required Positions:");
        for (String position:requiredPositions) {
            System.out.println(position);
        }
        System.out.println("============================");
    }

}
