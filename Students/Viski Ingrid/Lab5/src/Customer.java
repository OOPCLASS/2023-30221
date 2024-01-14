import java.util.List;
import java.util.ArrayList;

public class Customer {
    private int id;
    private String name;
    private String contactInfo;
    private List<BankAccount> accounts = new ArrayList<>();

    public Customer(int id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void createAccount(int accountNumber, String accountType) {
        BankAccount account = new BankAccount(accountNumber, accountType);
        accounts.add(account);
    }

    public void makeTransactions(int transactionID, BankAccount sourceAccount, BankAccount destinationAccount,
                                 String transactionType, double amount, BankStaff staff) {
        Transaction transaction = new Transaction(transactionID, sourceAccount, destinationAccount, transactionType, amount, staff);
        sourceAccount.addTransaction(transaction);
        if (destinationAccount != null) {
            destinationAccount.addTransaction(transaction);
        }
    }

    public void viewAccountBalance() {
        for (BankAccount account : accounts) {
            System.out.println("Account owner: " + this.name);
            System.out.println("Account number: " + account.getAccountNumber());
            System.out.println("Account type: " + account.getAccountType());
            System.out.println("Balance: " + account.getBalance());
        }
    }
}
