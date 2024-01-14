import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        InventoryService inventory = InventoryService.getInstance();

        Product bread = new Product(1, "Bread", "Simple bread", 5);
        Product water = new Product(2, "Water", "Simple water", 2);
        inventory.addProduct(bread, 3);
        inventory.addProduct(water, 5);

        Customer john = new Customer(1, "John");

        Order firstOrder = new Order(1, john);
        firstOrder.addProduct(bread, 1);
        firstOrder.addProduct(new OperationProduct(water, 3));
        
        inventory.updateProductQuantity(bread.getName(), -1);
        inventory.updateProductQuantity(water.getName(), -3);
        
        john.addPlacedOrder(firstOrder);

        List<OperationProduct> availableProducts = inventory.getAvailableProducts();


        System.out.println("Available products and quantities:");
        for (OperationProduct operationProduct : availableProducts) {
            System.out.println(operationProduct.getProduct().getName() + ": " + operationProduct.getQuantity());
        }

        System.out.println("\n");

        System.out.println(firstOrder.getOrderDetails());
        System.out.println("Total order amount: " + firstOrder.getOrderTotalAmount());


    }
}
