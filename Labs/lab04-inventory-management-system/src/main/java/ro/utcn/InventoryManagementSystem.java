package ro.utcn;

import ro.utcn.model.Customer;
import ro.utcn.model.MostBoughtProduct;
import ro.utcn.model.Order;
import ro.utcn.model.Product;

public class InventoryManagementSystem {

  private static Long nextId = 0L;
  private Customer[] customers = new Customer[10];
  private int customersIndex = 0;
  private Product[] products = new Product[10];
  private int productsIndex = 0;

  public void simulate() {
    createProducts();
    createCustomers();

    printStock();

    Order order = new Order(getNextId());
    order.addProduct(products[0], 2L);
    order.addProduct(products[1], 5L);
    order.addProduct(products[1], 2L);
    order.setCustomer(customers[0]);
    order.printDetails();

    order = new Order(getNextId());
    order.addProduct(products[2], 3L);
    order.addProduct(products[1], 1L);
    order.setCustomer(customers[0]);
    order.printDetails();

    MostBoughtProduct mostBoughtProduct = customers[0].getMostBoughtProduct();
    System.out.println("Most bought product by " + customers[0].getName() + ": " + mostBoughtProduct.getProduct().getName() + " (" + mostBoughtProduct.getQuantity() + " times)");

    printStock();
  }

  private void createProducts() {
    Product firstProduct = new Product(getNextId());
    firstProduct.setName("Laptop");
    firstProduct.setPrice(2000.0);
    firstProduct.setQuantity(10L);
    products[productsIndex++] = firstProduct;

    Product secondProduct = new Product(getNextId());
    secondProduct.setName("Telefon");
    secondProduct.setPrice(1500.0);
    secondProduct.setQuantity(17L);
    products[productsIndex++] = secondProduct;

    Product thirdProduct = new Product(getNextId());
    thirdProduct.setName("Mouse");
    thirdProduct.setPrice(42.5);
    thirdProduct.setQuantity(33L);
    products[productsIndex++] = thirdProduct;
  }

  private void createCustomers() {
    Customer firstCustomer = new Customer(getNextId());
    firstCustomer.setName("John Doe");
    firstCustomer.setAddress("str. Aiudului, nr. 2, Cluj-Napoca");
    firstCustomer.setPhoneNumber("+40751667453");
    customers[customersIndex++] = firstCustomer;

    Customer secondCustomer = new Customer(getNextId());
    secondCustomer.setName("Jane Doe");
    secondCustomer.setAddress("str. Frunzisului, nr. 23, Cluj-Napoca");
    secondCustomer.setPhoneNumber("+40752344453");
    customers[customersIndex++] = secondCustomer;

    Customer thirdCustomer = new Customer(getNextId());
    thirdCustomer.setName("John Smith");
    thirdCustomer.setAddress("str. George Baritiu, nr. 12, Cluj-Napoca");
    thirdCustomer.setPhoneNumber("+40751665343");
    customers[customersIndex++] = thirdCustomer;
  }

  private void printStock() {
    System.out.println("Stock:");
    for (Product product : products) {
      if (product != null) {
        System.out.println("\t" + product.getName() + ": " + product.getQuantity());
      }
    }
  }

  private Long getNextId() {
    return nextId++;
  }
}
