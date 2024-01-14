public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Ingrid", "0782457145");
        Customer customer2 = new Customer(2, "Mario", "0756383472");
        Customer customer3 = new Customer(3, "Thomas", "0724274322");

        BankStaff staff1 = new BankStaff(101, "John", "Teller");
        BankStaff staff2 = new BankStaff(102, "Michael", "Financial Advisor");

        customer1.createAccount(1001, "Savings");
        customer1.createAccount(1002, "Checking");
        customer2.createAccount(1101, "Checking");
        customer2.createAccount(1102, "Savings");
        customer3.createAccount(1201, "Checking");

        staff1.processTransaction(2001, customer1.getAccounts().get(0), null, "deposit", 26000, customer1);
        staff1.processTransaction(2002, customer1.getAccounts().get(1), null, "deposit", 70000, customer1);
        staff1.processTransaction(2003, customer2.getAccounts().get(0), null, "deposit", 35000, customer2);
        staff1.processTransaction(2004, customer2.getAccounts().get(0), customer2.getAccounts().get(1), "transfer", 19500.5, customer2);
        staff2.processTransaction(2005, customer3.getAccounts().get(0), null, "deposit", 300000, customer3);
        staff1.processTransaction(2006, customer3.getAccounts().get(0), customer2.getAccounts().get(1), "transfer", 15000, customer3);

        customer1.viewAccountBalance();
        System.out.println("\n");
        customer2.viewAccountBalance();
        System.out.println("\n");
        customer3.viewAccountBalance();
    }
}