package demo;
import java.util.ArrayList;
import java.util.List;
public class Project {
    // Attributes
    private static int nextId = 1;
    private int idProject;
    private String nameProject;
    private String[] requiredPositions;
    ArrayList<Employee>teamMembers;

    //Constructor
    public Project(String nameProject, String[] requiredPositions) {
        this.idProject = nextId++;
        this.nameProject = nameProject;
        this.requiredPositions = requiredPositions;
        this.teamMembers = new ArrayList<>();
    }

    //Getters and setters
    public int getIdProject() {
        return idProject;
    }
    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }
    public String getNameProject() {
        return nameProject;
    }
    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }
    public String[] getRequiredPositions() {
        return requiredPositions;
    }
    public void setRequiredPositions(String[] requiredPositions) {
        this.requiredPositions = requiredPositions;
    }
    public ArrayList<Employee> getTeamMembers() {
        return teamMembers;
    }
    public void setTeamMembers(ArrayList<Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }

    //Methods
    // Project Class

    public boolean addTeamMember(Employee e) {
        for (String requiredPosition : requiredPositions) {
           if (requiredPosition.equals(e.getPosition())) {
                teamMembers.add(e);
                return true;
           }
        }
        return false;
        }

    public void displayInfo() {
        System.out.println("idProject= " + idProject + ", nameProject: " + nameProject);
        System.out.println("requiredPositions: " + String.join(", ", requiredPositions));
        System.out.println("Team Members:");
        for (Employee teamMember : teamMembers) {
            teamMember.displayInfo();
        }
    }
}

