import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product produs1= new Product(1," Masina", " motor v6",180,2);
        Product produs2= new Product(2,"atv", " motor mic",50,1);

        Customer cust1= new Customer(1,"ursu george");

        List<Product> Inventory = new ArrayList<>();
        Inventory.add(produs1);
        Inventory.add(produs2);

        cust1.createNewOrder(1);
       // List<Order> Orders = new ArrayList<>();
        Order customerOrder=cust1.orderH.get(0);
        customerOrder.addProduct(produs1,3);
        customerOrder.addProduct(produs2,1);

        cust1.printOrderHistory();
    }
}