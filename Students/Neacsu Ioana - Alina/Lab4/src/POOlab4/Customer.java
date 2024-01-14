package POOlab4;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerID;
    private String name;
    private String contactInfo;
    private List<Order> orderHistory;

    public Customer() {
        this.orderHistory = new ArrayList<>();
    }
    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public Order createNewOrder(){
        Order newOrder = new Order(this);
        orderHistory.add(newOrder);
        return newOrder;
    }
    public void displayOrderHistory() {
        System.out.println("Order History for Customer: " + customerID + " " + name);
        for (Order order : orderHistory) {
            order.displayOrder();
        }
        if(orderHistory.isEmpty()){
            System.out.println("No order history for customer: " + customerID + " " + name);
        }
    }
}