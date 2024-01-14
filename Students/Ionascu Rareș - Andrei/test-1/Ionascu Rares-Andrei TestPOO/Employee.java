public class Employee  {
    int id;
    String name;
    String position;

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


    public void getInfo(int id, String name, String position)
    {
        this.id = id;
        this.name = name;
        this.position = position;
    }
    public void displayInfo()
    {
        System.out.println("Employee ID: " + this.id + "\nName: " + this.name + "\nPosition: " + this.position + "\n");
    }


}

