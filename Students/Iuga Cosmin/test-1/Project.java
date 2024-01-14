import java.util.ArrayList;

public class Project {
    private int id;
    private String name;
    private String[] requierdPositions;
    private ArrayList<Employee> teamMembers;
    private static int nextId=1;

    public Project(String name,String[] requierdPositions){
        this.id=nextId;
        nextId++;
        this.name=name;
        this.requierdPositions=requierdPositions;
        this.teamMembers=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public boolean addTeamMember(Employee employee){
        for(String i: requierdPositions)
        {
            if (i.equals(employee.getPosition()))
            {
                teamMembers.add(employee);
                return true;
            }
        }
        System.out.println("Angajatul nu a putut fi adaugat!");
        return false;
    }

    public void displayInfo(){
        System.out.println("Id: "+id+
                "\nName: "+name+
                "\nRequired Positions: ");
        for(String i : requierdPositions)
        {
            System.out.println(i);
        }
        System.out.println("Team Members: \n");
        for(Employee employee : teamMembers)
            employee.displayInfo();
    }

}
