///
/// URSU GEORGE
///

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Project {
    private static int uniqueID = 1;
    private int id;
    private String name;
    private String[] requiredPositions;
    private List<Employee> teamMembers;

    public Project(String name, String[] req) {
        this.id = uniqueID++;
        this.name = name;
        this.requiredPositions = req;
        this.teamMembers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean addTeamMember(Employee employee) {
        if (checkReq(employee.getPosition())) {
            teamMembers.add(employee);
            return true;
        }
        System.out.println("ERR : cannot add employee " + employee.getName() + ", max num of employees for this project reached");
        return false;
    }

    private boolean checkReq(String position) {// checks for total number of jobs and if there is a job returns true
        int cntReq = 0;
        int cntUsed = 0;

        for (String pos : requiredPositions) {
            if (pos.equals(position))
                cntReq++;
        }
        for (Employee emp : teamMembers) {
            if (emp.getPosition().equals(position))
                cntUsed++;
        }
        return cntUsed < cntReq;
    }

    public void displayInfo() {
        System.out.println("Project ID: " + this.id + " Name: " + this.name);
        System.out.println("required pos : " + Arrays.toString(requiredPositions));
        for (Employee member : teamMembers) {
            member.displayInfo();
        }
        System.out.println("--------------------------");
    }
}
