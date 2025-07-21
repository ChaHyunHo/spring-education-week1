package com.tutorial.springeducationweek1.domain.product.service;


import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.domain.product.entity.Product;
import com.tutorial.springeducationweek1.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductTransactionService {

  private final PlatformTransactionManager transactionManager;
  private final ProductRepository productRepository;

  // 좀 더 정밀한 트랜잭션이 필요한경우 사용
  public void updateProductStock(Long productId, Integer stock) {
    TransactionStatus status = transactionManager.getTransaction(
        new DefaultTransactionDefinition());

    try {
      Product product = productRepository.findById(productId)
          .orElseThrow(() -> new ServiceException(
              ServiceExceptionCode.NOT_FOUNT_PRODUCT));

      if (product.getStock() < stock) {
        throw new ServiceException(ServiceExceptionCode.INSUFFICIENT_STOCK);
      }

      product.decreaseStock(stock);
      productRepository.save(product);

      log.info("isTransaction : {}", TransactionSynchronizationManager.isActualTransactionActive());

      transactionManager.commit(status);
    } catch (Exception e) {
      transactionManager.rollback(status);
      throw new RuntimeException(e);
    }
  }

  @Transactional
  public void updateProductStockTransactional(Long productId, Integer stock) {
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new ServiceException(
            ServiceExceptionCode.NOT_FOUNT_PRODUCT));

    if (product.getStock() < stock) {
      throw new ServiceException(ServiceExceptionCode.INSUFFICIENT_STOCK);
    }

    product.decreaseStock(stock);
  }

}
