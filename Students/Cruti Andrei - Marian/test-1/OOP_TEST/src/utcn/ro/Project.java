package utcn.ro;


public class Project {
    private Integer projectId;
    private String name;
    private String[] requiredPositions;
    private Employee[] teamMembers;

    public Project(Integer projectId, String name, String[] requiredPositions) {
        this.projectId = projectId;
        this.name = name;
        this.requiredPositions = requiredPositions;
        this.teamMembers = new Employee[0];
    }

    public Integer getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getRequiredPositions() {
        return requiredPositions;
    }

    public void setRequiredPositions(String[] requiredPositions) {
        this.requiredPositions = requiredPositions;
    }

    public Employee[] getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Employee[] teamMembers) {
        this.teamMembers = teamMembers;
    }

    public void addTeamMember(Employee employee) {
        Employee[] newTeamMembers = new Employee[this.teamMembers.length + 1];
        for (int i = 0; i < this.teamMembers.length; i++) {
            newTeamMembers[i] = this.teamMembers[i];
        }
        newTeamMembers[this.teamMembers.length] = employee;
        this.teamMembers = newTeamMembers;
    }

    public void displayInfo() {
        System.out.println("Project ID: " + this.getProjectId());
        System.out.println("Project Name: " + this.name);
        System.out.println("Required positions: ");
        for (int i = 0; i < this.requiredPositions.length; i++) {
            System.out.println("\t" + this.requiredPositions[i]);
        }
        System.out.println("Team Members: ");
        for (int i = 0; i < this.teamMembers.length; i++) {
            this.teamMembers[i].displayInfo();
        }
    }
}
