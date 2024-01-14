import java.util.ArrayList;
import java.util.List;
public class Order
{
    int id;

    Customer customer;

    List <Product> products;

    List <Integer> quantities;

    public Order(int id,Customer customer)
    {
        this.id=id;
        this.customer=customer;
        this.products= new ArrayList<>();
        this.quantities= new ArrayList<>();

    }



    public void addProduct(Product product,int quantity)
    {
        products.add(product);
        quantities.add(quantity);
    }

    public float calculateTotal()
    {
        float sum=0;

        for(int i =0 ;i < products.size(); i++)
        {
            sum = sum + products.get(i).getPrice() * quantities.get(i);
        }

        return sum;
    }

    public void displayDetails()
    {
        System.out.println("Order ID: " + id);
        System.out.println("Customer name: " + customer.getName());
        System.out.println("Products: ");

        for(int i = 0; i < products.size(); i++)
        {
            System.out.println(i + ": " + products.get(i).getName() + ", quantity: " + quantities.get(i));
        }

        System.out.println("Total sum is " + calculateTotal());
    }



}
