package org.example;

public class Main {
    public static void main(String[] args) {
        Phone firstPhone = new Phone("Samsung");
        System.out.println(firstPhone.brandName);
        firstPhone.imeiNumber = "123";
        Phone secondPhone = new Phone("Apple");
        secondPhone.imeiNumber = "456";

        System.out.println(firstPhone.imeiNumber);
        System.out.println(secondPhone.imeiNumber);

        Phone thirdPhone = new Phone();
        thirdPhone.imeiNumber = "123";
        doSomething(thirdPhone);
        System.out.println(thirdPhone.imeiNumber);

        firstPhone.setAsRepaired();
        firstPhone.playMusic("Hail to the king");
        thirdPhone.playMusic("St. James");

        thirdPhone.setAlarm(5, 50);
        secondPhone.setAlarm(24, 0);
    }
    public static void doSomething(Phone phone) {
        phone.imeiNumber = "abc";
    }
}