package pack;

import java.util.ArrayList;

public class Customer {
    private int id;
    private String name;
    private String contact;
    private ArrayList<Order> orderHistory;

    public Customer(int id,String name,String contact)
    {
        this.id=id;
        this.name=name;
        this.contact=contact;
        orderHistory = new ArrayList<>();
    }

    public void addOrder(Order order)
    {
        orderHistory.add(order);
        order.setCustomerId(id);
    }

    public void printOrders()
    {
        System.out.println("Istoricul comenzilor clientului: " + name);
        for(Order i : orderHistory)
        {
            i.printOrder();
        }
    }

}
