import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Project {
    private static int nextid = 1;
    private int id;
    private String name;
    private String[] requiredPositions;
    private List<Employee> teamMembers;

    public Project(String name, String[] requiredPositions){
        this.id = nextid++;
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

    public void setName(String name) {
        this.name = name;
    }

    public String[] getRequiredPositions() {
        return requiredPositions;
    }

    public String getName() {
        return name;
    }

    public static int getNextid() {
        return nextid;
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public static void setNextid(int nextid) {
        Project.nextid = nextid;
    }

    public void setRequiredPositions(String[] requiredPositions) {
        this.requiredPositions = requiredPositions;
    }

    public void setTeamMembers(List<Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public boolean addTeamMember(Employee employee){
        if(Arrays.asList(requiredPositions).contains(employee.getPosition())){
            teamMembers.add(employee);
            return true;
        }
        return false;
    }


    public void displayInfo(){
        System.out.println("Project id : "+id);
        System.out.println("Name : "+name);
        System.out.println("Required Positions : "+Arrays.toString(requiredPositions));
        System.out.println("Team Members : ");
        for (Employee member : teamMembers){
            member.displayInfo();
        }
    }
}
