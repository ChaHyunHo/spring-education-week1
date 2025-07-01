package com.tutorial.springeducationweek1.domain.purchase.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseProductRequest {

  Long productId;
  Integer quantity;
}
