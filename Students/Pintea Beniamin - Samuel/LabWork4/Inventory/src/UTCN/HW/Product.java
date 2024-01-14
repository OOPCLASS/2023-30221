package UTCN.HW;

public class Product {

    String productBarcode;
    String productName;
    String productDescription;
    double price;
    private int quantity;

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void displayProductDetails() {
        System.out.println("-----Product------");
        System.out.println("Name:" + productName);
        System.out.println("Price:" + price);
        int q = getQuantity();
        System.out.println("Quantity:" + q);
    }
}
