package EmployeeManager;

public class Employee {
    private int id;
    private String name;
    private String position;

    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public void displayInfo(){
        System.out.println("EmployeeManager.Employee id:" + id);
        System.out.println("EmployeeManager.Employee name:" + name);
        System.out.println("EmployeeManager.Employee position:" + position);
    }

    public String getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
