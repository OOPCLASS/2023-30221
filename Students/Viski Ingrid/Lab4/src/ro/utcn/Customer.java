package ro.utcn;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    public int customerId;
    public String name;
    public String contactInfo;
    public List<Order> orderHistory;

    public Customer(int customerId, String name, String contactInfo) {
        this.customerId = customerId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.orderHistory = new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void createNewOrder(Order order) {
        orderHistory.add(order);
    }

    public void displayOrderHistory() {
        System.out.println("Order history for customer: " + name);
        for (Order order : orderHistory) {
            System.out.println("Products purchased in this order:");
            System.out.println("Order ID: " + order.getOrderID());
            for (int i = 0; i < order.getProducts().size(); i++) {
                String product = order.getProducts().get(i);
                int quantity = order.getQuantities().get(i);
                System.out.println(product + " - Quantity: " + quantity);
            }
        }
    }
}
