import java.util.List;

public class Phone {

    String imeiNumber;

    String brandName;

    double displaySize;

    int volume = 0;

    String[] contactPersonNames;

    SimCard simCard;

    public Phone() {
        
    }

    public Phone(String imeiNumber) {
        this.imeiNumber = imeiNumber;
    }

    public Phone(String imeiNumber, int simCardNumber) {
        this.imeiNumber = imeiNumber;
        simCard = new SimCard(simCardNumber);
    }

    public boolean powerOn() {
        System.out.println("Powering on...");
        return true;
    }

    
    public boolean powerOff() {
        System.out.println("Powering off...");
        return true;
    }

    public void tweakVolume(int amount, boolean up) /*throws Exception*/ {
        if (up == true) {
            if (volume + amount > 100) {
                // throw new Exception("Amount too high");
                return;
            }
            else {
                volume += amount;
            }
        }
        else {
            if (volume - amount < 0) {
                return;
            }
            else {
                volume -= amount;
            }
        }
    }

    public void addSimCardContact(Contact contact) {
        simCard.addContact(contact);
    }

    public void removeSimCardContact(Contact contact) {
        simCard.removeContact(contact);
    }

    public List<Contact> getSimCardContacts() {
        return simCard.getSavedContacts();
    }
}
