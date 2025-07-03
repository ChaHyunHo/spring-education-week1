package com.tutorial.springeducationweek1.domain.product.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductSearchResponse {

  final Long id;
  final String name;
  final String description;
  final BigDecimal price;
  final Integer stock;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  final LocalDateTime createdAt;

  @QueryProjection
  public ProductSearchResponse(Long id, String name, String description, BigDecimal price,
      Integer stock, LocalDateTime createdAt) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.stock = stock;
    this.createdAt = createdAt;
  }
}
