package ro.utcn.model;

public class Order {

  public Long id;
  protected Product[] products;
  private Long[] quantities;
  private int productIndex = 0;

  private Customer customer;

  public Order() {

  }

  public Order(Customer customer) {
    products = new Product[10];
    quantities = new Long[10];
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Customer getCustomer() {
    return customer;
  }

  protected Invoice[] generateInvoice(Invoice invoice, Customer customer) {

  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
    this.customer.addOrder(this);
  }

  public void addProduct(Product product, Long quantity) {
    // if product already exists in products then increment quantity
    for (int index = 0; index < productIndex; index++) {
      Product currentProduct = products[index];
      if (currentProduct.getId().equals(product.getId())) {
        quantities[index] += quantity;
        return;
      }
    }
    if (quantity > 0 && product.getQuantity() > quantity) {
      products[productIndex] = product;
      quantities[productIndex] = quantity;
      productIndex++;
      product.setQuantity(product.getQuantity() - quantity);
    }
  }

  public double getTotalPrice() {
    double totalPrice = 0.0;
    for (int index = 0; index < productIndex; index++) {
      Product currentProduct = products[index];
      Long currentQuantity = quantities[index];
      totalPrice += currentProduct.getPrice() * currentQuantity;
    }
    return totalPrice;
  }

  public void printDetails() {
    System.out.println("Order details:");
    if (customer != null) {
      System.out.println("\tCustomer: " + customer.getName());
    } else {
      System.out.println("\tCustomer: N/A");
    }
    System.out.println("\tProducts:");
    for (int index = 0; index < productIndex; index++) {
      Product currentProduct = products[index];
      Long currentQuantity = quantities[index];
      System.out.println("\t\t" + currentProduct.getName() + " - " + currentProduct.getPrice() + " x " + currentQuantity);
    }
    System.out.println("\tTotal price: " + getTotalPrice());
  }

  public MostBoughtProduct getMostBoughtProduct() {
    if (productIndex == 0) {
      return null;
    }
    Long highestQuantity = 0L;
    Product mostBoughtProduct = null;
    for (int index = 0; index < productIndex; index++) {
      Long currentQuantity = quantities[index];
      if (currentQuantity > highestQuantity) {
        highestQuantity = currentQuantity;
        mostBoughtProduct = products[index];
      }
    }
    return new MostBoughtProduct(mostBoughtProduct, highestQuantity);
  }
}
