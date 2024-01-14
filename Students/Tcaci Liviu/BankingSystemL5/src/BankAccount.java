import java.util.ArrayList;
import java.util.List;

class BankAccount {
    private int accountNumber;
    private String accountType;
    private double balance;
    private List<Transaction> transactions;

    //getter & setter
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }


    public BankAccount(int accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction(this, null, "Deposit", amount));
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction(this, null, "Withdrawal", amount));
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(BankAccount destinationAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            destinationAccount.deposit(amount);
            transactions.add(new Transaction(this, destinationAccount, "Transfer", amount));
        } else {
            System.out.println("Insufficient funds for the transfer.");
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}