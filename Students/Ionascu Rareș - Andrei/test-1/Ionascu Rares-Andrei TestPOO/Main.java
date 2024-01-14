
public class Main {
    public static void main(String[] args) {
        Employee manager = new Employee();
        manager.getInfo(1, "Jane", "Developer");
        manager.displayInfo();

        Employee developer1 = new Employee();
        developer1.getInfo(2, "Jane Smith", "Developer");

        Employee developer2 = new Employee();
        developer2.getInfo(3, "Bob Johnson", "Developer");

        String[] requiredPositions = {"Developer"};

        Project project = new Project(1, "Project A", requiredPositions, 3);

        boolean addedManager = project.addTeamMember(manager);
        boolean addedDeveloper1 = project.addTeamMember(developer1);
        boolean addedDeveloper2 = project.addTeamMember(developer2);

        System.out.println("Project Information:");
        System.out.println("Project ID: " + project.getId());
        System.out.println("Project Name: " + project.getName());
        System.out.println("Required Positions: " + arrayToString(project.getRequiredPositions()));
        System.out.println("Team Size: " + project.getTeamSize());

        System.out.println("Team Members:");
        for (int i = 0; i < project.getTeamSize(); i++) {
            Employee teamMember = project.getTeamMembers()[i];
            System.out.println(" - " + teamMember.getName() + " (" + teamMember.getPosition() + ")");
        }

        System.out.println("\nAdded Manager to Project: " + addedManager);
        System.out.println("Added Developer 1 to Project: " + addedDeveloper1);
        System.out.println("Added Developer 2 to Project: " + addedDeveloper2);
    }

    private static String arrayToString(String[] array) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }



}
