public class Main
{

    public static void main(String[] args)
    {
        Product product1 = new Product(1,"Mouse","input device",50,30);
        Product product2= new Product(2,"Laptop","electronic device",4000,50);
        Product product3 = new Product(3,"Led TV","electronic device",2000,25);

        product1.displayProductInfo();


        Customer customer1 = new Customer(1,"Timmy","timmy33@gmail.com");
        Customer customer2 = new Customer(2,"Daniel","daniel49@gmail.com");

        Order order1 = new Order(1,customer1);
        Order order2 = new Order(2,customer2);

        order1.addProduct(product1,2);
        order1.addProduct(product2,3);

        order2.addProduct(product3,5);

     //   order1.displayDetails();

        customer1.createOrder(order2);

     //   customer1.displayHistory();

        InventoryManagement store= new InventoryManagement();

        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);

        store.displayProducts();

        store.sellProducts(1,25);

        store.displayProducts();

        store.sellProducts(2,55);

        store.displayProducts();






    }
}
