package ro.utcn;

import ro.utcn.outside.Company;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");

    Person person = Person.getInstance();
    person.setAge(10);
    System.out.println(person.getName());

    new Company();
  }
}