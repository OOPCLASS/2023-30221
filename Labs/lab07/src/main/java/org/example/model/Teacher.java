package org.example.model;

public class Teacher extends Person {

  private int numberOfStudents;

  public Teacher(String name) {
    super(name);
  }

  @Override
  public String getRole() {
    return "teacher";
  }

  @Override
  public int compareTo(Object object) {
    // your code here
    return 0;
  }
}
