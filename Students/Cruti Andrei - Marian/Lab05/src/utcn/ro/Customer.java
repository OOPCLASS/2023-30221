package utcn.ro;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Long customerId;
    private String name;
    private String contactInformation;
    private List<BankAccount> accountsList;

    public Customer(Long customerId) {
        this.customerId = customerId;
        this.accountsList = new ArrayList<BankAccount>();
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public List<BankAccount> getAccountsList() {
        return accountsList;
    }

    public void addAccount(Long accountId, String accountType) {
        this.accountsList.add(new BankAccount(accountId, accountType));
    }

    public void closeAccount(Long accountId) {
        this.accountsList.removeIf(account -> account.getAccountId().equals(accountId));
    }

    public void viewBalance() {
        Float totalBalance = 0.0f;
        System.out.println("Account owner: " + this.name);
        for (BankAccount account : this.accountsList) {
            System.out.println("Account id: " + account.getAccountId());
            System.out.println("Account type: " + account.getAccountType());
            System.out.println("Account balance: " + account.getBalance());
            totalBalance += account.getBalance();
        }
        System.out.println("Total balance: " + totalBalance);
    }
}
