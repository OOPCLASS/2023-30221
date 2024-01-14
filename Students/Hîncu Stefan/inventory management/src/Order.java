import java.util.ArrayList;

public class Order {
    private String ID;
    private Customer customer;
    private ArrayList<Product> products = new ArrayList<Product>();

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void displayOrderDetails() {
        System.out.println(this.ID + " " + this.customer.getName());
    }

    public void addProductsToOrder(Product product) {
        if (product.getQuantity() > 0) {
            this.products.add(product);
            product.setQuantity(product.getQuantity() - 1);
        } else
            System.out.println("Not enough " + product.getName());
    }

    public double calculateTotalOrderAmount() {
        double totalPrice = 0.00;

        for (Product product : this.products)
            totalPrice += product.getPrice();

        return totalPrice;
    }
}
