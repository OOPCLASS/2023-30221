package lab5;

public class Customer {
	
		
		int id;
		String name;
		String contactInfo;
		BankAccount[] bankAccounts = new BankAccount[10];
        int nrAccounts=0;

public Customer(int id, String string, String string2)
{
	this.id=id;
	this.name=string;
	this.contactInfo=string2;
   
}

public void CreateAccount(BankAccount newAccount)
{
	bankAccounts[nrAccounts] = newAccount;
	nrAccounts++;
}
		
}

