public class Product {
    private Integer productID;
    private String productName;
    private String productDescription;
    private Integer productPrice;
    public Integer productStock;

    public String toString(){
        String id, name, description, price, stock;
        id = "product ID: " + this.productID + "\n";
        name = "product Name: " + this.productName + "\n";
        description = "product Description: " + this.productDescription + "\n";
        price = "product Price: " + this.productPrice + "$\n";
        stock = "product stock: " + this.productStock + "\n\n";
        return id + name + description + price + stock;
    }

    public Product(Integer productID, String productName, String productDescription, Integer productPrice, Integer productStock) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public void displayProductDetails() {
        System.out.println("id: " + this.productID);
        System.out.println("name: " + this.productName);
        System.out.println("description: " + productDescription);
        System.out.println("price: " + productPrice + "$");
        System.out.println("stock: " + productStock);
    }
}
