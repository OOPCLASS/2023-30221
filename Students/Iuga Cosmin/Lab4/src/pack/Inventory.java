package pack;

import java.util.ArrayList;

public class Inventory {
    public ArrayList<Product> inventory;

    public Inventory()
    {
        this.inventory = new ArrayList<>();
    }

    public void addProduct(Product prod)
    {
        inventory.add(prod);
    }

    public void modifyProduct(int id, String name, String description, double price, int quantity)
    {
        for(Product i : inventory)
        {
            if(i.getId()==id)
            {
                i.setName(name);
                i.setDescription(description);
                i.setPrice(price);
                i.setQuantity(quantity);
            }
        }
    }
    public void printInventory()
    {
        System.out.println("Inventar:");
        for(Product i : inventory)
        {
            System.out.println(i.toString());
        }
    }

    public void availabilityStatus()
    {
        System.out.println("Disponibilitatea produselor:");
        for(Product i: inventory)
        {
            if(i.getQuantity()<=0)
            {
                System.out.println(i.getName() + "-stoc epuizat");
            }
            else
            {
                System.out.println(i.getName()+"-"+i.getQuantity());
            }
        }
    }
}
