package test;

public class Employee {
    private static int counter = 0;
    private int id;
    private String name;
    private Position position;

    public Employee() {
        this.id = ++counter;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    void displayInfo(){
        System.out.println("Employee info: " + id + " " + name + " " + position);
    }
}
