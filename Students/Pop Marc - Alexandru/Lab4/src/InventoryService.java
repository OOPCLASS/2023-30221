import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private List<OperationProduct> products = new ArrayList<OperationProduct>();
    
    private static InventoryService inventoryService;

    private InventoryService() {
        
    }

    public static InventoryService getInstance() {
        if (inventoryService == null) {
            inventoryService = new InventoryService();
        }

        return inventoryService;
    }

    public List<OperationProduct> getProducts() {
        return products;
    }

    public void addProduct(Product product, int quantity) {
        products.add(new OperationProduct(product, quantity));
    }

    public void addProduct(OperationProduct orderProduct) {
        products.add(orderProduct);
    }

    public void removeProduct(OperationProduct orderProduct) {
        products.remove(orderProduct);
    }

    public void removeProduct(String productName) {
        products.removeIf(p -> p.getProduct().getName() == productName);
    }

    public void updateProductQuantity(String productName, int quantity) {
        OperationProduct product = getProduct(productName);
        product.setQuantity(product.getQuantity() + quantity);
    }

    public List<OperationProduct> getAvailableProducts() {
        List<OperationProduct> list = new ArrayList<OperationProduct>();
        
        for (OperationProduct operationProduct : products) {
            if (operationProduct.getQuantity() > 0) {
                list.add(operationProduct);
            }
        }

        return list;
    }

    public OperationProduct getProduct(String name) {
        return products
            .stream()
            .filter(p -> p.getProduct().getName() == name)
            .findAny()
            .orElse(null);
    }
}
