import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProductQuantity(int productId, int soldQuantity) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                product.setProductQuantity(product.getProductQuantity() - soldQuantity);
                return;
            }
        }
    }

    public void displayAvailableProducts() {
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Quantity in Stock: " + product.getProductQuantity());
        }
    }
}
