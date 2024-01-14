import java.util.Arrays;

class Project {
    private static int nextId = 1;
    private int id;
    private String name;
    public String[] requiredPositions;
    public Employee[] teamMembers;

    public Project(String name, String[] requiredPositions) {
        this.id = nextId++;
        this.name = name;
        this.requiredPositions = requiredPositions;
        this.teamMembers = new Employee[2];
    }

    public boolean addTeamMember(Employee employee) {
        for (int i = 0; i < teamMembers.length; i++) {
            if (teamMembers[i] == null) {
                teamMembers[i] = employee;
                return true;
            }
        }

        teamMembers = Arrays.copyOf(teamMembers, teamMembers.length * 2);
        teamMembers[teamMembers.length / 2] = employee;
        return true;
    }

    public void displayInfo() {
        System.out.println("Project ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Required Positions: " + Arrays.toString(requiredPositions));
        System.out.println("Team Members: " + Arrays.toString(teamMembers));
    }
}




