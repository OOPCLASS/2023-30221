package lab5;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.setCustomerID("C1");
        c1.setName("Client 1");

        Customer c2 = new Customer();
        c2.setCustomerID("C2");
        c2.setName("Client 2");

        BankStaff b1 = new BankStaff("F762", "John Wick", "employee");
        BankStaff b2 = new BankStaff("F925", "Ana Banana", "employee");
        BankStaff b3 = new BankStaff("M872", "Snow White", "manager");

        BankAccount a1 = c1.createNewAccount("87943", "Savings account", 300);
        BankAccount a2 = c1.createNewAccount("19892", "Salary account", 2500);
        c1.accountBalance();

        c1.newTransaction(b3, "t532", a2, a1, TransactionType.TRANSFER, 3000);
        c1.newTransaction(b1, "t163", a2, null, TransactionType.WITHDRAW, 200);
        c1.newTransaction(b2, "t567", a1, null, TransactionType.DEPOSIT, 200);
        c1.accountBalance();

        BankAccount a3 = c2.createNewAccount("F421", "Company account", 50000);
        c2.newTransaction(b3, "S893", a3, a2, TransactionType.TRANSFER, 3300);
        c2.accountBalance();
        c1.accountBalance();
    }
}