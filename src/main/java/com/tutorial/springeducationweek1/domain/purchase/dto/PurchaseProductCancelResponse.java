package com.tutorial.springeducationweek1.domain.purchase.dto;


import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseProductCancelResponse {

  Long productId;

  String name;

  Integer quantity;

  BigDecimal price;

  BigDecimal totalPrice;
}
