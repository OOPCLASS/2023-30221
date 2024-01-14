import java.util.HashMap;

public class Inventory {
    private HashMap<Product, Integer> inventoryStock = new HashMap<Product, Integer>();

    public void updateInventory(Product product) {
        this.inventoryStock.put(product, this.inventoryStock.getOrDefault(product, 0) + product.getQuantity());
    }

    public void displayAvailableProducts() {
        for (Product product : this.inventoryStock.keySet())
            if (this.inventoryStock.get(product) > 0)
                System.out.println(product.getName() + " " + product.getQuantity() + " ");
    }
}
