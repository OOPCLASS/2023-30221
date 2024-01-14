public class Product {
    int productId;
    String productName;
    //description
    String productDescription;
    double productPrice;
    //quantity
    int productQuantity;
    //constructor for adding new product
    public Product(int productId, String productName, String productDescription, double productPrice, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }
    //getter and setters
    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void displayProductDetails(){
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Product Description: " + productDescription);
        System.out.println("Product Price: " + productPrice);
        System.out.println("Product Quantity: " + productQuantity);

    }

}
