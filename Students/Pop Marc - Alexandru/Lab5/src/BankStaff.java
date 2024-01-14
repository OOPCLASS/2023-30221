import java.util.ArrayList;
import java.util.List;

public class BankStaff {
    private int id;

    private String name;

    private String position;

    private List<Transaction> managedTransactions = new ArrayList<Transaction>();

    public BankStaff(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public List<Transaction> getManagedTransactions() {
        return managedTransactions;
    }

    public void addManagedTransaction(Transaction transaction) {
        managedTransactions.add(transaction);
    }
}
