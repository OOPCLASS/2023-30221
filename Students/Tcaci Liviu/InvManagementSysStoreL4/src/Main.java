public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //Create an inventory
        Inventory inventory = new Inventory();

        // Initialize some products and add them to the inventory
        Product product1 = new Product(1, "Apple", "A juicy apple", 0.99, 100);
        Product product2 = new Product(2, "Banana", "A ripe banana", 1.99, 109);
        product1.setProductPrice(1.49);
        product2.setProductName("BananaBio");
        product2.setProductId(21);
        product2.setProductDescription("Some good bananas");
        System.out.println(product2.getProductDescription());
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        // Create customer profiles
        Customer customer1 = new Customer(1, "John Doe", "123-456-7890");
        Customer customer2 = new Customer(2, "Jane Smith", "987-654-3210");
        customer1.displayCustomerDetails();

        // Have customers place orders
        Order order1 = customer1.createOrder(1001);
        order1.addProduct(product1, 5);
        order1.addProduct(product2, 3);

        Order order2 = customer2.createOrder(1002);
        order2.addProduct(product1, 2);

        // Display product details, customer order history, and available products
        product1.displayProductDetails();
        product2.displayProductDetails();

        customer1.displayOrderHistory();
        customer2.displayOrderHistory();

        inventory.displayAvailableProducts();
    }
}