package org.example;

public class MainOld {

  public static void main(String[] args) {
    
    System.out.println("Hello world!");

    int a = 0;
    PhoneOld firstPhone = new PhoneOld("123");
    System.out.println("---->" + firstPhone.imeiNumber);
    PhoneOld thirdPhone = firstPhone;
    PhoneOld secondPhone = new PhoneOld();
    secondPhone.imeiNumber = "456";

    String format = String.format("firstPhone: imei: %s, volume %s", firstPhone.imeiNumber, firstPhone.volume);
    System.out.println(format);
    System.out.println("first-phone-imei: " + firstPhone.imeiNumber);
    firstPhone.tweakVolume(10, true);

    System.out.println(secondPhone.imeiNumber);
    secondPhone.tweakVolume(100, false);
    secondPhone.powerOn();

    System.out.println(PhoneOld.attributeSharingValueForAllInstances);

    firstPhone.attributeSharingValueForAllInstances = 10;
    secondPhone.attributeSharingValueForAllInstances = 20;

    System.out.println(firstPhone.attributeSharingValueForAllInstances);

    doSomething(firstPhone);
    System.out.println(firstPhone.imeiNumber);

    firstPhone.powerOff();
  }

  public static void doSomething(PhoneOld phone) {
    System.out.println("from doSomething " + phone.imeiNumber);
  }
}