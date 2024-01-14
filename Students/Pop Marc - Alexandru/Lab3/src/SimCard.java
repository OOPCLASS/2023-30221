import java.util.ArrayList;
import java.util.List;

public class SimCard {
    
    private int number;

    private List<Contact> savedContacts = new ArrayList<Contact>();

    public SimCard(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public List<Contact> getSavedContacts() {
        return savedContacts;
    }

    public void addContact(Contact contact) {
        savedContacts.add(contact);
    }

    public void removeContact(Contact contact) {
        savedContacts.remove(contact);
    }
}
