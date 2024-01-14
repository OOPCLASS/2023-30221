package org.example;
/*
* This is a class that represents a phone
* why this is needed? to define and give behavior to a phone
* based on the idea of phone
* A CLASS IS A TYPE/BLUEPRINT FOR AN OBJECT
*/
public class Phone {
    static int commonAttribute = 10;
    boolean repaired = false;
    boolean isLocked = false;
    String imeiNumber;
    String brandName;
    String contactNumber;
    int volume;
    int batteryLevel;
    public Phone(){ //this is a constructor cuz it has no return type
        this("implicit value");
        powerOn();
    }
    public Phone(String BrandName){
        System.out.println("Phone constructor called");
        //this(); //calls the default constructor
        this.brandName = "Samsung"; // this is used to refer to the current object
        this.volume = volume;
        this.repaired = repaired;
        powerOn();
    }

    public void powerOn(){
        //execute some operation
        System.out.println("Phone is powering on");
    }
    public void powerOff(){
        //execute some operation
        System.out.println("Phone is powering off");
    }
    public void setAsRepaired(){
        System.out.println("Phone is set as repaired");
        repaired = true;
    }
    //this is a method cuz it has a return type
    public void tweakVolume(int volume, boolean up){
        System.out.println("Phone volume is set to " + volume);
        if (volume > 100 || volume < 0) {
            if (up) {
                System.out.println("Phone volume is increased");
                volume += 10;
            } else {
                System.out.println("Phone volume is decreased");
                volume -= 10;
            }
        }
    }
    //method check battery level
    public int checkBatteryLevel(int batteryLevel){
        System.out.println("Battery level is " + batteryLevel);
        if (batteryLevel > 100 || batteryLevel < 0) {
            System.out.println("out of range");
        }
        return batteryLevel;
    }
    //method lock/unlock phone
    public void lockPhone(){
        System.out.println("Phone is locked");
        isLocked = true;
    }
    public void unlockPhone(){
        System.out.println("Phone is unlocked");
        isLocked = false;
    }
}
