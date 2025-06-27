package com.tutorial.springeducationweek1.domain.user.dto;

import com.querydsl.core.annotations.QueryProjection;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserPurchaseResponse {

  Long id;
  String name;
  String email;
  Long purchaseId;
  BigDecimal price;

  @QueryProjection
  public UserPurchaseResponse(Long id, String name, String email, Long purchaseId,
      BigDecimal price) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.purchaseId = purchaseId;
    this.price = price;
  }

}
