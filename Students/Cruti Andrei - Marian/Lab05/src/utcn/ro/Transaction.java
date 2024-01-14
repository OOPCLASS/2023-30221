package utcn.ro;

public class Transaction {
    private Long transactionId;
    private BankAccount sourceAccount;
    private BankAccount destinationAccount;
    private String transactionType;
    private Float amount;

    public Transaction(Long transactionId,
                       String transactionType,
                       BankAccount sourceAccount,
                       BankAccount destinationAccount,
                       Float amount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.destinationAccount = destinationAccount;
        this.sourceAccount = sourceAccount;
        this.amount = amount;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public BankAccount getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(BankAccount sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public BankAccount getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(BankAccount destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
