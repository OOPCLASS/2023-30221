package ro.utcn;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Laptop", "Lenovo i7 8th Gen", 1900, 13);
        Product product2 = new Product(2, "Phone", "iPhone 11 Pro Max", 1200, 31);
        Product product3 = new Product(3, "Phone", "Samsung Galaxy S10", 700, 50);
        Product product4 = new Product(4, "TV", "Samsung LED 4K Ultra HD", 700, 100);
        Product product5 = new Product(5, "Phone", "iPhone 13 Pro Max", 1600, 70);
        Product product6 = new Product(6, "TV", "JVC LED HD", 150, 25);

        Customer customer1 = new Customer(10, "Ingrid", "0745234178");
        Customer customer2 = new Customer(11, "Thomas", "0748344156");
        Customer customer3 = new Customer(12, "Mario", "0746307418");
        Customer customer4 = new Customer(13, "John", "0799637178");

        ArrayList<Product> allProducts = new ArrayList<>();
        allProducts.add(product1);
        allProducts.add(product2);
        allProducts.add(product3);
        allProducts.add(product4);
        allProducts.add(product5);
        allProducts.add(product6);

        Order order1 = new Order(20, customer1.getName());
        order1.addProducts(product5.getName(), 1);
        order1.addProducts(product1.getName(), 1);
        order1.addProducts(product4.getName(), 3);

        Order order2 = new Order(21, customer3.getName());
        order2.addProducts(product2.getName(), 3);
        order2.addProducts(product6.getName(), 15);

        Order order3 = new Order(22, customer4.getName());
        order3.addProducts(product3.getName(), 1);
        order3.addProducts(product1.getName(), 2);
        order3.addProducts(product6.getName(), 1);

        Order order4 = new Order(23, customer2.getName());
        order4.addProducts(product4.getName(), 2);
        order4.addProducts(product2.getName(), 1);

        Order order5 = new Order(24, customer3.getName());
        order5.addProducts(product1.getName(), 3);
        order5.addProducts(product3.getName(), 1);

        order1.displayOrderDetails(allProducts);
        System.out.println("\n");
        order2.displayOrderDetails(allProducts);
        System.out.println("\n");
        order3.displayOrderDetails(allProducts);
        System.out.println("\n");
        order4.displayOrderDetails(allProducts);
        System.out.println("\n");
        order5.displayOrderDetails(allProducts);
        System.out.println("\n");

        customer1.createNewOrder(order1);
        customer2.createNewOrder(order4);
        customer3.createNewOrder(order2);
        customer3.createNewOrder(order5);
        customer4.createNewOrder(order3);

        customer1.displayOrderHistory();
        System.out.println("\n");
        customer2.displayOrderHistory();
        System.out.println("\n");
        customer3.displayOrderHistory();
        System.out.println("\n");
        customer4.displayOrderHistory();
    }
}