package com.tutorial.springeducationweek1.domain.refunds.controller;

import com.tutorial.springeducationweek1.common.response.ApiResponse;
import com.tutorial.springeducationweek1.domain.refunds.dto.RefundRequest;
import com.tutorial.springeducationweek1.domain.refunds.service.RefundsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/refunds")
public class RefundsController {

  private final RefundsService refundsService;

  @PostMapping("/{purchaseId}")
  public ApiResponse<Void> processRefund(@PathVariable Long purchaseId,
      @Valid @RequestBody RefundRequest request) {
    refundsService.processRefund(purchaseId, request);
    return ApiResponse.success();
  }

}
