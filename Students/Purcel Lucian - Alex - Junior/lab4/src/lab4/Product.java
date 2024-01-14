package lab4;

public class Product {
static int newId=1;
int id;
String name;
String description;
double price;
int quantity;



public Product(String name,String description,double price,int quantity)
{
	this.id=newId++;
	this.name=name;
	this.description=description;
	this.price=price;
	this.quantity=quantity;
}

public void updateProduct(String name, String description, double price, int quantity)
{
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity=quantity;
}

public void displayProduct() 
{
System.out.println(id);
System.out.println(name);
System.out.println(description);
System.out.println(price);
System.out.println(quantity);
}

}
