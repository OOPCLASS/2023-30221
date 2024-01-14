import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Employee {
    private static int nextid = 1;
    private int id;
    private String name;
    private String position;

    public Employee(String name, String position){
        this.id = nextid++;
        this.name = name;
        this.position = position;
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

    public void setPosition(String position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void displayInfo(){
        System.out.println("Employee id : " +id);
        System.out.println("Name : " +name);
        System.out.println("Position : " +position);
    }
}
