package com.tutorial.springeducationweek1.domain.product.service;

import com.tutorial.springeducationweek1.domain.product.entity.Product;
import com.tutorial.springeducationweek1.domain.product.repository.ProductLockRepository;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductLockServiceTest {

  private static final Logger log = LoggerFactory.getLogger(ProductLockServiceTest.class);
  @Autowired
  private ProductLockService productLockService;

  @Autowired
  private ProductLockRepository productLockRepository;

  @Test
  public void updateStockWithPessimisticLock() throws InterruptedException {
    //given
    Long productId = 1L;
    int threadCount = 2;

    Product firstProduct = productLockRepository.findById(productId).orElseThrow();

    ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
    CountDownLatch latch = new CountDownLatch(threadCount);

    //when
    for (int i = 0; i < threadCount; i++) {
      executorService.submit(() -> {
        try {
          productLockService.updateStockWithOptimisticLock(firstProduct.getName(), 1);
        } catch (Exception e) {

          log.error("error", e);
          throw new RuntimeException(e);
        } finally {
          latch.countDown();
        }
      });
    }

    latch.await();  // 모든 스레드가 작업을 마칠 때까지 대기

    //then
    Product product = productLockRepository.findById(productId).orElseThrow();
    Assertions.assertThat(product.getStock()).isEqualTo(firstProduct.getStock() - 2);
  }

  @Test
  public void updateStockWithOptimisticLock() throws InterruptedException {
    //given
    Long productId = 1L;
    int threadCount = 2;

    Product firstProduct = productLockRepository.findById(productId).orElseThrow();

    ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
    CountDownLatch latch = new CountDownLatch(threadCount);

    for (int i = 0; i < threadCount; i++) {
      executorService.submit(() -> {
        try {
          productLockService.updateStockWithOptimisticLock(firstProduct.getName(), 1);
        } catch (Exception e) {
          System.out.println("낙관적 락 충돌 발생: " + e.getMessage());
        } finally {
          latch.countDown();
        }
      });
    }

    latch.await();  // 모든 스레드가 작업을 마칠 때까지 대기

    Product product = productLockRepository.findById(productId).orElseThrow();

    log.info("product info : {}", product.getStock());

    Assertions.assertThat(product.getStock())
        .isBetween(firstProduct.getStock() - 2, firstProduct.getStock() - 1); // 하나의 트랜잭션만 성공할 수도 있음
  }


}