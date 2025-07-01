package com.tutorial.springeducationweek1.domain.purchase.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseProductsRequest {

  @NotNull(message = "userId must not be null")
  Long userId;

  @NotNull(message = "shippingAddress must not be null")
  String shippingAddress;

  List<PurchaseProductRequest> productRequests;
}
