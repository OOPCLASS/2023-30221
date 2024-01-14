package demo;
import java.util.ArrayList;
import java.util.List;
public class Employee {
    //Atributes
    private static int nextId=1;
    private int idEmployee;
    private String nameEmployee;
    private String position;

    //Constructor
    public Employee(String nameEmployee, String position) {
        this.idEmployee = nextId ++;
        this.nameEmployee = nameEmployee;
        this.position = position;
    }

    //Setters and getters
    public int getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
    public String getNameEmployee() {
        return nameEmployee;
    }
    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    //Methods
    public void displayInfo(){
        System.out.println("The main info. are: idEmployee= " + idEmployee + ", nameEmployee: " + nameEmployee + ", position: " + position);
    }

}
