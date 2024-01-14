package ro.utcn;
import java.util.ArrayList;

public class Order {
    public int orderID;
    public String customer;
    public ArrayList<String> products;
    public ArrayList<Integer> quantities;
    public double total = 0.0;

    public int getOrderID() {
        return orderID;
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public Order(int orderID, String customer) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>();
    }

    public void addProducts(String product, int quantity) {
        products.add(product);
        quantities.add(quantity);
    }

    public double totalOrderAmount(ArrayList<Product> allProducts) {
        total = 0.0;
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i);
            int quantity = quantities.get(i);
            for (Product p : allProducts) {
                if (p.getName().equals(product)) {
                    total += p.getPrice() * quantity;
                }
            }
        }
        return total;
    }

    public void displayOrderDetails(ArrayList<Product> allProducts) {
        System.out.println("Order id: " + orderID);
        System.out.println("Customer: " + customer);
        System.out.println("Products: ");
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i);
            int quantity = quantities.get(i);
            System.out.println(product + " " + quantity);
        }
        System.out.println("Total Order Amount: " + totalOrderAmount(allProducts) + " $");
    }
}
