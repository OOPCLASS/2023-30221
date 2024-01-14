import java.util.ArrayList;

public class Customer {
    private String customerID;
    private String name;
    private String contactInfo;
    ArrayList<Order> historyOfOrders = new ArrayList<Order>();

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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void addOrderToHistory(Order order) {
        this.historyOfOrders.add(order);
    }
}
