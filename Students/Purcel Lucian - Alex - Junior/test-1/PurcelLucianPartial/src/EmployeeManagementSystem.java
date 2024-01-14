
public class EmployeeManagementSystem {
	private static int nrOfEmployees = 0;
	private static int nrOfProjects = 0;
	private Employee[] employees = new Employee[100];
	private Project[] projects = new Project[20];

	public Employee hirePerson(String name, String position) {
		Employee employee = new Employee(name, position);
		employees[nrOfEmployees] = employee;
		nrOfEmployees++;
		return employee;
	}

	public Project createProject(String name, String[] requiredPositions) {
		Project project = new Project(name, requiredPositions);
		projects[nrOfProjects] = project;
		nrOfProjects++;
		return project;
	}

	public Employee findEmployeeId(Employee[] allEmployees, int id) {

		for (int i = 0; i < nrOfEmployees; i++) {
			if (id == allEmployees[i].getId()) {
				return allEmployees[i];
			}
		}
		return null;
	}

	public Project findProjectId(Project[] allProjects, int id) {
		for (int i = 0; i < nrOfProjects; i++) {
			if (id == allProjects[i].getId()) {
				return allProjects[i];
			}
		}
		return null;
	}

	public boolean assignToProject(int employeeId, int projectId) {
		Employee employee;
		Project project;
		employee = findEmployeeId(employees, employeeId);
		project = findProjectId(projects, projectId);

		if (employee != null && project != null) {
			return project.addTeamMember(employee);
		}

		return false;
	}

	public Employee[] searchEmployee(String name, boolean exactMatch) {
		int nrFound = 0;

		for (int i = 0; i < nrOfEmployees; i++) {
			if (name.equals(employees[i])) {
				nrFound++;
			}
		}
		Employee[] foundEmployees = new Employee[nrFound];
		nrFound = 0;
		for (int i = 0; i < nrOfEmployees; i++) {
			if (name.equals(employees[i])) {
				foundEmployees[nrFound] = employees[i];
				nrFound++;
			}

		}
		return foundEmployees;
	}
	
	public void displayAllProjects() {
        for (int i=0;i<nrOfProjects;i++) {
            projects[i].displayInfo();
            System.out.println();
        }
    }
}
