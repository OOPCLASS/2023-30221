package POOlab4;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() { //ArrayList class is a resizable array, List is an interface while ArrayList is an implementation of List (basically a class)
        products = new ArrayList<>();
    }

    public void addProduct(Product product, String productID, String name, String description, float price, int stockQuantity) {
        product.addNewProduct(productID, name, description, price, stockQuantity);
        products.add(product);
    }

    public void sellProduct(Order order, Product product, int quantity) {
        for (Product p : products) {
            if (p.getProductID().equals(product.getProductID())) {
                if (p.getStockQuantity() >= quantity) {
                    System.out.println("Sold: " + p.getName());
                    order.addProductToOrder(product, quantity);
                } else {
                    System.out.println("The current stock is lower than the solicited quantity. Currently in stock:" + product.getStockQuantity());                }
            }
        }
    }

    public void displayProducts(){
        System.out.println("Available products:");
        for (Product product : products) {
            product.displayProduct();
            System.out.println();
        }
    }

    public void isProductAvailable(String productID, int quantity) {
        for (Product product : products) {
            if (product.getProductID().equals(productID)) {
                if (product.getStockQuantity() >= quantity){
                    System.out.println("Product available");
                }
            }
        }
        System.out.println("Product NOT available");
    }
}
