import java.util.ArrayList;
import java.util.List;
public class InventoryManagement
{

    private List<Product> productList;

    public InventoryManagement()
    {
        this.productList= new ArrayList<>();
    }


    public void addProduct(Product product)
    {
        productList.add(product);
    }

    public void displayProducts()
    {
        System.out.println("The products available in the store: ");
        for(int i = 0; i < productList.size(); i++)
        {
            if(productList.get(i).getQuantity()>0)
            {
                System.out.println(productList.get(i).getID() + ". " + productList.get(i).getName() + " " + productList.get(i).getQuantity());
            }
        }
    }

    public void sellProducts(int ID, int quantitySold)
    {
        for(Product product: productList)
        {
            if(product.getID() == ID)
            {
                int currentQuantity = product.getQuantity();

                if(currentQuantity >= quantitySold)
                {
                    product.setQuantity(currentQuantity - quantitySold);

                    System.out.println(quantitySold + " units of " + product.getName() + " have been sold");
                }
                else
                {
                    System.out.println("Insufficient stock for " + product.getName());
                }
            }
        }

    }
}
