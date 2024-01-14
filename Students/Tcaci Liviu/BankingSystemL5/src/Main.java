public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "John Doe", "johndoe@example.com");
        BankAccount account1 = new BankAccount(1001, "Savings");
        customer1.addAccount(account1);

        // Demonstrate transactions
        account1.deposit(1000);
        account1.withdraw(500);

        Customer customer2 = new Customer(2, "Jane Smith", "janesmith@example.com");
        BankAccount account2 = new BankAccount(1002, "Checking");
        customer2.addAccount(account2);

        account1.transfer(account2, 200);

        // Display account balances and transaction history
        System.out.println("Account 1 Balance: $" + account1.getBalance());
        System.out.println("Account 1 Transaction History: " + account1.getTransactions());

        System.out.println("Account 2 Balance: $" + account2.getBalance());
        System.out.println("Account 2 Transaction History: " + account2.getTransactions());
    }
}