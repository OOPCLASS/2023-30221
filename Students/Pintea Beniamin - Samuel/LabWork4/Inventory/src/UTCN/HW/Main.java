package UTCN.HW;


public class Main {
    public static void main(String[] args) {
       Inventory stock = new Inventory();

       Product product1 = new Product();
       product1.setProductName("Apple");
       product1.setProductBarcode("00010201");
       product1.setPrice(2.99);
       product1.setProductDescription("Fruits");

       Product product2 = new Product();
       product2.setProductName("Banana");
       product2.setProductBarcode("00010202");
       product2.setPrice(3.99);
       product2.setProductDescription("Fruits");

       Product product3 = new Product();
       product3.setProductName("Eggs");
       product3.setProductBarcode("00020201");
       product3.setPrice(2.99);
       product3.setProductDescription("Dairy");

       Product product4 = new Product();
       product4.setProductName("Milk");
       product4.setProductBarcode("10010201");
       product4.setPrice(2.99);
       product4.setProductDescription("Dairy");

       stock.addNewProduct(product1, 100);
       stock.addNewProduct(product2, 111);
       stock.addNewProduct(product3, 78);
       stock.addNewProduct(product4, 55);

       stock.displayShelf();

       Customer customer1 = new Customer();
       customer1.setName("Florica");
       customer1.setEmail("florica@example.com");
       customer1.setAddres("FloricaStreet 1234");
       Order order1 = new Order();
       Order order2 = new Order();
       order1.addToCart(product1, 20, stock);
       order1.addToCart(product2, 12, stock);
       order1.addToCart(product3, 50, stock);
       order2.addToCart(product4, 25, stock);
       customer1.addOrder(order1);
       customer1.addOrder(order2);
       customer1.showHistory();
       stock.displayShelf();


    }
}