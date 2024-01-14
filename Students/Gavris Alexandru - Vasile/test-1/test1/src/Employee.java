public class Employee {
    private int id;
    private String name;
    private String position;

    public void displayInfo(){
        System.out.println(id+' '+name+' '+position);
    }

    public Employee(String n,String pos,int i) {
        this.name=n;
       this.position = pos;
       setId(i);
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
}
