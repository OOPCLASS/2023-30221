public class Main {
    public static void main(String[] args) {
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();

        product1.setID("1");
        product2.setID("2");
        product3.setID("3");
        product4.setID("4");
        product5.setID("5");

        product1.setName("Salata");
        product2.setName("Rosii");
        product3.setName("Mere");
        product4.setName("Lays");
        product5.setName("Milka");

        product1.setDescription("leguma");
        product2.setDescription("leguma (desi are seminte)");
        product3.setDescription("fruct");
        product4.setDescription("snack");
        product5.setDescription("dulce");

        product1.setQuantity(2);
        product2.setQuantity(2);
        product3.setQuantity(2);
        product4.setQuantity(2);
        product5.setQuantity(2);

        product1.setPrice(1.99);
        product2.setPrice(1.49);
        product3.setPrice(1.49);
        product4.setPrice(5.00);
        product5.setPrice(3.49);

        product1.displayProductDetails();
        product2.displayProductDetails();
        product3.displayProductDetails();
        product4.displayProductDetails();
        product5.displayProductDetails();

        System.out.println(" ");

        Inventory inventory = new Inventory();

        inventory.updateInventory(product1);
        inventory.updateInventory(product2);
        inventory.updateInventory(product3);
        inventory.updateInventory(product4);
        inventory.updateInventory(product5);

        inventory.displayAvailableProducts();

        Order order1 = new Order();
        order1.addProductsToOrder(product1);
        order1.addProductsToOrder(product2);
        order1.addProductsToOrder(product1);
        order1.addProductsToOrder(product2);


        inventory.updateInventory(product1);
        inventory.updateInventory(product2);

        //#TO DO: it still shows the product's name even tho quantity=0;
        inventory.displayAvailableProducts();

    }
}