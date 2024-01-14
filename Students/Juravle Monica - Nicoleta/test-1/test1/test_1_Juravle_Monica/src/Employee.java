public class Employee {
    private int id;
    public String name;
    public String position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(String name, String position){
        this.name = name;
        this.position = position;
    }

    public void displayInfo(){
        System.out.print("Id: ");
        System.out.println(this.id);

        System.out.print("Name: ");
        System.out.println(this.name);

        System.out.print("Position: ");
        System.out.println(this.position);
    }
}
