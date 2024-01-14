import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;

    private Customer customer;

    private List<OperationProduct> products = new ArrayList<OperationProduct>();

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public int getOrderTotalAmount() {
        int amount = 0;

        for (OperationProduct orderProduct : products) {
            amount += orderProduct.getProduct().getPrice() * orderProduct.getQuantity();
        }

        return amount;
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();

        details.append("Order ID: " + id + "\n");
        details.append("Customer: " + customer.getName() + "\n\n");

        details.append("Products:\n");

        for (OperationProduct orderProduct : products) {
            details.append("Product Name: " + orderProduct.getProduct().getName() + "\n");
            details.append("Product Description: " + orderProduct.getProduct().getDescription() + "\n");
            details.append("Product Price: " + orderProduct.getProduct().getPrice() + "\n");
            details.append("Product Quantity: " + orderProduct.getQuantity() + "\n");
            details.append("\n");
        }
        
        details.delete(details.length() - 2, details.length());

        return details.toString();
    }
}
