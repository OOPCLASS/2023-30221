import java.util.ArrayList;
import java.util.List;
public class Customer
{
    int id;
    String name;
    String contactInfo;

    List <Order> orderHistory;

    public Customer(int id,String name,String contactInfo)
    {
        this.id=id;
        this.name=name;
        this.contactInfo=contactInfo;

    }


    public String getName()
    {
        return name;
    }





    public void createOrder(Order order)
    {
        this.orderHistory= new ArrayList<>();
        orderHistory.add(order);
    }


    public void displayHistory()
    {
        System.out.println("Client's order history: ");
        for(int i = 0; i < orderHistory.size(); i++)
        {
            orderHistory.get(i).displayDetails();
        }
    }

}
