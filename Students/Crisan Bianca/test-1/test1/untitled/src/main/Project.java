package main;

public class Project {
    private static int idNext=1;
    private int id;
    private String name;
    private String[] requiredPositions;
    private Employee[] teamMembers;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getRequiredPositions() {
        return requiredPositions;
    }

    public Employee[] getTeamMembers() {
        return teamMembers;
    }

    public Project(String name, String[] requiredPositions)
    {
        this.id=idNext++;
        this.name=name;
        this.requiredPositions=requiredPositions;
        this.teamMembers=new Employee[requiredPositions.length];
    }

    public boolean addTeamMember(Employee employee)
    {
        for(int i=0;i< requiredPositions.length;i++)
        {
            if(teamMembers[i]==null && employee.getPosition().equals(requiredPositions[i]))
            {
                teamMembers[i]=employee;
                return true;
            }
        }
        return false;
    }

    public void displayInfo(){
        System.out.println("Project ID: "+id);
        System.out.println("Project name: "+name);
        System.out.println("Required positions:");
        Project project;
        for(int i=0;i< requiredPositions.length;i++) {
            System.out.println(" "+requiredPositions[i]);
        }
        System.out.println("Team members:");
        for(int i=0;i<=teamMembers.length;i++){
            if(teamMembers[i]!=null)
                System.out.println(teamMembers[i].getName());

        }

    }
}
