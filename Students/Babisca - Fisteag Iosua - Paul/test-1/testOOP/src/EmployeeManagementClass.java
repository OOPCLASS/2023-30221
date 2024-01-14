import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class EmployeeManagementClass {
    private ArrayList<Employee> employees;
    private ArrayList<Project> projects;

    public Employee hirePerson(String personName, String position) {
        Random random = new Random();
        Employee newEmployee = new Employee(random.nextInt(0, 999), personName, position);
        employees.add(newEmployee);
        return newEmployee;
    }

    public Project createNewProject(String projName, ArrayList<String> reqPos) {
        Random random = new Random();
        return new Project(random.nextInt(0, 999), projName, reqPos, null);
    }

    public Boolean assignToProject(Integer employeeID, Integer projectID) {
        Employee hireableEmployee = null;
        for (Employee employee : employees) {
            if (Objects.equals(employee.getEmployeeID(), employeeID)) {
                hireableEmployee = employee;
                break;
            }
        }
        if (hireableEmployee == null) {
            System.out.println("The employee with employeeID " + employeeID + " does not exist");
            return false;
        }

        Project projectToBeAssigned = null;
        for (Project project : projects) {
            if (Objects.equals(projectToBeAssigned.getProjectID(), projectID)) {
                projectToBeAssigned = project;
                break;
            }
        }
        if (projectToBeAssigned == null) {
            System.out.println("The project with the projectID " + projectID + " does not exist");
            return false;
        }

        for (String position : projectToBeAssigned.getRequiredPositions()) {
            if (Objects.equals(position, hireableEmployee.getEmployeePosition())) {
                projectToBeAssigned.addTeamMember(hireableEmployee);
                return true;
            }
        }

        System.out.println("The employee is not qualified for this project\n");
        return false;
    }

    public ArrayList<Employee> searchEmployee(String name, Boolean exactMatch) {
        ArrayList<Employee> emplyeesMatch = null;
        if (exactMatch) {
            for (Employee employee : employees) {
                if (employee.getEmployeeName() == name) {
                    emplyeesMatch.add(employee);
                    return emplyeesMatch;
                }
            }
        } else {
            for (Employee employee : employees) {
                if (employee.getEmployeeName().contains(name)) {
                    emplyeesMatch.add(employee);
                }
            }
        }
        return emplyeesMatch;
    }

    public void displayAllProjects() {
        for (Project project : projects) {
            System.out.println(project);
        }
    }
}