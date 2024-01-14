package org.example;

public class Phone {
    static int commonAttribute = 0;
    boolean repaired = false;
    String imeiNumber;
    double ramMemorySizeInGb;
    String brandName;
    int volume = 0;
    int alarmHour = -1;
    int alarmMinute = -1;
    boolean alarmEnable = false;

    //constructori
    public Phone() {
        this("Valoare implicita");
        powerOn();
    }
    public Phone(String brandName) {
        this.brandName = brandName;
        this.powerOn();
    }

    //metode
    public void powerOn(){
        System.out.println("Powering on");
    }
    public void powerOff(){
        System.out.println("Powering off");
    }
    public void setAsRepaired(){
        repaired = true;
    }
    public void tweakVolume(int amount, boolean up){
        int realAmount = up ? amount : -amount;
        int newVolume = volume + realAmount;
        if ((up && newVolume < 100) || !(up && newVolume > 0))
            volume = newVolume;
    }
    public static void doSomething() {
        System.out.println();
    }
    public void playMusic(String song){
        if (repaired)
            System.out.println("Current song: " + song);
        else
            System.out.println("The phone is not repaired");
    }

    public void setAlarm(int hour, int minute){
        if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60){
            alarmHour = hour;
            alarmMinute = minute;
            alarmEnable = true;
            System.out.println("Alarm set for " + hour + ":" + minute);
        }
        else
            System.out.println("Please enter a valid hour and minute");
    }
}
