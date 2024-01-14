package pack;

import java.util.ArrayList;

public class Customer {
    private int id;
    private String name;
    private String contactInfo;
    private ArrayList<BankAccount> bankAccounts;
    public Customer(int id,String name,String contactInfo)
    {
        this.id=id;
        this.name=name;
        this.contactInfo=contactInfo;
        this.bankAccounts=new ArrayList<>();
    }
    public void addBankAccount(BankAccount bankAccount)
    {
        bankAccounts.add(bankAccount);
    }

    public String getName() {
        return name;
    }

    public void makeTransaction(int id, BankAccount source, BankAccount destination, String type, double amount)
    {
        Transaction transaction = new Transaction(id,source,destination,type,amount);
        if(type.equals("Deposit"))
        {
            destination.addTransaction(transaction);
            destination.setBalance(destination.getBalance()+amount);
        }
        if (type.equals("Withdraw"))
        {
            if(source.getBalance()>=amount) {
                source.addTransaction(transaction);
                source.setBalance(source.getBalance() - amount);
            }
        }
        if (type.equals("Transfer"))
        {
            if(source.getBalance()>=amount)
            {
                source.addTransaction(transaction);
                destination.addTransaction(transaction);
                source.setBalance(source.getBalance() - amount);
                destination.setBalance(destination.getBalance() + amount);
            }
        }
    }

    public void printAccounts()
    {
        for(BankAccount acc: bankAccounts)
        {
            System.out.println("Number: " + acc.getAccountNumber()
                    + "\nType: " + acc.getAccountType()
                    + "\nBalance: " + acc.getBalance());
        }
    }
}
