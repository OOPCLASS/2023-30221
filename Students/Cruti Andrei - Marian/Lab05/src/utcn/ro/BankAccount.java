package utcn.ro;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private Long accountId;
    private String accountType;
    private Float balance;
    private List<Transaction> transactionsList;

    public BankAccount(Long accountId, String accountType) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.transactionsList = new ArrayList<Transaction>();
        this.balance = 0.0f;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
        this.transactionsList.add(transaction);
        if ("deposit".equals(transaction.getTransactionType())) {
            this.balance += transaction.getAmount();
        } else if ("withdrawal".equals(transaction.getTransactionType())) {
            this.balance -= transaction.getAmount();
        } else if ("transfer".equals(transaction.getTransactionType())) {
            if (transaction.getSourceAccount() != null) {
                this.balance -= transaction.getAmount();
            }
            if (transaction.getDestinationAccount() != null) {
                transaction.getDestinationAccount().addTransaction(new Transaction(transaction.getTransactionId(),
                        "deposit", this, transaction.getSourceAccount(),
                        transaction.getAmount()));
            }
        }
    }
}
