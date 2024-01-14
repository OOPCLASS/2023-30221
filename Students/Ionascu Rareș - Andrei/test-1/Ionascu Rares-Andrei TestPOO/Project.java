public class Project {

    private int id;
    private String name;
    private String[] requiredPositions;
    private Employee[] teamMembers;
    private int teamSize;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getRequiredPositions() {
        return requiredPositions;
    }

    public Employee[] getTeamMembers() {
        return teamMembers;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public Project(int id, String name, String[] requiredPositions, int maxTeamSize) {
        this.id = id;
        this.name = name;
        this.requiredPositions = requiredPositions;
        this.teamMembers = new Employee[maxTeamSize];
        this.teamSize = 0;
    }

    public boolean addTeamMember(Employee employee) {
        if (teamSize < teamMembers.length && employee != null && containsRequiredPosition(employee.getPosition())) {
            teamMembers[teamSize++] = employee;
            return true;
        } else {
            return false;
        }
    }

    private boolean containsRequiredPosition(String employeePosition) {
        for (String requiredPosition : requiredPositions) {
            if (requiredPosition.equals(employeePosition)) {
                return true;
            }
        }
        return false;
    }


}