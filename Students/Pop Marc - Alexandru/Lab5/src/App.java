public class App {
    public static void main(String[] args) throws Exception {

        BankAccount johnAccount = new BankAccount(123, "Checking");
        BankAccount jackAccount = new BankAccount(122, "Checking");

        Customer john = new Customer(0, "John");
        Customer jack = new Customer(1, "Jack");
        BankStaff staff = new BankStaff(0, "Andrew", "Junior");

        john.addBankAccount(johnAccount);
        jack.addBankAccount(jackAccount);

        johnAccount.setBalance(12);
        jackAccount.setBalance(25);

        System.out.println("Account balances before transactions:");
        System.out.println("John's Account: " + johnAccount.getBalance());
        System.out.println("Jack's Account: " + jackAccount.getBalance());

        Transaction firstTransaction = new Transaction(0, johnAccount, jackAccount, "Transfer", 10);
        johnAccount.addTransaction(firstTransaction);
        jackAccount.addTransaction(firstTransaction);
        staff.addManagedTransaction(firstTransaction);

        johnAccount.setBalance(-firstTransaction.getAmount());
        jackAccount.setBalance(firstTransaction.getAmount());

        System.out.println("Account balances after transactions:");
        System.out.println("John's Account: " + johnAccount.getBalance());
        System.out.println("Jack's Account: " + jackAccount.getBalance());
    }
}
