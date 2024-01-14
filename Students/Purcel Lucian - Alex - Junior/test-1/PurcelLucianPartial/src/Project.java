
public class Project {

	private static int nextId = 0;
	private static int nrOfMembers = 0;
	private int id;
	private String name;
	private String[] requiredPosition;
	Employee[] teamMembers = new Employee[100];

	public Project(String name, String[] requiredPositions) {
		this.id = nextId++;
		this.name = name;
		this.requiredPosition = requiredPositions;
	}

	public boolean addTeamMember(Employee employee) {
		for (String test : requiredPosition) {
			if (test == employee.getPosition()) {
				teamMembers[nrOfMembers] = employee;
				nrOfMembers++;
			}
		}

		return false;
	}

	public void displayInfo() {
		System.out.println("Project ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Required Positions: ");
		for (String test : requiredPosition) {
			System.out.println(test);
		}

		System.out.println("Team Members:");

		for (int i = 0; i < nrOfMembers; i++) {
			if(teamMembers[i]!=null) {
				teamMembers[i].displayInfo();
			}
			
		}
	}

	public int getId() {
		return id;
	}

	
}
