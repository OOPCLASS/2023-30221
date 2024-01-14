package pack;

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("234","savings",3000);
        BankAccount acc2 = new BankAccount("1003","checking",1890);
        Customer cust1 = new Customer(32,"Iuga Cosmin","0548.433.643");
        cust1.addBankAccount(acc1);
        cust1.addBankAccount(acc2);
        cust1.makeTransaction(3,acc1,acc2,"Withdraw",1000);
        cust1.makeTransaction(4,acc1,acc2,"Deposit",1000);
        cust1.makeTransaction(5,acc1,acc2,"Transfer",1000);
        acc1.seeBalance();
        acc2.seeBalance();
        System.out.println("\nTranzactile contului "+ acc1.getAccountNumber());
        acc1.printTransations();
        BankStaff manager1 = new BankStaff(12,"George","manager");
        manager1.addBankAccount(acc1);
        System.out.println("\nConturile managerului: "+manager1.getName());
        manager1.printAccounts();
        System.out.println("\nConturile clientului: "+cust1.getName());
        cust1.printAccounts();

    }

}