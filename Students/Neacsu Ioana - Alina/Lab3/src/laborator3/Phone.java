package laborator3;

import javax.lang.model.element.NestingKind;

public class Phone {
    static int commonAttribute;
    boolean repaired = false;
    String imeiNumber;
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

    public void tweakVolume(int amount, boolean up) {
        int realAmount = up ? amount : -amount;
        int newVolume = volume + realAmount;
        if ((up && newVolume < 100) || (!up && newVolume > 0)) {
            volume = newVolume;
        }
    }

    public void setAsRepaired() {
        repaired = true;
    }
}