import java.util.Random;

public class EmployeeManagementSystem {
    public Employee[] employees;
    public Project[] projects;

    public void initializeEmployees(){
        this.employees = new Employee[2];
    }

    public void initializeProjects(){
        this.projects = new Project[2];
    }

    public int employeesLength = 0;
    public int projectsLength = 0;

    public Employee hirePerson(String name, String position){
        Employee newEmployee = new Employee(name, position);

        Random random = new Random();
        newEmployee.setId(random.nextInt());

        Employee[] newEmployees = new Employee[employeesLength + 1];
        System.arraycopy(employees, 0, newEmployees, 0, employeesLength);
        newEmployees[employeesLength] = newEmployee;
        employees = newEmployees;
        employeesLength++;

        return newEmployee;
    }

    public Project createProject(String name, String[] requiredPositions){
        Project newProject = new Project(name, requiredPositions);

        Project[] newProjects = new Project[projectsLength + 1];
        System.arraycopy(projects, 0, newProjects, 0, projectsLength);
        newProjects[projectsLength] = newProject;
        projects = newProjects;
        projectsLength++;

        return newProject;
    }

    public boolean assignToProject(int employeeId, int projectId){
        Employee employee = findEmployeeById(employeeId);
        Project project = findProjectById(projectId);

        if (employee != null && project != null){
            project.addTeamMember(employee);
            System.out.println(employee.name + " assigned to project " + project.name);
            return true;
        }
        else {
            System.out.println("Employee or project not found.");
            return false;
        }
    }

    private Employee findEmployeeById(int employeeId){
        for (Employee employee : employees){
            if (employee != null && employee.getId() == employeeId)
                return employee;
        }
        return null;
    }

    private Project findProjectById(int projectId){
        for (Project project : projects)
            if (project != null && project.getId() == projectId)
                return project;
        return null;
    }

    public Employee[] searchEmployee(String name, boolean exactMatch){
        Employee[] sameEmployees = new Employee[employeesLength];
        int count = 0;

        for (Employee employee : employees){
            if (employee != null){
                String employeeName = employee.name;

                if (exactMatch == true && employeeName.equals(name))
                    sameEmployees[count++] = employee;
            }
        }
        Employee[] result = new Employee[count];
        System.arraycopy(sameEmployees, 0, result, 0, count);

        return result;
    }

    public void displayAllProjects(){
        for (Project project : projects)
            project.displayInfo();
    }
}
