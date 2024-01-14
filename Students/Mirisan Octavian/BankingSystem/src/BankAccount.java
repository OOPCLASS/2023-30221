import java.util.ArrayList;
import java.util.List;
public class BankAccount
{

    int accountNumber;
    String accountType;
    double balance;
    List<Transaction> transactionList;

    //constructor

    public BankAccount(int accountNumber,String accountType,double balance)
    {
        this.accountNumber=accountNumber;
        this.accountType=accountType;
        this.balance=balance;

        transactionList= new ArrayList<>();
    }


    //setters

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalance(double balance)
    {
        this.balance=balance;
    }


    //getters

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }


    public void displayAccount()
    {
        System.out.println("Number: "+ accountNumber);
        System.out.println("Type: "+ accountType);
        System.out.println("Balance: "+ balance);

        System.out.println();
    }
}
