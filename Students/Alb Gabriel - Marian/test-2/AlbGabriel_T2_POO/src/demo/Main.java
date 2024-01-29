package demo;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //un exemplu simplu: de creare a utilizatorilor, inregistrare, creare de proiecte, task uri, etc

        ProjectService pServ = new ProjectService();
        TaskManagementService taskM_Serv = new TaskManagementService(pServ, new ArrayList<>());

        User u1 = new User("mihai.popoescu@student.com", "Mihai Popescu", new ArrayList<>());
        User u2 = new User("dorin.ionescu@student.com", "Dorin Ionescu", new ArrayList<>());
        User u3 = new User("ioana.crisan@student.com", "Ioana Crisan", new ArrayList<>());

        taskM_Serv.registerUser(u1);
        taskM_Serv.registerUser(u2);
        taskM_Serv.registerUser(u3);

        Project p1 = pServ.create("Project A");
        Project p2 = pServ.create("Project B");
        Project p3 = pServ.create("Project C");

        // add tasks la proiecte
        taskM_Serv.createTask(u1, p1, "Task 1");
        taskM_Serv.createTask(u2, p1, "Task 2");
        taskM_Serv.createTask(u1, p2, "Task 3");
        taskM_Serv.createTask(u3, p2, "Task 4");
        taskM_Serv.createTask(u3, p3, "Task 5");

        // afișare task uri din proiecte
        System.out.println("Task urile din Project A: ");
        taskM_Serv.getTasks(p1.getId(), TaskStatus.CREATED).forEach(task -> {
            System.out.println(task.getTitle() + " - Status: " + task.getStatus());
        });

        System.out.println("\nTask urile din Project B: ");
        taskM_Serv.getTasks(p2.getId(), TaskStatus.CREATED).forEach(task -> {
            System.out.println(task.getTitle() + " - Status: " + task.getStatus());
        });

        System.out.println("\nTask urile din Proiectul C: ");
        taskM_Serv.getTasks(p3.getId(), TaskStatus.CREATED).forEach(task -> {
            System.out.println(task.getTitle() + " - Status: " + task.getStatus());
        });

        System.out.println("\n");
        System.out.println("Hello World!");

    }
}
