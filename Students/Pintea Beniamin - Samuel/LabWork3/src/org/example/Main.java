package org.example;

public class Main {
    public static void main(String[] args) {
        Phone firstPhone = new Phone("Samsung", "01279", 8, 70, "Orange", "600");
        Phone secondPhone = new Phone("Apple", "12", 6, 30, "Vodafone", "1200");

        firstPhone.printPhoneInfo();
//        firstPhone.powerOn();
        firstPhone.tweakVolume(20, false);
        firstPhone.printPhoneInfo();
        firstPhone.setAsRepaired();

        secondPhone.printPhoneInfo();
        secondPhone.tweakVolume(89, true);
        secondPhone.printPhoneInfo();
        secondPhone.changeSimCard("Digi");
        secondPhone.setAsRepaired();
    }
}