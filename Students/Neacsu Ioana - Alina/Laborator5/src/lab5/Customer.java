package lab5;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerID;
    private String name;
    private String contactInfo;
    private List<BankAccount> accounts;

    public Customer() {
        this.accounts = new ArrayList<>();
    }
    public Customer(String customerID, String name, String contactInfo){
        this.name = name;
        this.customerID = customerID;
        this.contactInfo = contactInfo;
        this.accounts = new ArrayList<>();
    }
    public BankAccount createNewAccount(String accountNumber, String accountType, float amount){
        BankAccount newAcc = new BankAccount(this);
        newAcc.setAccountNumber(accountNumber);
        newAcc.setAccountType(accountType);
        newAcc.setAmount(amount);
        accounts.add(newAcc);
        return newAcc;
    }

    public void newTransaction(BankStaff staff, String transactionID, BankAccount sourceAccount, BankAccount destinationAccount, TransactionType transactionType,float amount){
        Transaction newT = new Transaction(this, staff, transactionID, sourceAccount, destinationAccount, transactionType,amount);
        if(destinationAccount == null){
            if(transactionType == TransactionType.DEPOSIT) {
                sourceAccount.updateAmount(amount);
                sourceAccount.addTransaction(newT);
            }else if(transactionType == TransactionType.WITHDRAW){
                if(sourceAccount.getAmount() >= amount){
                    sourceAccount.updateAmount(-amount);
                    sourceAccount.addTransaction(newT);
                }else {
                    System.out.println("Insufficient funds");
                    return;
                }
            }
        }else
        if (transactionType == TransactionType.TRANSFER) {
            if(sourceAccount.getAmount() >= amount) {
                destinationAccount.updateAmount(amount);
                sourceAccount.updateAmount(-amount);
                sourceAccount.addTransaction(newT);
                destinationAccount.addTransaction(newT);
            }else {
                System.out.println("Insufficient funds");
                return;
            }
        }
    }

    public void accountBalance() {
        System.out.println("Account Balances for Customer: " + customerID + " " + name);
        for (BankAccount account : accounts) {
            System.out.println("Account ID: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getAmount());
        }
    }


    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
