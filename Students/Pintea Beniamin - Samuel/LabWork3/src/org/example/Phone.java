package org.example;

public class Phone {

    boolean repaired = false;
    String imeiNumber;
    double ramMemorySizeInGb;
    String brandName;
    int volume;
    String simCard;
    String priceInEuro;


    public Phone(String brandName, String imeiNumber, double ramMemorySizeInGb, int volume, String simCard, String priceInEuro) {
        this.brandName = brandName;
        this.imeiNumber = imeiNumber;
        this.ramMemorySizeInGb = ramMemorySizeInGb;
        this.volume = volume;
        this.simCard = simCard;
        this.priceInEuro = priceInEuro;
    }

    public void printPhoneInfo() {
        System.out.println(brandName);
        System.out.println(imeiNumber);
        System.out.println(ramMemorySizeInGb);
        System.out.println(volume);
        System.out.println(simCard);
        System.out.println(priceInEuro);

        if (!repaired)
            System.out.println("Phone not repaired");
        else
            System.out.println("No work needed");
    }
    public void powerOn() {
        System.out.println("Power ON");
    }
    public void powerOff() {
        System.out.println("Power OFF");
    }
    public void setAsRepaired() {
        repaired = true;
        System.out.println("Repair successful");
    }
    public void changeSimCard(String simCard) {
        this.simCard = simCard;
        System.out.println("Sim Card changed successfully");
    }

    public void tweakVolume(int amount, boolean up) {

        if (up) {
            if (volume + amount > 100) {
                volume = 100;
            }
            else {
                volume = volume + amount;
            }
        }
        else if(!up) {
            if (volume - amount < 0) {
                volume = 0;
            }
            else {
                volume = volume - amount;
            }
        }
    }

}
