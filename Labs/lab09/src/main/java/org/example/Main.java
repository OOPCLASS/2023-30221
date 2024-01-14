package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  /**
   * Create 2 types of exceptions: checked and unchecked (e.g. PersonNotValidException, AddressNotFoundException Modify PersonValidator.valid() to throw
   * PersonNotValidException or AddressNotValidException, AddressNotFoundException
   *
   * @param args
   */
  public static void main(String[] args) {

    Person person = new Person();
//    person.setAddress(new Address());

    if (person.getAddress() != null) {
      NullPointerException addressIsNullException = new NullPointerException("Address is null");
      throw addressIsNullException;
    }

    try {
      readFromFile("abc");
    } catch (IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      throw new RuntimeException(e);
    }

    System.out.println(getNumber());
  }

  private static int getNumber() {
    try {
      throw new Exception();
    } catch (Exception e) {
      System.out.println("Exception");
      return 2;
    } finally {
      return 3;
    }
  }

  private static void readFromFile(String filePath) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;

      // Read each line from the file until the end is reached
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}