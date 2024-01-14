import java.util.List;
import java.util.ArrayList;

public class Customer {
    //attributes
    private int customerId;
    private String customerName;
    private String customerContactInfo; //contact information
    private List<Order> orders; //history of orders placed

    //constructor
    public Customer(int customerId, String customerName, String customerContactInfo) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerContactInfo = customerContactInfo;
        this.orders = new ArrayList<>();
    }
    //setter and getters
    public int getCustomerId() {
        return customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getCustomerContactInfo() {
        return customerContactInfo;
    }
    public List<Order> getOrders() {
        return orders;
    }

    public Order createOrder(int orderId) {
        // Create a new order for the customer with the provided order ID
        Order newOrder = new Order(orderId, this);

        // Add the new order to the customer's order history
        orders.add(newOrder);

        return newOrder;
    }
    //display customer details
    public void displayCustomerDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer Contact Info: " + customerContactInfo);
    }

    //Display the customer's order history
    public void displayOrderHistory() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer Contact Info: " + customerContactInfo);

        System.out.println("Order History:");
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }


}