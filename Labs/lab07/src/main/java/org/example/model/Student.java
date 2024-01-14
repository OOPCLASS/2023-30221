package org.example.model;

import org.example.AddressAware;
import org.example.Identifiable;

public class Student extends Person implements Identifiable, AddressAware {

  private Double grade;

  public Student(String name) {
    super(name);
  }

  public Student(Double grade) {
    super("student");
    this.grade = grade;
  }

  @Override
  public String getId() {
    return null;
  }

  @Override
  public void setId(String id) {

  }

  @Override
  public String getAddress() {
    return null;
  }

  @Override
  public void setAddress(String address) {

  }

  @Override
  public String getRole() {
    return null;
  }


  public Double getGrade() {
    return grade;
  }

  @Override
  public int compareTo(Object object) {
    // your code here
    return 0;
  }
}
