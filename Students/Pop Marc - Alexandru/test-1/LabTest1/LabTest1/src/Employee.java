public class Employee {
    private int id;

    private static int currentId = 0;

    private String name;

    private String position;

    public Employee(String name, String position) {
        this.id = currentId++;
        this.name = name;
        this.position = position;
    }

    public int getId() {
        return id;
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
        System.out.println("Employee info:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);

    }
}
