package utcn.ro;

import java.util.Objects;

public class Order {
    private Integer internalId;
    private Customer customer;
    private Product[] products;
    private Integer[] quantities;
    private int productIndex = 0;

    public Order(long internalId) {
        this.products = new Product[6];
        this.quantities = new Integer[6];
    }

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer internalId) {
        this.internalId = internalId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        this.customer.addOrder(this);
    }

    public void addProduct (Product product, Integer quantity) {
        for(int i = 0; i < this.productIndex; i++) {
            Product currentProduct = this.products[i];
            if(Objects.equals(currentProduct.getInternalId(), product.getInternalId())) {
                this.quantities[i] += quantity;
                product.setQuantity(product.getQuantity() - quantity);
                return;
            }
        }
        if(quantity > 0 && product.getQuantity() > quantity) {
            this.products[this.productIndex] = product;
            this.quantities[this.productIndex] = quantity;
            this.productIndex++;
            product.setQuantity(product.getQuantity() - quantity);
        }
    }

    public float getTotalPrice() {
        float totalPrice = 0.0f;
        for(int i = 0; i < this.productIndex; i++) {
            Product currentProduct = this.products[i];
            Integer currentQuantity = this.quantities[i];
            totalPrice += currentProduct.getPrice() * currentQuantity;
        }
        return totalPrice;
    }

    public void printDetails() {
        System.out.println("Order details:");
        if(customer != null) {
            System.out.println("Customer: " + this.customer.getName());
        } else {
            System.out.println("Customer: N/A");
        }
        System.out.println("Products:");
        for(int i = 0; i < this.productIndex; i++) {
            Product currentProduct = this.products[i];
            Integer currentQuantity = this.quantities[i];
            System.out.println(currentProduct.getName() + " : " + currentProduct.getPrice() + " * " + currentQuantity);
        }
        System.out.println("Total price: " + this.getTotalPrice());
    }
}
