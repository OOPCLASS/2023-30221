package pack;
public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        Customer customer1 = new Customer(1,"Iuga Cosmin","0744.444.444");

        Product product1 = new Product(1,"Ariel","detergent",4,100);
        Product product2 = new Product(2,"Percil","detergent",3,50);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.modifyProduct(2,"Paine","aliment de baza",5,300);
        inventory.printInventory();

        Order order1 = new Order(1);
        order1.addProductInOrder(inventory,1,50);
        order1.addProductInOrder(inventory,2,51);
        order1.addProductInOrder(inventory,2,50);
        customer1.addOrder(order1);

        Order order2 = new Order(2);
        order2.addProductInOrder(inventory,1,20);
        customer1.addOrder(order2);

        customer1.printOrders();

        inventory.availabilityStatus();

    }
}