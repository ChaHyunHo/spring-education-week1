package com.tutorial.springeducationweek1.domain.purchase.controller;

import com.tutorial.springeducationweek1.common.response.ApiResponse;
import com.tutorial.springeducationweek1.domain.purchase.dto.PurchaseRequest;
import com.tutorial.springeducationweek1.domain.purchase.service.PurchaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/purchases")
public class PurchaseController {

  private final PurchaseService purchaseService;

  @PostMapping
  public ApiResponse<Void> placePurchase(@Valid @RequestBody PurchaseRequest request) {
    purchaseService.placePurchase(request);
    return ApiResponse.success();
  }

}
