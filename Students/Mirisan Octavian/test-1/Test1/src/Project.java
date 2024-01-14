import java.util.ArrayList;
import java.util.List;

public class Project
{
    int id;
    String name;

    String[] requiredPositions;

    List<Employee> teamMembers;

    public Project(int id, String name, String[] requiredPositions) {
        this.id = id;
        this.name = name;
        this.requiredPositions = requiredPositions;

        this.teamMembers= new ArrayList<>();
    }

    public boolean addTeamMember(Employee newEmployee)
    {
        int nrOfProjectManagers =0;
        int nrOfDevelopers =0;

        for(int i=0;i< teamMembers.size();i++)
        {
            if(teamMembers.get(i).position.equals("Developer"))
            {
                nrOfDevelopers++;
            }
            else
            {
                nrOfProjectManagers++;
            }
        }

        int nrOfProjectManagersRequierements=0;
        int nrOfDevelopersRequierments=0;

        for(int i=0;i<requiredPositions.length;i++)
        {
            if(requiredPositions[i].equals("Developer"))
            {
                nrOfDevelopersRequierments++;
            }
            else
            {
                nrOfProjectManagersRequierements++;
            }
        }

        if(newEmployee.position.equals("Developer"))
        {
            if(nrOfDevelopers<nrOfDevelopersRequierments)
            {
                return teamMembers.add(newEmployee);
            }
            else
            {
                System.out.println("The maximum number of developers has been already reached!");
                return false;
            }
        }
        else
        {
            if(nrOfProjectManagers<nrOfProjectManagersRequierements)
            {
                return teamMembers.add(newEmployee);

            }
            else
            {
                System.out.println("The maximum number of project managers has been already reached!");
                return false;
            }
        }
    }

    public void displayInfo()
    {
        System.out.println("Project ID: " + id);
        System.out.println("Project Name: " + name);
        System.out.println("Project required positions: ");

        for(int i=0;i<requiredPositions.length;i++)
        {
            System.out.print(requiredPositions[i] + ", ");
        }
        System.out.println();

        System.out.println("Project team members: ");

        for(int i=0;i< teamMembers.size();i++)
        {
            System.out.print(teamMembers.get(i).name + ", ");
        }
        System.out.println();
    }


}
