package lab5;

public class Transaction {
	
   int transactionId;
   BankAccount scourceAccount;
   BankAccount destinationAccount;
   char transationType;
   double ammount;
   BankStaff bankStaff;
   
   public Transaction(int transactionId, BankAccount scourceAccount,BankAccount destinationAccount ,double ammount)
   {
	  this.transactionId=transactionId;
	   this.scourceAccount=scourceAccount;
	   this.destinationAccount=destinationAccount;
	   this.ammount=ammount;
	  
   }
   
}
