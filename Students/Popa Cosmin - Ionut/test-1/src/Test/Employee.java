package Test;

public class Employee {
    private static int nextId = 1;

    private int id;
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.id = nextId++;
        this.name = name;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void displayInfo() {
        System.out.println("Id-ul angajatului este: " + id);
        System.out.println("Numele angajatului este: " + name);
        System.out.println("Pozitia lui in firma este: " + position);
    }
}
