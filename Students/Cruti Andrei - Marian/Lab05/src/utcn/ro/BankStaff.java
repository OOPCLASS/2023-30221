package utcn.ro;

public class BankStaff {
    private Long staffId;
    private String name;
    private String position;

    public BankStaff(Long staffId) {
        this.staffId = staffId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void manageTransaction(Long transactionId,
                                String transactionType,
                                BankAccount sourceAccount,
                                BankAccount destinationAccount,
                                Float amount) {
        Transaction transaction = new Transaction(transactionId, transactionType, sourceAccount, destinationAccount,
                amount);
        sourceAccount.addTransaction(transaction);
    }
}
