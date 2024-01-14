import java.sql.SQLOutput;

public class Product {
    private int ID;
    private String name;
    private String description;
    private int price;
    private int quantity;

    public Product(int ID, String name,String description,int price,int quantity){
        this.ID= ID;
        this.name = name;
        this.description=description;
        this.price=price;
        this.quantity=quantity;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public int getPrice(){
        return this.price;
    }
    public String getName(){
        return this.name;
    }
    public void showProduct(){
        System.out.println(this.name+" "+this.description+" "+this.price+" "+this.quantity);
    }


}
