package POOlab4;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product p1= new Product();
        Product p2= new Product();
        Product p3= new Product();
        Product p4= new Product();
        inventory.addProduct(p1, "P1", "Product 1", "Product description 1", 10, 100);
        inventory.addProduct(p2, "P2", "Product 2", "Product description 2", 5.59f, 50);
        inventory.addProduct(p3, "P3", "Product 3", "Product description 3", 20.22f, 60);
        inventory.addProduct(p4, "P4", "Product 4", "Product description 4", 12f, 80);

        p1.displayProduct();
        p1.updateInformation("P1.1", "Product description 1.1", 9.99f, 200);
        p1.displayProduct();

        inventory.isProductAvailable("P3", 500);

        Customer c1 = new Customer();
        c1.setCustomerID("C1");
        c1.setName("Client 1");

        Customer c2 = new Customer();
        c2.setCustomerID("C2");
        c2.setName("Client 2");

        Order order1 = new Order(c1);
        order1 = c1.createNewOrder();
        order1.setID("763");
        inventory.sellProduct(order1, p3, 50);
        System.out.println(p3.getStockQuantity());
        inventory.sellProduct(order1, p3, 2);
        System.out.println(p3.getStockQuantity());
        inventory.sellProduct(order1, p1, 200);
        System.out.println(p1.getStockQuantity());
        order1.displayOrder();

        Order order2 = new Order(c1);
        order2 = c1.createNewOrder();
        order2.setID("163");
        inventory.sellProduct(order2, p1, 5);
        inventory.sellProduct(order2, p3, 2);
        inventory.sellProduct(order2, p4, 20);
        order2.displayOrder();

        c1.displayOrderHistory();

        c2.displayOrderHistory();

        inventory.displayProducts();
        inventory.isProductAvailable("P1", 1);
    }
}