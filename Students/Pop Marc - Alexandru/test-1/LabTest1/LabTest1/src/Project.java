public class Project {
    private int id;

    private static int currentId = 0;

    private String name;

    private String[] requiredPositions;

    private int teamMembersSize = 2;
    private int numberOfTeamMembers = 0;

    private Employee[] teamMembers = new Employee[teamMembersSize];

    public Project(String name, String[] requiredPositions) {
        this.id = currentId++;
        this.name = name;
        this.requiredPositions = requiredPositions;
    }

    public int getId() {
        return id;
    }

    public boolean addTeamMember(Employee employee) {
        if (!isPositionAvailable(employee.getPosition())) {
            System.out.println("Position " + employee.getPosition() + " not available");
            return false;
        }

        if (numberOfTeamMembers < teamMembersSize) {
            teamMembers[numberOfTeamMembers++] = employee;
        }
        else {
            teamMembers = increaseTeamMembersSize(teamMembers, teamMembersSize);
            teamMembersSize *= 2;
            teamMembers[numberOfTeamMembers++] = employee;
        }

        return true;
    }

    public void displayInfo() {
        System.out.println("Project info:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Required positions: ");

        for (String position : requiredPositions) {
            System.out.println(position);
        }

        if (teamMembers != null) {
            System.out.println("Team members: ");

            for (Employee member : teamMembers) {
                if (member != null) {
                    member.displayInfo();
                }
            }
        }
    }

    private Employee[] increaseTeamMembersSize(Employee[] employees, int currentSize) {
        Employee[] newEmployees = new Employee[currentSize * 2];

        for (int i = 0; i < currentSize; i++) {
            newEmployees[i] = employees[i];
        }

        return newEmployees;
    }

    private boolean isPositionAvailable(String position) {
        int numberOfSearchedPosition = 0;
        int numberOfEmployeesWithSearchedPosition = 0;
        for (int i = 0; i < requiredPositions.length; i++) {
            if (requiredPositions[i] == position) {
                numberOfSearchedPosition++;
            }
        }

        if (numberOfSearchedPosition > 0) {
            for (Employee employee : teamMembers) {
                if (employee != null && employee.getPosition() == position) {
                    numberOfEmployeesWithSearchedPosition++;
                }
            }

            if (numberOfSearchedPosition > numberOfEmployeesWithSearchedPosition) {
                return true;
            }
        }

        return false;
    }
}
