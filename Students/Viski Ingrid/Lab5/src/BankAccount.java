import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private int accountNumber;
    private String accountType;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public BankAccount(int accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        if (transaction.getTransactionType().equals("deposit")) {
            balance += transaction.getAmount();
        }
        else if (transaction.getTransactionType().equals("withdrawal")) {
            balance -= transaction.getAmount();
        }
        else if (transaction.getTransactionType().equals("transfer")) {
            if (transaction.getSourceAccount() != null) {
                balance -= transaction.getAmount();
            }
            if (transaction.getDestinationAccount() != null) {
                transaction.getDestinationAccount().addTransaction(new Transaction(
                        transaction.getTransactionID(), null, this, "deposit",
                        transaction.getAmount(), transaction.getStaff()));
            }
        }
    }
}
