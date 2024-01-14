package UTCN.HW;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    List<Product> shelf = new ArrayList<Product>();

    public void addNewProduct(Product product, int givenQuantity) {
        shelf.add(product);
        int quantity = product.getQuantity() + givenQuantity;
        product.setQuantity(quantity);
    }
    public void tweakQuantity(Product product, int givenQuantity) {
        int quantity = product.getQuantity() - givenQuantity;
        product.setQuantity(quantity);
    }
    public void displayShelf() {
        for (Product product : shelf) {
            product.displayProductDetails();
        }
    }
    public boolean isAvailable(Product product, int askedQuantity) {
        int quantity = product.getQuantity();

        return quantity > 0 && quantity >= askedQuantity;
    }

}
