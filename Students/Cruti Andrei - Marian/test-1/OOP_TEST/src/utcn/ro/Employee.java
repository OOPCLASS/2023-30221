package utcn.ro;

public class Employee {
    private Integer employeeId;
    private String name;
    private String position;

    public Employee(Integer employeeId, String name, String position) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + this.getEmployeeId());
        System.out.println("Employee Name: " + this.getName());
        System.out.println("Position: " + this.getPosition());
    }
}
