public class Transaction
{
    int id;
    Customer customer;
    BankAccount sourceAccount;
    BankAccount destinationAccount;
    String transactionType;
    double ammount;


    //constructor

    public Transaction(int id,Customer customer,BankAccount sourceAccount,BankAccount destinationAccount,String transactionType)
    {
        this.id=id;
        this.customer=customer;
        this.destinationAccount=destinationAccount;
        this.sourceAccount=sourceAccount;
        this.transactionType=transactionType;
    }




    public void setAmmount(double ammount)
    {
        this.ammount=ammount;
    }

    public void setTransactionType(String transactionType)
    {
        this.transactionType=transactionType;
    }



    public void Transfer(double ammount)
    {

        if(transactionType == "transfer")
        {
            if(sourceAccount.balance-ammount>=0)
            {
                destinationAccount.balance += ammount;
                sourceAccount.balance -= ammount;
            }
            else
            {
                System.out.println("Insufficient funds!");
            }
        }
        else
        {
            System.out.println("Error!");
        }
    }

    public void Withdraw(BankAccount account,double ammount)
    {
        if(transactionType == "withdrawl")
        {
            if(account.balance-ammount>=0)
            {
               customer.wallet += ammount;
               account.balance -= ammount;
            }
            else
            {
                System.out.println("Insufficient funds!");
            }
        }
        else
        {
            System.out.println("Error!");
        }
    }

    public void Deposit(BankAccount account,double ammount)
    {
        if(transactionType == "deposit")
        {
            if(customer.wallet - ammount>=0)
            {
                account.balance += ammount;
                customer.wallet -= ammount;
            }
            else
            {
                System.out.println("Insufficient funds!");
            }
        }
        else
        {
            System.out.println("Error!");
        }
    }
}
