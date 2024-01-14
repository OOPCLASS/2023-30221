import java.util.ArrayList;

public class Customer {
    private Integer customerID;
    private String customerName;
    private String customerContact;
    ArrayList<Order> orders = new ArrayList<>();

    public Customer(Integer customerID, String customerName, String customerContact) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerContact = customerContact;
    }

    public void placeOrder(Product product) {
        Integer orderID = 0;
        for (orderID = 0; orderID < this.orders.size(); orderID++) {
        }
        orderID++;

        Order order = new Order(orderID, this, product);
        this.orders.add(order);

        product.productStock--;
    }
}
