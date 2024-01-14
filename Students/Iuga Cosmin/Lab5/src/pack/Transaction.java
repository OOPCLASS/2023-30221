package pack;

public class Transaction {
    private int id;
    private BankAccount source;
    private BankAccount destination;
    private String transactionType;
    private double amount;

    public Transaction(int id,BankAccount source,BankAccount destination,String transactionType,double amount)
    {
        this.id=id;
        this.source=source;
        this.destination=destination;
        this.transactionType=transactionType;
        this.amount=amount;
    }

    public void printTransation()
    {
        System.out.println("Id: " + this.id
                + "\nSursa: " + this.source.getAccountNumber()
                + "\nDestination: " + this.destination.getAccountNumber()
                + "\nType: " + this.transactionType
                + "\nAmount: "+ this.amount
        );
    }

}
