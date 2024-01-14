package pack;

public class Employee {
    private int id;
    private String name;
    private String  position;

     public Employee(int id, String name, String position){
         this.id = id;
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
    public void displaYInfo()
    {
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " +  name);
            System.out.println("Position: " + position);
            System.out.println();
    }
}
