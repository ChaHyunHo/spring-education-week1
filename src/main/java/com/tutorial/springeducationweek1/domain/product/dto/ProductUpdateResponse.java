package com.tutorial.springeducationweek1.domain.product.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductUpdateResponse {

  String name;
  String description;
  BigDecimal price;
  Integer stock;
  LocalDateTime createdAt;
  LocalDateTime updatedAt;
}
