public class Employee {
    private int id;
    private String name;
    private String position;
    private static int nextId=1;

    public Employee(String name,String position){
        this.id=nextId;
        nextId++;
        this.name=name;
        this.position=position;
    }

    public String getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void displayInfo(){
        System.out.println("Id: "+id+
                "\nName: "+name+
                "\nPosition: "+ position+ "\n");
    }

}
