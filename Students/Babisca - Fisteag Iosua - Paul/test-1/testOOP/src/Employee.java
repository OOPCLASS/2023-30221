public class Employee {
    private Integer employeeID;
    private String employeeName;
    private String employeePosition;

    public Integer getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public Employee(Integer employeeID, String employeeName, String employeePosition) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
    }

    @Override
    public String toString() {
        String id = "employee id: " + employeeID.toString() + "\n";
        String name = "employee name: " + employeeName + "\n";
        String position = "employee position: " + employeePosition + "\n";

        return id + name + position;
    }
}
