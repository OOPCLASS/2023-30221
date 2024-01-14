package test_noiembrie2023;

public class Employee {

    private static int idIndex = 1;
    private int id;
    private String name;
    private String position;

    public Employee() {
        this.id = idIndex++;
        this.name = "Unknown";
        this.position = "Unknown";
    }
    public Employee(String name, String position) {
        this.id = idIndex++;
        this.name = name;
        this.position = position;
    }

    public String toString() {
        String s = "Id:" + this.id + " Name:" + this.name + " Position:" + this.position + "\n";
        return s;
    }

    public void displayInfo() {
        System.out.println(this.toString());
    }

    public int getId() {
        return id;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
