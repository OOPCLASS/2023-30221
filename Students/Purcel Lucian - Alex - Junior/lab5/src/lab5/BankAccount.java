package lab5;

public class BankAccount {

	String accountNumber;
	String accountType;
	double balance=0;
	Transaction[] transactions = new Transaction[50];
	int nrTransactions=0;
	public BankAccount(String string, String string2) 
	{
		this.accountNumber=string;
		this.accountType=string2;
	}
	
	public void DepositMoney(double sum)
	{
		balance=balance+sum;
	}
	
	public void WithdrawalMoney(double sum)
	{
		if(sum>balance)
		{
			System.out.println("Error");
		}
		else
		{
			balance=balance-sum;
		}
	}
	
	
	
}


