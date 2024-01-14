package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.model.Person;
import org.example.model.Student;
import org.example.service.FileStorageService;
import org.example.service.StorageService;

public class Main {

  public static void main(String[] args) {
    Student student = new Student(10.0);

    System.out.println(student instanceof Student);
    System.out.println(student instanceof Person);
    System.out.println(student instanceof Identifiable);
    System.out.println(student instanceof AddressAware);


    List<Student> students = new ArrayList<>();
    students.add(student);

    Student savedStudent = students.get(0);

    StorageService storageService = new FileStorageService();

    storageService.save(student);

    storageService.load("123");


    ObjectSorter objectSorter = new ObjectSorter();
    Comparable[] myStudents = new Comparable[3];
    myStudents[0] = new Student(7.0);
    myStudents[1] = new Student(10.0);
    myStudents[2] = new Student(4.5);

    Comparable[] sortedStudents = objectSorter.sort(myStudents, false);
    for (Comparable comparable : sortedStudents) {
      System.out.println(((Student)comparable).getGrade());
    }

  }
}