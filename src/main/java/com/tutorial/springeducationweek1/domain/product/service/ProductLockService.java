package com.tutorial.springeducationweek1.domain.product.service;

import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.domain.product.entity.Product;
import com.tutorial.springeducationweek1.domain.product.repository.ProductLockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductLockService {

  private final ProductLockRepository productRepository;

  @Transactional
  public void updateStockWithPessimisticLock(Long productId, Integer quantity) {
    Product product = productRepository.findByIdForUpdate(productId)
        .orElseThrow(() -> new ServiceException(ServiceExceptionCode.NOT_FOUNT_DATA));

    if (product.getStock() < quantity) {
      throw new ServiceException(ServiceExceptionCode.NOT_FOUNT_DATA);
    }

    product.setStock(product.getStock() - quantity);
  }

  @Transactional
  public void updateStockWithOptimisticLock(String name, int quantity) {
    Product product = productRepository.findFirstByNameOrderById(name)
        .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

    if (product.getStock() < quantity) {
      throw new ServiceException(ServiceExceptionCode.NOT_FOUNT_DATA);
    }

    product.setStock(product.getStock() - quantity);
    productRepository.save(product);
  }


}
