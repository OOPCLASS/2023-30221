public class Transaction {
    private int id;

    private BankAccount sourceAccount;

    private BankAccount destinationAccount;

    private String type;

    private int amount;

    public Transaction(int id, BankAccount sourceAccount, BankAccount destinationAccount, String type) {
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.type = type;
    }

    public Transaction(int id, BankAccount sourceAccount, BankAccount destinationAccount, String type, int amount) {
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.type = type;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public BankAccount getSourceAccount() {
        return sourceAccount;
    }

    public BankAccount getDestinationAccount() {
        return destinationAccount;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
