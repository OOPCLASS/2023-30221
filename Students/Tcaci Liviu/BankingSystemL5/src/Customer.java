import java.util.ArrayList;
import java.util.List;

class Customer {
    private int customerId;
    private String name;
    private String contactInfo;
    private List<BankAccount> accounts;

    public Customer(int customerId, String name, String contactInfo) {
        this.customerId = customerId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }
}