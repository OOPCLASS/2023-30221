public class Employee {
    private static int nextId = 1;
    private int id = 0;
    private String name;
    private String position;

    public Employee() {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void displayInfo() {
        System.out.println(this.name + " " + this.id + " " + this.position);
    }
}
