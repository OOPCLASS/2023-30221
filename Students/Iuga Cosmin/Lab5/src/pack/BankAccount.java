package pack;

import java.util.ArrayList;

public class BankAccount {
    private String accountNumber;
    private String accountType;
    private double balance;
    private ArrayList<Transaction> transactions;
    public BankAccount(String accountNumber,String accountType,double balance)
    {
        this.accountNumber=accountNumber;
        this.accountType=accountType;
        this.balance=balance;
        this.transactions=new ArrayList<>();
    }

    public void addTransaction(Transaction transaction)
    {
        transactions.add(transaction);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void seeBalance()
    {
        System.out.println("Account: "+ this.accountNumber+"\nBalance: "+this.balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void printTransations()
    {
        for(Transaction tran: transactions)
        {
            tran.printTransation();
        }
    }
}
