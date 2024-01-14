package lab5;

public class Main {

	public static void NewTransaction(Transaction newTransaction)
	{
	  	newTransaction.destinationAccount.transactions[newTransaction.destinationAccount.nrTransactions]=newTransaction;
	  	newTransaction.destinationAccount.nrTransactions++;
	  	newTransaction.scourceAccount.transactions[newTransaction.scourceAccount.nrTransactions]=newTransaction;
	  	newTransaction.scourceAccount.nrTransactions++;
	  	
	  	if(newTransaction.scourceAccount.balance<newTransaction.ammount) 
	  	{
	  		System.out.println("Error");
	  	}
	  	else
	  	{
	  		newTransaction.destinationAccount.balance=newTransaction.destinationAccount.balance+newTransaction.ammount;
	  		newTransaction.scourceAccount.balance=newTransaction.scourceAccount.balance-newTransaction.ammount;
	  	}
	}
	
	public static void main(String[] args) {
		Customer customer1=new Customer(1,"Marcel","email");
		customer1.CreateAccount(new BankAccount("iabbhisabd","Type"));
		customer1.bankAccounts[0].DepositMoney(1000);
		System.out.println(customer1.bankAccounts[0].balance);
		Customer customer2=new Customer(2,"Andrei","email");
		customer2.CreateAccount(new BankAccount("ibhisabd","Type"));
		NewTransaction(new Transaction(1,customer1.bankAccounts[0],customer2.bankAccounts[0],500));
		System.out.println(customer1.bankAccounts[0].balance);
		System.out.println(customer2.bankAccounts[0].balance);
		
	}
}
