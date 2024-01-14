import java.util.ArrayList;
public class Project {
    private int id;
    private String name;
    private String[] requiredPosition;
    private ArrayList<Employee> teamMembers;

    public Project() {
        this.teamMembers = new ArrayList<>();
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

    public String[] getRequiredPosition() {
        return requiredPosition;
    }

    public void setRequiredPosition(String[] requiredPosition) {
        this.requiredPosition = requiredPosition;
    }

    public ArrayList<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(ArrayList<Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }

    private int getRequiredPositionCount(Employee.Position position) {
        int count = 0;
        for (String requiredPosition : requiredPosition) {
            if (requiredPosition.equalsIgnoreCase(position.toString())) {
                count++;
            }
        }
        return count;
    }

    public boolean addTeamMember(Employee employee) {
        boolean positionRequired = false;
        for (String requiredPosition : requiredPosition) {
            if (requiredPosition.equalsIgnoreCase(employee.getPosition().toString())) {
                positionRequired = true;
                break;
            }
        }
        if (!positionRequired) {
            System.out.println("This project does not require the " + employee.getPosition() + " position.");
            return false;
        }
        int positionCount = 0;
        for (Employee teamMember : teamMembers) {
            if (teamMember.getPosition().equals(employee.getPosition())) {
                positionCount++;
            }
        }
        if (positionCount >= getRequiredPositionCount(employee.getPosition())) {
            System.out.println("Maximum number of employees reached.");
            return false;
        }
        teamMembers.add(employee);
        System.out.println("Employee added.");
        return true;
    }

    public void displayInfo() {
        System.out.println("Project ID: " + id);
        System.out.println("Project Name: " + name);
        System.out.println("Required positions: ");
        for (String position : requiredPosition) {
            System.out.println("- " + position);
        }
        System.out.println("Team Members: ");
        for (Employee teamMember : teamMembers) {
            teamMember.displayInfo();
        }
    }
}
