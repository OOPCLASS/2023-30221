package lab4;

import java.util.ArrayList;

public class Order {
static int newOrderId=1;
int orderId;
Customer orderCustomer;
int nrOfProducts=0;
Product[] products;
double totalPrice=0.0;

public Order(Customer orderCustomer) 
{
orderId=newOrderId++;
this.orderCustomer=orderCustomer;
products = new Product[10];
}

public void addProduct(Product newProduct,double quantity)
{
	products[nrOfProducts]= new Product(newProduct.name,newProduct.description,newProduct.price,newProduct.quantity);
	totalPrice=totalPrice+(newProduct.price *quantity);
	nrOfProducts++;
}

public void displayOrder()
{
 System.out.println("Order Nr: " + orderId);
 System.out.println("Customer: " + orderCustomer.name);
 System.out.println("Products: ");
 for(int i=0;i<nrOfProducts;i++)
 {
	 System.out.println(products[i].name);
	 System.out.println(products[i].price);
 }
 System.out.println("Total: " + totalPrice);
}

}
