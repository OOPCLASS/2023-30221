package ro.utcn.model;

public class MostBoughtProduct {

  private Product product;
  private Long quantity;

  public MostBoughtProduct(Product product, Long quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public Long getQuantity() {
    return quantity;
  }
}
