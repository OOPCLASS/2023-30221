package demo;

public class Employee1 {
    private static int nextEmployeeId1 = 1;

    private int idEmployee1;
    private String nameEmployee1;
    private String position1;

    public Employee1(String nameEmployee, String position) {
        this.idEmployee1 = nextEmployeeId1++;
        this.nameEmployee1 = nameEmployee;
        this.position1 = position;
    }

    public int getIdEmployee1() {
        return idEmployee1;
    }

    public String getNameEmployee1() {
        return nameEmployee1;
    }

    public String getPosition1() {
        return position1;
    }

    public void displayInfo() {
        System.out.println("Employee ID: " +
                getIdEmployee1() + ", Name: " + getNameEmployee1() +
                ", Position: " + getPosition1());
    }
}
