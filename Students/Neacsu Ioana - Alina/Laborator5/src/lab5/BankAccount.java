package lab5;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private Customer customer;
    private String accountNumber;
    private String accountType;
    private float amount;
    private List<Transaction> transactions;

    public BankAccount(Customer customer) {
        this.customer = customer;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void updateAmount(float amount){
        this.amount += amount;
    }
}
