///
/// URSU GEORGE
///
public class Employee {
    private static int uniqueID = 1;
    private int id;
    private String name;
    private String position;

    public Employee(String name, String pos) {
        this.id = uniqueID++;
        this.name = name;
        this.position = pos;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println("Emplyee ID: " + this.id + ",name : " + this.name + ", position : " + position);
    }
}
