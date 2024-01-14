package org.example;

public class PhoneOld {

  static int attributeSharingValueForAllInstances;
  String imeiNumber;
  String brandName;
  double displaySize;
  int volume = 70;
  String[] contactPersonNames;

  public PhoneOld() {
    this("abc");
    displaySize = 5.5;
  }

  public PhoneOld(String imeiNumber) {
    this.imeiNumber = imeiNumber;
    this.powerOn();
  }

  public boolean powerOn() {
    System.out.println("Powering on...");
    return true;
  }

  public boolean powerOff() {
    System.out.println("Powering off...");
    MainOld.doSomething(this);
    return true;
  }

  public void tweakVolume(int amount, boolean up) {
    int realAmount = up ? amount : -amount;
    int newVolume = volume + realAmount;
    if ((up && newVolume < 100) ||
        (!up && newVolume > 0)) {
      volume = newVolume;
    }
  }
}
