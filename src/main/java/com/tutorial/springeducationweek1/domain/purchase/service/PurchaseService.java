package com.tutorial.springeducationweek1.domain.purchase.service;

import com.tutorial.springeducationweek1.common.enums.PurchaseStatus;
import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.domain.product.entity.Product;
import com.tutorial.springeducationweek1.domain.product.repository.ProductRepository;
import com.tutorial.springeducationweek1.domain.purchase.dto.PurchaseProductsRequest;
import com.tutorial.springeducationweek1.domain.purchase.dto.PurchaseRequest;
import com.tutorial.springeducationweek1.domain.purchase.entity.Purchase;
import com.tutorial.springeducationweek1.domain.purchase.entity.PurchaseProduct;
import com.tutorial.springeducationweek1.domain.purchase.repository.PurchaseRepository;
import com.tutorial.springeducationweek1.domain.user.entity.User;
import com.tutorial.springeducationweek1.domain.user.repository.UserRepository;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PurchaseService {

  private final UserRepository userRepository;
  private final PurchaseRepository purchaseRepository;
  private final ProductRepository productRepository;

  private PurchaseProcessService purchaseProcessService;

  // 단일 주문
  @Transactional
  public void placePurchase(PurchaseRequest request) {
    Integer quantity = request.getQuantity();

    // 사용자 조회
    User user = userRepository.findById(request.getUserId())
        .orElseThrow(() -> new ServiceException(ServiceExceptionCode.NOT_FOUNT_USER));

    // 상품조회
    Product product = productRepository.findById(request.getProductId())
        .orElseThrow(() -> new ServiceException(
            ServiceExceptionCode.NOT_FOUNT_DATA));

    // 수량검증
    if (product.getStock() < quantity) {
      throw new ServiceException(ServiceExceptionCode.INSUFFICIENT_STOCK);
    }

    // 상품재고 감소
    product.decreaseStock(quantity);

    // 주문생성
    Purchase purchase = Purchase.builder()
        .user(user)
        .totalPrice(product.getPrice().multiply(new BigDecimal(quantity)))
        .status(PurchaseStatus.COMPLETION)
        .shippingAddress(request.getShippingAddress())
        .build();

    // 주문아이템
    PurchaseProduct purchaseItem = PurchaseProduct.builder()
        .purchase(purchase)
        .product(product)
        .quantity(quantity)
        .price(product.getPrice())
        .build();

    purchase.addPurchaseItem(purchaseItem);
    Purchase savedPurchase = purchaseRepository.save(purchase);
  }

  // 리팩토링을 위한 주문 소스 세팅
  // 상품 복수 주문
  @Transactional
  public void createPurchase(PurchaseProductsRequest request) {

    // 사용자 정보 조회
    User user = userRepository.findById(request.getUserId())
        .orElseThrow(() -> new ServiceException(ServiceExceptionCode.NOT_FOUNT_USER));

    // 주문서 & 주문 상품 등록 처리
    purchaseProcessService.process(user, request.getShippingAddress(),
        request.getProductRequests());
  }
}
