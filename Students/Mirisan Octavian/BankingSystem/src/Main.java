public class Main
{
    public static void main(String[] args)
    {
        double sum;
        Customer c1= new Customer(1,"Tommy","tommy92@yahoo.com",500);
        BankAccount acc1 = new BankAccount(1,"Savings",1000);
        BankAccount acc2 = new BankAccount(2,"Checking",400);
        c1.addBankAccount(acc1);
        c1.addBankAccount(acc2);

        c1.displayAccountDetails();

        Transaction t1= new Transaction(1,c1,acc1,acc2,"transfer");
        t1.Transfer(200);

        c1.displayAccountDetails();

        t1.setTransactionType("deposit");
        t1.Deposit(acc1,300);

        c1.displayAccountDetails();
        sum=c1.getWallet();
        System.out.println("Wallet:" +sum);

        t1.setTransactionType("withdrawl");
        t1.Withdraw(acc2,500);

        c1.displayAccountDetails();
        sum=c1.getWallet();
        System.out.println("Wallet:" +sum);
    }
}
