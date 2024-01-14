package ro.utcn;
import java.util.ArrayList;
import java.util.List;
public class Inventory {
    public List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void sellProduct(String productName, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                if (product.getQuantityInStock() >= quantity) {
                    product.setQuantityInStock(product.getQuantityInStock() - quantity);
                    System.out.println(quantity + " " + productName + "(s) sold.");
                } else {
                    System.out.println("Not enough " + productName + " in stock.");
                }
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }

    public void displayAvailableProducts() {
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println("Product: " + product.getName() + ", Quantity: " + product.getQuantityInStock());
        }
    }
}
