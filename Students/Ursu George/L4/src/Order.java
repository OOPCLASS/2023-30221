import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderID;
    private Customer customer;
    private List<Product> products;
    private List<Integer> quantity;

    public Order(int orderID, Customer customer) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.quantity = new ArrayList<>();
    }

    public void addProduct(Product product, int quantityInt) {
        products.add(product);
        quantity.add(quantityInt);
    }
    public void displayOrderDetails(){
        System.out.println("Order id: "+ this.orderID+" Customer :"+customer.getName());
        int totalSum = 0;
        int cursor=0;
        for(Product products: products){
            totalSum=totalSum+products.getPrice();
            System.out.println("product : "+ products.getName()+ quantity.get(cursor));
            cursor++;
        }
        System.out.println("Total price: "+ totalSum);
    }



}
