package com.tutorial.springeducationweek1.domain.refunds.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefundRequest {

  @NotBlank(message = "reason must not be blank")
  String reason;
  @NotBlank(message = "method must not be blank")
  String method; // 카드, 계좌이체, 포인트 등

  String bankAccount;

  Boolean isPartial = false;

  String note;
}
