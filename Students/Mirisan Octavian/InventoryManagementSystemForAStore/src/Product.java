public class Product
{

    int id;
    String name;
    String description;
    float price;
    int quantity;

    //constructor

    public Product(int id,String name,String description,float price,int quantity)
    {

        this.id=id;
        this.name=name;
        this.description=description;
        this.price=price;
        this.quantity=quantity;
    }

    //getters


    public int getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public float getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }


    //setters

    public void setId(int newID)
    {
        id=newID;
    }

    public void setName(String newName)
    {
        name=newName;
    }

    public void setDescription(String newDescription)
    {
        description=newDescription;
    }

    public void setPrice(float newPrice)
    {
        price=newPrice;
    }
    public void setQuantity(int newQuantity)
    {
        quantity=newQuantity;
    }







    public void displayProductInfo()
    {
        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + name);
        System.out.println("Product Description: " + description);
        System.out.println("Product Price: " + price);
        System.out.println("Product Quantity: " +quantity);


    }


}
