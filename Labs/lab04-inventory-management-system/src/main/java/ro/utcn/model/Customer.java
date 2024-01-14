package ro.utcn.model;

public class Customer {

  private Long id;
  private String name;
  private String phoneNumber;
  private String address;
  private Order[] orderHistory = new Order[]{};

  public Customer(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
    Order[] newOrderHistory = new Order[orderHistory.length + 1];
    for (int index = 0; index < orderHistory.length; index++) {
      newOrderHistory[index] = orderHistory[index];
    }
    newOrderHistory[orderHistory.length] = order;
    orderHistory = newOrderHistory;
  }

  public MostBoughtProduct getMostBoughtProduct() {
    Product allTimeMostBoughtProduct = null;
    Long allTimeMostBoughtProductQuantity = 0L;
    for (Order order : orderHistory) {
      MostBoughtProduct mostBoughtProduct = order.getMostBoughtProduct();
      if (mostBoughtProduct != null) {
        Long currentQuantity = mostBoughtProduct.getQuantity();
        if (currentQuantity > allTimeMostBoughtProductQuantity) {
          allTimeMostBoughtProductQuantity = currentQuantity;
          allTimeMostBoughtProduct = mostBoughtProduct.getProduct();
        }
      }
    }
    return new MostBoughtProduct(allTimeMostBoughtProduct, allTimeMostBoughtProductQuantity);
  }

  public double getTotalPrice() {
    double totalPrice = 0.0;
    for (Order order : orderHistory) {
      totalPrice += order.getTotalPrice();
    }
    return totalPrice;
  }
}
