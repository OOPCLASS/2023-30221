package POOlab4;

import java.net.IDN;

public class Product {
    private String productID;
    private String name;
    private String description;
    private float price;
    private int stockQuantity;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void addNewProduct(String productID, String name, String description, float price, int stockQuantity) {
        setProductID(productID);
        setName(name);
        setDescription(description);
        setPrice(price);
        setStockQuantity(stockQuantity);
    }

    public void updateInformation(String name, String description, float price, int stockQuantity) {
        if (name != null) {
            setName(name);
        }
        if (description != null) {
            setDescription(description);
        }
        if (price >= 0) {
            setPrice(price);
        }
        if (stockQuantity >= 0) {
            setStockQuantity(stockQuantity);
        }
    }

    public void updateQuantity(int quantity) {
        stockQuantity -= quantity;
    }

    public void displayProduct() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
        System.out.println("Quantity in stock: " + stockQuantity);
    }
}
