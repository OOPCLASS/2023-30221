import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id;
    private  String name;
    //public List<String> requiredPositions=new ArrayList<String>();
    private String[] requiredPositions;
   private  List<Employee> teamMembers =new ArrayList<Employee>();
    public void addTeamMember(Employee employee){
        teamMembers.add(employee);
    }
    public void displayInfo(){
        System.out.println(id+' '+name);
    }

    public Project(String name, String[] reqPositions,int i) {
        this.name = name;
        this.requiredPositions=reqPositions;
       this. setId(i);
    }
    public void SetID(int i)
    {
        this.id=i;
    }
    public Boolean AddEmployee(Employee e)
    {
        for (String s:requiredPositions) {
            if (e.getPosition().equals(s))
            {
                teamMembers.add(e);
                return true;
            }
        }
        return false;

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
}
