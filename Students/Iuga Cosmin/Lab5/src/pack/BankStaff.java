package pack;

import java.util.ArrayList;

public class BankStaff {
    private int id;
    private String name;
    private String position;
    private ArrayList<BankAccount> bankAccounts;
    public BankStaff(int id,String name,String position)
    {
        this.id=id;
        this.name=name;
        this.position=position;
        this.bankAccounts=new ArrayList<>();
    }
    public void addBankAccount(BankAccount bankAccount)
    {
        bankAccounts.add(bankAccount);
    }

    public String getName() {
        return name;
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
