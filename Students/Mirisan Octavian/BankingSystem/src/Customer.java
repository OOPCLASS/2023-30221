import java.util.ArrayList;
import java.util.List;
public class Customer
{
    int id;
    String name;
    String contactInfo;
    List<BankAccount> bankAccountList;
    double wallet;


    //constructor
    public Customer(int id,String name, String contactInfo,double wallet)
    {
        this.id=id;
        this.name=name;
        this.contactInfo=contactInfo;
        bankAccountList= new ArrayList<>();
        this.wallet=wallet;

    }

    //setters
    public void setName(String newName)
    {
       name=newName;
    }
    public void setContactInfo(String newContactInfo)
    {
        contactInfo=newContactInfo;
    }


    //getters
    public String getName()
    {
        return name;
    }

    public String getContactInfo()
    {
        return contactInfo;
    }

    public double getWallet()
    {
        return wallet;
    }

    public void addBankAccount(BankAccount newAccount)
    {
        bankAccountList.add(newAccount);
    }

    public void displayAccountDetails()
    {
        for(int i=0;i<bankAccountList.size();i++)
        {
            bankAccountList.get(i).displayAccount();
        }

    }
}
