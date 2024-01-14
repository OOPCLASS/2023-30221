import java.util.Arrays;

// Employee class
class Employee {
    private static int nextId = 1;

    private int id;
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.id = nextId++;
        this.name = name;
        this.position = position;
    }


    public void displayInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
    }



}

// Project class
