import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private int transactionID;
    private BankAccount sourceAccount;
    private BankAccount destinationAccount;
    private String transactionType;
    private double amount;
    private BankStaff staff;

    public Transaction(int transactionID, BankAccount sourceAccount, BankAccount destinationAccount,
                       String transactionType, double amount, BankStaff staff) {
        this.transactionID = transactionID;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.transactionType = transactionType;
        this.amount = amount;
        this.staff = staff;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public BankAccount getSourceAccount() {
        return sourceAccount;
    }

    public BankAccount getDestinationAccount() {
        return destinationAccount;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public BankStaff getStaff() {
        return staff;
    }

    public double getAmount() {
        return amount;
    }
}
