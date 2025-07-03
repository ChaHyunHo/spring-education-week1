package com.tutorial.springeducationweek1.domain.purchase.dto;

public class PurchaseProductRequestTest {

  public PurchaseProductRequestTest(Long productId, Integer quantity) {
    this.productId = productId;
    this.quantity = quantity;
  }

  Long productId;
  Integer quantity;

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Long getProductId() {
    return productId;
  }

  public Integer getQuantity() {
    return quantity;
  }
}