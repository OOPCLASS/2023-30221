package lab5;

public class Transaction {
    private Customer customer;
    private BankStaff staff;
    private String transactionID;
    private BankAccount sourceAccount;
    private BankAccount destinationAccount;
    private TransactionType transactionType;
    private float amount;

    public Transaction(Customer customer, BankStaff staff, String transactionID, BankAccount sourceAccount, BankAccount destinationAccount, TransactionType transactionType,float amount) {
        this.customer = customer;
        this.staff = staff;
        this.transactionID = transactionID;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.transactionType = transactionType;
        this.amount = amount;
    }
}
