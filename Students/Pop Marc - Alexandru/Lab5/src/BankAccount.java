import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private int accountNumber;

    private String accountType;

    private int balance;

    private List<Transaction> transactions = new ArrayList<Transaction>();

    public BankAccount(int accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        balance = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int amount) {
        balance += amount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }
}
