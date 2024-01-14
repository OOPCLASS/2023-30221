package utcn.ro;

public class InventoryManagement {
    private static Integer nextInternalId = 0;
    private Customer[] customers = new Customer[4];
    private int customerIndex = 0;
    private Product[] products = new Product[7];
    private int productsIndex = 0;

    private Integer getNextInternalId() {
        return nextInternalId++;
    }

    private void createCustomers() {
        Customer firstCustomer = new Customer(this.getNextInternalId());
        firstCustomer.setName("Michael");
        firstCustomer.setAddress("str. Observatorului, nr. 34, Cluj-Napoca");
        firstCustomer.setPhoneNumber("0743477377");
        this.customers[this.customerIndex++] = firstCustomer;

        Customer secondCustomer = new Customer(this.getNextInternalId());
        secondCustomer.setName("John");
        secondCustomer.setAddress("str. George Baritiu, nr. 26, Cluj-Napoca");
        secondCustomer.setPhoneNumber("0743477376");
        this.customers[this.customerIndex++] = secondCustomer;

        Customer thirdCustomer = new Customer(this.getNextInternalId());
        thirdCustomer.setName("Tom");
        thirdCustomer.setAddress("str. George Baritiu, nr. 28, Cluj-Napoca");
        thirdCustomer.setPhoneNumber("0743477373");
        this.customers[this.customerIndex++] = thirdCustomer;
    }

    private void createProducts() {
        Product firstProduct = new Product(this.getNextInternalId());
        firstProduct.setName("Vin");
        firstProduct.setPrice(13.0f);
        firstProduct.setQuantity(100);
        this.products[this.productsIndex++] = firstProduct;

        Product secondProduct = new Product(this.getNextInternalId());
        secondProduct.setName("Bere");
        secondProduct.setPrice(5.0f);
        secondProduct.setQuantity(70);
        this.products[this.productsIndex++] = secondProduct;

        Product thirdProduct = new Product(this.getNextInternalId());
        thirdProduct.setName("Pufuleti");
        thirdProduct.setPrice(2.0f);
        thirdProduct.setQuantity(1000);
        this.products[this.productsIndex++] = thirdProduct;
    }

    private void printStock() {
        System.out.println("Stock: ");
        for(Product product : this.products) {
            if(product != null) {
                System.out.println(product.getName() + ": " + product.getQuantity());
            }
        }
    }
    public void test() {
        createProducts();
        createCustomers();

        printStock();

        Order order = new Order(getNextInternalId());
        order.addProduct(this.products[0], 2);
        order.addProduct(this.products[1], 13);
        order.setCustomer(this.customers[0]);
        order.printDetails();

        order = new Order(getNextInternalId());
        order.addProduct(this.products[1], 2);
        order.addProduct(this.products[2], 2);
        order.addProduct(this.products[1], 2);
        order.setCustomer(this.customers[2]);
        order.printDetails();

        printStock();
    }

}
