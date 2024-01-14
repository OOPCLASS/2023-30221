import java.util.ArrayList;

public class Order {
    private Integer orderID;
    private Customer customer;
    ArrayList<Product> productsOrdered = new ArrayList<>();

    public Order(Integer orderID, Customer customer, Product product) {
        this.orderID = orderID;
        this.customer = customer;
        this.productsOrdered.add(product);
    }

    public String toString() {
        String id, customer;
        id = "order ID: " + this.orderID + "\n";
        customer = "customer name: " + this.customer.toString() + "\n";
        return id + customer + productsOrdered.toString();
    }
}