import java.util.ArrayList;
import java.util.List;

public class BankStaff {
    private int staffID;
    private String name;
    private String position;

    public BankStaff(int staffID, String name, String position) {
        this.staffID = staffID;
        this.name = name;
        this.position = position;
    }

    public void processTransaction(int transactionID, BankAccount sourceAccount, BankAccount destinationAccount,
                                   String transactionType, double amount, Customer customer) {
        Transaction transaction = new Transaction(transactionID, sourceAccount, destinationAccount, transactionType, amount, this);
        customer.makeTransactions(transactionID, sourceAccount, destinationAccount, transactionType, amount, this);
    }
}
