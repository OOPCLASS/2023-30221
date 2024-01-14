package utcn.ro;

import jdk.jfr.Description;

import java.util.Date;

public class Phone {
    String imeiNumber;
    String brandName;
    int volume;
    boolean repaired;
    Date date;

    public Phone() {
        this.imeiNumber = null;
        this.brandName = null;
        this.volume = 0;
        this.date = new Date();
        this.powerOn();
    }

    public Phone(String imeiNumber) {
        this();
        this.imeiNumber = imeiNumber;
    }

    public Phone(String imeiNumber, String brandName, boolean repaired) {
        this();
        this.imeiNumber = imeiNumber;
        this.brandName = brandName;
        this.repaired = repaired;
    }

    public void powerOn() {
        System.out.println("Powering on.");
    }

    public void powerOff() {
        System.out.println("Powering off.");
    }

    public void setRepairStatus(boolean repaired) {
        this.repaired = repaired;
    }

    public void getRepairStatus() {
        System.out.println("This device is " + (this.repaired ? "repaired" : "broken"));
    }

    public void tweakVolume(int amount, boolean up) {
        this.volume += up ? amount : -amount;
        if (this.volume > 100)
            this.volume = 100;
        if (this.volume < 0)
            this.volume = 0;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setDate() {
        this.date = new Date();
    }

    public String getDate() {
        return this.date.toString();
    }

    @Override
    @Description("Returns the values of PHONE object in multiline STRING")
    public String toString() {
        return "IMEI: " + this.imeiNumber + "\nBrand: " + this.brandName + "\nVolume: "
                + this.volume + "\nStatus: " + (this.repaired ? "repaired" : "broken") + "\nDate: " + this.date.toString();
    }
}
