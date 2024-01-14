package lab4;

public class Main {

	public static void main(String[]arg)
	{
		Product product1=new Product("name","descrption",10.5,20);
		product1.updateProduct("name1", "description1", 15.7, 300);
		Product product2=new Product("name2","descrption2",10.5,20);
		Product product3= new Product("name3","description3",11.2,500);
		
		Customer customer1= new Customer("Marcel","contactInfo");
		
		Order order1=new Order(customer1);
		order1.addProduct(product1, 7);
		order1.addProduct(product3, 7);

		order1.displayOrder();
	}
	
}
