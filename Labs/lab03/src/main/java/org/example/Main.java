package org.example;

public class Main {

  public static void main(String[] args) {
    int a = 0;
    Phone firstPhone = new Phone("Samsung");
    System.out.println(firstPhone.brandName);
    firstPhone.imeiNumber = "123";
    Phone secondPhone = new Phone("Apple");
    secondPhone.imeiNumber = "456";

    firstPhone = secondPhone;

    System.out.println(firstPhone.imeiNumber);
    System.out.println(secondPhone.imeiNumber);

    Phone thirdPhone = new Phone();
    thirdPhone.imeiNumber = "123";
    thirdPhone = doSomething(thirdPhone);
    System.out.println(thirdPhone.imeiNumber);
  }

  public static Phone doSomething(Phone phone) {
    phone = new Phone();
    phone.imeiNumber = "abc";
    return phone;
  }
}