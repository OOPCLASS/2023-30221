import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private List<Integer> quantities;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>();
    }

    //setters and getters
    public int getOrderId() {
        return orderId;
    }

    public void addProduct(Product product, int quantity) {
        if (quantity > 0 && product.getProductQuantity() >= quantity) {
            products.add(product);
            quantities.add(quantity);
            product.setProductQuantity(product.getProductQuantity() - quantity);
        } else {
            System.out.println("Product not added to the order. Invalid quantity or out of stock.");
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (int i = 0; i < products.size(); i++) {
            total += products.get(i).getProductPrice() * quantities.get(i);
        }
        return total;
    }
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        //System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Total Order Amount: $" + calculateTotal());

        System.out.println("Order Items:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println("Product: " + products.get(i).getProductName());
            System.out.println("Quantity: " + quantities.get(i));
            System.out.println("Price per unit: $" + products.get(i).getProductPrice());
            System.out.println("Subtotal: $" + (products.get(i).getProductPrice() * quantities.get(i)));
        }

}
}
