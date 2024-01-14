import java.util.ArrayList;

public class Project {
    private int id = 0;
    private static int nextId = 1;
    private String name;
    public ArrayList<String> requiredPositions = new ArrayList<String>();
    public ArrayList<Employee> teamMembers = new ArrayList<Employee>();

    public Project() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return this.id;
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

    public boolean addTeamMember(Employee employee) {
        if (employee == null) {
            System.out.println("Employee doesn't exist!");
            return false;
        }

        if (!this.requiredPositions.contains(employee.getPosition())) {
            System.out.println("Employee has a different position than the requirements!");
            return false;
        }

        for (int i = 0; i < requiredPositions.size(); i++) {
            if (this.requiredPositions.get(i).equals(employee.getPosition())) {
                this.teamMembers.add(employee);
                this.requiredPositions.remove(i);
                return true;
            }
        }

        System.out.println("Position already occupied!");
        return false;
    }

    public void displayInfo() {
        System.out.println(this.id + " " + this.name + " ");

        for (int i = 0; i < requiredPositions.size(); i++)
            System.out.println(this.requiredPositions.get(i) + " ");

        for (int i = 0; i < teamMembers.size(); i++)
            System.out.println(this.teamMembers.get(i) + " ");
    }
}
