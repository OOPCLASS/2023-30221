import utcn.ro.*;
public class Main {
    public static void main(String[] args) {
        long id = 0;
        Customer customer1 = new Customer(++id);
        Customer customer2 = new Customer(++id);
        customer1.setName("Michael");
        customer1.setContactInformation("0743477377");
        customer2.setName("John");
        customer2.setContactInformation("0743477376");

        BankStaff staff1 = new BankStaff(++id);
        staff1.setName("Tom");
        staff1.setPosition("Advisor");

        customer1.addAccount(++id, "Checkings");
        customer1.addAccount(++id, "Savings");
        customer2.addAccount(++id, "Savings");

        staff1.manageTransaction(++id, "deposit", customer1.getAccountsList().get(1),
                null, 3000.0f);
        staff1.manageTransaction(++id, "deposit", customer2.getAccountsList().get(0),
                null, 300.0f);
        staff1.manageTransaction(++id, "withdrawal", customer2.getAccountsList().get(0),
                null, 20.0f);
        staff1.manageTransaction(++id, "deposit", customer1.getAccountsList().get(0),
                null,10000.0f);
        staff1.manageTransaction(++id, "transfer", customer1.getAccountsList().get(0),
                customer2.getAccountsList().get(0), 100.0f);

        customer1.viewBalance();
        customer2.viewBalance();
    }
}