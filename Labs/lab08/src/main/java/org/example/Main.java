package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.example.custom.Person;

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
  }
}