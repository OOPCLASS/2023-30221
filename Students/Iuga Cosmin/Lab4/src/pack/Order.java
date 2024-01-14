package pack;

import java.util.ArrayList;

public class Order {
    private int id;
    private int customerId;
    private ArrayList<Product> productsInOrder;

    public Order(int id)
    {
        this.id=id;
        this.customerId=0;
        productsInOrder = new ArrayList<>();
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void addProductInOrder(Inventory source, int id, int quantity)
    {
        for(Product i : source.inventory)
        {
            if(i.getId()==id)
            {
                if(i.getQuantity()>=quantity)
                {
                    Product prod = new Product(id,i.getName(), i.getDescription(), i.getPrice(),quantity);
                    productsInOrder.add(prod);
                    i.setQuantity(i.getQuantity()-quantity);
                    return;
                }
                else
                {
                    System.out.println("Stoc insuficient pentru produsul cu id-ul: " + id + "!\n");
                    return;
                }
            }
        }
        System.out.println("Produsul cu id-ul: " + id + " nu se afla in stoc!");
    }

    public double totalPrice()
    {
        double total=0;
        for(Product i : productsInOrder)
        {
            total+=(i.getPrice()*i.getQuantity());
        }
        return total;
    }
    public void printOrder()
    {
        System.out.println("Order" + id + "\nCustomerId: " + customerId);
        for(Product i : productsInOrder)
        {
            System.out.println("Nume: " + i.getName() + "\nCantitate: " + i.getQuantity());
        }
        System.out.println("Total: " + this.totalPrice() + "\n");
    }
}


