import java.util.ArrayList;
import java.util.Arrays;

public class Project {
    private int id;
    private String name;
    private String[] requiredPositions;
    private ArrayList<Employee> teamMembers;
    public Project(int id, String name, String[] requiredPositions){
        this.id = id;
        this.name = name;
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

    public boolean addTeamMember(Employee employee){
        if(employee != null) {
            teamMembers.add(employee);
            return true;
        }
        else return false;
    }

    public void displayInfo(){
        System.out.println("Project id: " + id);
        System.out.println("Project name: " + name);
        System.out.println("Required positions: " + Arrays.toString(requiredPositions));
        System.out.println("Team Members:");
        for (Employee employee : teamMembers) {
            if (employee != null) {
                System.out.println("-> " + employee.getName());
            }
        }
    }
}
