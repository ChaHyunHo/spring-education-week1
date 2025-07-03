package com.tutorial.springeducationweek1.domain.purchase.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public class PurchaseRequestTest {

  public PurchaseRequestTest(Long userId, Long productId, Integer quantity, String shippingAddress,
      List<PurchaseProductRequestTest> productRequests) {
    this.userId = userId;
    this.productId = productId;
    this.quantity = quantity;
    this.shippingAddress = shippingAddress;
    this.productRequests = productRequests;
  }

  @NotNull(message = "userId must not be null")
  Long userId;

  @NotNull(message = "productId must not be null")
  Long productId;

  @NotNull(message = "quantity must not be null")
  Integer quantity;

  @NotNull(message = "shippingAddress must not be null")
  String shippingAddress;

  List<PurchaseProductRequestTest> productRequests;

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public void setShippingAddress(String shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public void setProductRequests(
      List<PurchaseProductRequestTest> productRequests) {
    this.productRequests = productRequests;
  }

  public Long getUserId() {
    return userId;
  }

  public Long getProductId() {
    return productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public String getShippingAddress() {
    return shippingAddress;
  }

  public List<PurchaseProductRequestTest> getProductRequests() {
    return productRequests;
  }
}