package ro.utcn.outside;

import ro.utcn.Person;

public class Company {

  public Company() {
    System.out.println("Company constructor");
    Person person = Person.getInstance();
    System.out.println(person.getAge());
  }
}
