package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import demo.custom.Person;

public class Main {
    public static void main(String[] args) {

        List<Person> list2 = new ArrayList<>();

        Set<Person> set = new HashSet<>();

        Person alex = new Person("Alex", 25);
        Person alex2 = new Person("Alex", 25);

        set.add(alex);
        set.add(alex2);

        System.out.println(set.size());
        int index = 0;
        for (Person person : set) {
            System.out.println(index++);
            System.out.println(person.getName());
        }

        // Alt exemplu(1)
        // |
        List<Person> listAngajati = new ArrayList<>();

        listAngajati.add(new Person("Mihai", 27));
        listAngajati.add(new Person("Ionel", 33));
        listAngajati.add(new Person("Dorin", 50));

        System.out.println("Informatii despre angajati: ");
        for(Person angajat : listAngajati){
            System.out.println("Nume: " + angajat.getName() + " || " + "Varsta: "+angajat.getAge());
        }
        // |

        // Alt exemplu(2)
        Set<String> listProiecte = new HashSet<>(); //LinkedHashSet -> imi pastreaza ordinea

        listProiecte.add("Proiectul nr.1");
        listProiecte.add("Proiectul nr.2");
        listProiecte.add("Proiectul nr.3");
        listProiecte.add("Proiectul nr.1");

        System.out.println("\nInformatii despre proiecte: ");
        for(String proiect : listProiecte){
            System.out.println("Numele proiect este: " + proiect);
        }

    }
}