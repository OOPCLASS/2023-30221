import java.util.ArrayList;
import java.util.List;
public class Customer {
    private int ID;
    private String name;
    public List<Order> orderH;

    public Customer(int ID, String name){
        this.ID = ID;
        this.name= name;
        this.orderH=new ArrayList<>();
    }
    public String getName(){
        return this.name;
    }
    public Order createNewOrder( int ID){
        Order newOrder = new Order(ID,this);
        orderH.add(newOrder);
        return newOrder;
    }
    public void printOrderHistory(){
        System.out.println("ID :" + ID + " "+ this.name);
        System.out.println("Order history:");
        for(Order order: orderH){
            order.displayOrderDetails();
        }
    }

}
