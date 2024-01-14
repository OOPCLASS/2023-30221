package POOlab4;

import java.util.List;
import java.util.ArrayList;

public class Order {
    private String ID;
    private Customer customer;
    private List<OrderItem> orderList;
    private int orderAmount;
    public Order() {
        this.orderList = new ArrayList<>();
    }

    public Order(Customer customer) {
        this.customer = customer;
        this.orderList = new ArrayList<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<OrderItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderItem> orderList) {
        this.orderList = orderList;
    }

    public void updateAmount(int amount){
        orderAmount += amount;
    }
    public void addProductToOrder( Product product, int quantity) {
        boolean found = false;
        if (product.getStockQuantity() >= quantity) { //checking product quantity is >= than needed quantity
            for (OrderItem item : orderList) { //searching if item is already in list
                if (item.getProduct().getProductID().equals(product.getProductID())) {
                    item.setQuantity(item.getQuantity() + quantity); //updating quantity of item in list if found
                    found = true;
                }
            }
            if(!found){ //if not already in list create new orderItem
                OrderItem newItem = new OrderItem(product, quantity);
                orderList.add(newItem); //adding new orderItem to the list
            }
            this.updateAmount(quantity); //updating order amount
            product.updateQuantity(quantity); //updating product stock
        } else {
            System.out.println("The current stock is lower than the solicited quantity. Currently in stock:" + product.getStockQuantity());
        }
    }
    public int getTotalOrderAmount() {
        return orderAmount;
    }

    public void displayOrder(){
        System.out.println("Order ID:" + ID);
        System.out.println("Customer: " + customer.getName() + " " + customer.getCustomerID());
        System.out.println("List of products:");
        for (OrderItem orderItem : orderList) {
            System.out.println(orderItem.getProduct().getName() + " Amount " + orderItem.getQuantity());
        }
        System.out.println("Total Amount: " + orderAmount + "\n");
    }
}


