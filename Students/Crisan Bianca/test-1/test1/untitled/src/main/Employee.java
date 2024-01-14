package main;

public class Employee {
    private static int idNext=1;
    private int id;
    private String name;
    private String position;

    public Employee(String name,String position)
    {
        this.id=idNext++;
        this.name=name;
        this.position=position;
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

    public void displayInfo()
    {
        System.out.println("id: "+id);
        System.out.println("Name: "+ name);
        System.out.println("Position: "+position);
    }
}
