package utcn.ro;

public class Customer {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String address;
    private Order[] orderHistory = new Order[]{};

    public Customer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addOrder(Order order) {
        Order[] newOrderHistory = new Order[this.orderHistory.length + 1];
        for(int i = 0; i < this.orderHistory.length; i++) {
            newOrderHistory[i] = this.orderHistory[i];
        }
        newOrderHistory[this.orderHistory.length] = order;
        this.orderHistory = newOrderHistory;
    }

    public float getTotalPrice() {
        float totalPrice = 0.0f;
        for (Order order: this.orderHistory) {
            totalPrice += order.getTotalPrice();
        }
        return totalPrice;
    }
}
