package com.tutorial.springeducationweek1.domain.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductLockFacade {

  private final ProductLockService productLockService;

  public void updateWithLock(Long productId, int quantity) {
    productLockService.updateStockWithPessimisticLock(productId, quantity);
  }
}
