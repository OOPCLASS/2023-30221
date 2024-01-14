package pack;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class Project {
    private int id;
    private String name;
    private String[] requiredPositions;
    private ArrayList<Employee> teamMembers;
    public Project(int id, String name, String[] requiredPositions){
        this.id=id;
        this.name=name;
        this.requiredPositions=requiredPositions;
        this.teamMembers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getRequiredPositions() {
        return requiredPositions;
    }
    public boolean addTeamMember(Employee employee) {
        /*
        Arrays.asList(requiredPositions):
        Aceasta convertește un array (requiredPositions) într-o listă.
        Metoda asList din clasa Arrays este folosită pentru a crea o listă vizualizată dintr-un array.

        contains(employee.getPosition().toString()):
        Verifică dacă lista creată conține șirul returnat de employee.getPosition().toString().
        Aici, employee.getPosition().toString() ar trebui să returneze poziția curentă a angajatului sub forma unui șir de caractere.
         */
        if (Arrays.asList(requiredPositions).contains(employee.getPosition())) {
            teamMembers.add(employee);
            return true;
        }
        return false;
    }
    public void displayInfo(){
        System.out.print("Project ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("RequiredPosition:");
        for(String position: requiredPositions){
            System.out.println(position + " ");
        }
        System.out.println("Team Members:");
        for(Employee employee: teamMembers){
            if(teamMembers!=null) {
                System.out.println("- " + employee.getName() + "ID: " + employee.getId());
            }
        }
    }
}
