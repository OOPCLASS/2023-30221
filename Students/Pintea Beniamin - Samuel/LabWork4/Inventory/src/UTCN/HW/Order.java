package UTCN.HW;

import java.util.ArrayList;
import java.util.List;

public class Order {

    String ID;
    List<Product> orderBasket = new ArrayList<Product>();

    public void setID(String ID) {
        this.ID = ID;
    }

    public void addToCart(Product product, int quantity, Inventory stock) {
        if (stock.isAvailable(product, quantity)) {
            orderBasket.add(product);
            stock.tweakQuantity(product, quantity);
        }
    }

    public double totalOrderPrice() {
        double totalPrice = 0;

        for (Product product : orderBasket) {
            totalPrice += product.price;
        }

        return totalPrice;
    }
    public void showOrderDetails() {
        System.out.println("----Order----");
        for (Product product: orderBasket) {
            System.out.println(product.productName);
        }
        System.out.println("Total price: " + totalOrderPrice());
    }

}
