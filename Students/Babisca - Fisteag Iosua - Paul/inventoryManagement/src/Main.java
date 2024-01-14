import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Product> inventory = new ArrayList<>();

        Product jeans = new Product(1,"jeans","good quality, long lasting jeans", 100, 1);
        Product tShirt = new Product(2, "T-Shirt", "simple white T-Shirt", 50, 33);
        Product hoodie = new Product(3,"Hoodie", "cozy hoodie", 70, 60);

        inventory.add(jeans);
        inventory.add(tShirt);
        inventory.add(hoodie);

        System.out.println(inventory.toString());

        Customer customer1 = new Customer(20,"paul","+40730873002");
        customer1.placeOrder(jeans);
        customer1.placeOrder(hoodie);
    }
}