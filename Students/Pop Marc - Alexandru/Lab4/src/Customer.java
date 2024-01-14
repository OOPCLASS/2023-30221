import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;

    private String name;

    private String contactInformation;

    private List<Order> placedOrders = new ArrayList<Order>();

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public List<Order> getPlacedOrders() {
        return placedOrders;
    }

    public void addPlacedOrder(Order order) {
        placedOrders.add(order);
    }

    public void removePlacedOrder(Order order) {
        placedOrders.remove(order);
    }

    public String getOrderHistory() {
        StringBuilder history = new StringBuilder();

        history.append("Customer ID: " + id + "\n");
        history.append("Customer name: " + name + "\n");

        for (Order order : placedOrders) {
            history.append("Order ID: " + order.getId() + "\n");
            history.append("Order Total Amount: " + order.getOrderTotalAmount() + "\n");
        }

        return history.toString();
    }
}
