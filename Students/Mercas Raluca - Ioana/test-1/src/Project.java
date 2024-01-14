import java.util.ArrayList;

public class Project {
    private int id;
    private String name;
    private ArrayList<String> requiredPositions;
    private ArrayList<Employee> teamMembers;

    public Project(int id, String name, ArrayList<String> requiredPositions) {
        this.id = id;
        this.name = name;
//        this.requiredPositions = new ArrayList<>();
        this.requiredPositions = requiredPositions;
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

    public ArrayList<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(ArrayList<Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }


    public boolean addTeamMember(Employee employee) {
        int found = 0;
        for(String requiredPosition: requiredPositions) {
            if(employee.getPosition().equals(requiredPosition)) {
                teamMembers.add(employee);
                found = 1;
            } else {
                System.out.println("The employee " + employee.getName() + " is not suitable for this project");
            }
        }
        if(found == 0) {
            return false;
        }
        return true;
    }

    public void displayInfo() {
        System.out.println("Information about project " + name);
        System.out.println("Id: " + id);
        System.out.println("Required positions: ");
        for(String requiredPosition: requiredPositions) {
            System.out.println(requiredPosition);
        }
        for(Employee employee : teamMembers) {
            employee.displayInfo();
        }
    }

}
