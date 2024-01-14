import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeManagementSystem {
    List<Employee> employees = new ArrayList<Employee>();
    List<Project> projects = new ArrayList<Project>();

    public Employee hirePerson(String name, String position, int newId) {

//        Random rand = new Random();
//        int newId;
//        boolean notFound = true;
//
//        do {
//            newId= rand.nextInt(100);
//            for (Employee employee : employees) {
//                if (newId == employee.getId()) {
//                    notFound = false;
//                }
//            }
//        }while (notFound);

        Employee newEmployee = new Employee();
        newEmployee.setId(newId);
        newEmployee.setName(name);
        newEmployee.setPosition(position);
        employees.add(newEmployee);

        return newEmployee;

    }

    public Project createProject(String name, String[] requiredPositions, int newId) {
//        Random rand = new Random();
//        int newId;
//        boolean notFound;
//
//        do {
//            notFound = true;
//            newId= rand.nextInt(100);
//            for (Project project : projects) {
//                if (newId == project.getId()) {
//                    notFound = false;
//                    break;
//                }
//            }
//        }while (notFound);
//        newId = newId + 100;
        Project newProject = new Project();
        newProject.setId(newId);
        newProject.setName(name);
        newProject.setRequiredPosition(requiredPositions);
        projects.add(newProject);
        return newProject;

    }

    public void displayAllProjects() {
        System.out.println("<<<<<Displaying all projects>>>>>>");
        for (Project project:projects) {
            project.displayInfo();
        }
    }

    public boolean assignToProject(int employeeId, int projectId) {

        /// checking if project exists
        for (Project project:projects) {
            int currentProjectId = project.getId();
            if (currentProjectId == projectId) {
                /// checking if employee exists;
                for (Employee employee: employees) {
                    int currentEmployeeId = employee.getId();
                    if (currentEmployeeId == employeeId) {
                        return project.addTeamMember(employee);
                    }
                }
            }
        }

        return false;
    }

    public List<Employee> searchEmployee(String name, boolean exactMatch) {

        List<Employee> employeesMatched = new ArrayList<Employee>();

        if (exactMatch) {

            for (Employee employee:employees) {
                String employeeName = employee.getName();
                if (employeeName.equals(name))
                    employeesMatched.add(employee);
            }

        }
        else {
            for (Employee employee:employees) {
                String employeeName = employee.getName();
                if (employeeName.contains(name))
                    employeesMatched.add(employee);
            }
        }
        return employeesMatched;
    }

}
