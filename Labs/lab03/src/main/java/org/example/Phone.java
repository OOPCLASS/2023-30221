package org.example;

public class Phone {

  static int commonAttribute = 0;
  boolean repaired = false;
  String imeiNumber = "hello";
  String brandName;
  double ramMemorySizeInGb;
  int volume = 0;

  public Phone() {
    this("Valoare implicita");
    powerOn();
  }

  public Phone(String brandName) {
    this.brandName = brandName;
    this.powerOn();
  }

  public void powerOn() {
    System.out.println("Powering on");
  }

  public void powerOff() {
    System.out.println("Powering off");
  }

  public void doSomething(Phone phone) {
    System.out.println(phone.imeiNumber);
  }

  public void tweakVolume(int amount, boolean up) {
    int realAmount = up ? amount : -amount;
    int newVolume = volume + realAmount;
    if ((up && newVolume < 100) ||
        (!up && newVolume > 0)) {
      volume = newVolume;
    }
  }

  public void setAsRepaired() {
    repaired = true;
  }
}
