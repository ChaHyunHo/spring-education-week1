package com.tutorial.springeducationweek1.domain.purchase.dto;


import com.tutorial.springeducationweek1.common.enums.PurchaseStatus;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseCancelResponse {

  Long purchaseId;

  PurchaseStatus status;

  LocalDateTime cancelledAt;

  String message;

  List<PurchaseProductCancelResponse> purchaseProductCancelResponses;

}
