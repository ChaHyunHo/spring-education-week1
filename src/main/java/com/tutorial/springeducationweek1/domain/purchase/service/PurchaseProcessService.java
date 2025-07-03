package com.tutorial.springeducationweek1.domain.purchase.service;

import com.tutorial.springeducationweek1.common.enums.PurchaseStatus;
import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.domain.product.entity.Product;
import com.tutorial.springeducationweek1.domain.product.repository.ProductRepository;
import com.tutorial.springeducationweek1.domain.purchase.dto.PurchaseProductRequest;
import com.tutorial.springeducationweek1.domain.purchase.entity.Purchase;
import com.tutorial.springeducationweek1.domain.purchase.entity.PurchaseProduct;
import com.tutorial.springeducationweek1.domain.purchase.repository.PurchaseProductRepository;
import com.tutorial.springeducationweek1.domain.purchase.repository.PurchaseRepository;
import com.tutorial.springeducationweek1.domain.user.entity.User;
import com.tutorial.springeducationweek1.domain.user.repository.UserRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PurchaseProcessService {

  private final UserRepository userRepository;
  private final PurchaseRepository purchaseRepository;
  private final ProductRepository productRepository;
  private final PurchaseProductRepository purchaseProductRepository;

  // 리팩토링을 위한 주문 소스 세팅
  // 상품 복수 주문
  @Transactional
  public void process(User user, String shippingAddress,
      List<PurchaseProductRequest> productRequests) {

    // 주문내역 등록
    Purchase purchase = savePurchase(user, shippingAddress);

    // 주문상품 등록
    List<PurchaseProduct> purchaseProducts = createPurchaseProduct(productRequests,
        purchase);

    // 총금액 계산
    BigDecimal totalPrice = calculateTotalPrice(purchaseProducts);
    purchase.setTotalPrice(totalPrice);
  }

  // 주문내역 생성
  private Purchase savePurchase(User user, String address) {
    return purchaseRepository.save(Purchase.builder()
        .user(user)
        .totalPrice(BigDecimal.ZERO)
        .status(PurchaseStatus.PENDING)
        .shippingAddress(address)
        .build());
  }

  // 주문 상품 생성
  private List<PurchaseProduct> createPurchaseProduct(List<PurchaseProductRequest> productRequests,
      Purchase purchase) {
    List<PurchaseProduct> purchaseProducts = new ArrayList<>();

    for (PurchaseProductRequest productRequest : productRequests) {
      Product product = productRepository.findById(productRequest.getProductId())
          .orElseThrow(() -> new ServiceException(ServiceExceptionCode.NOT_FOUNT_DATA));

      // 수량 검증
      validateStock(product, productRequest.getQuantity());

      product.decreaseStock(productRequest.getQuantity());
      PurchaseProduct purchaseItem = PurchaseProduct.builder()
          .purchase(purchase)
          .product(product)
          .quantity(productRequest.getQuantity())
          .price(product.getPrice())
          .build();

      purchaseProducts.add(purchaseItem);
      purchaseProductRepository.saveAll(purchaseProducts);
    }

    return purchaseProducts;
  }

  // 수량 검증
  private void validateStock(Product product, Integer quantity) {
    if (quantity > product.getStock()) {
      throw new ServiceException(ServiceExceptionCode.INSUFFICIENT_STOCK);
    }
  }

  // 총금액 계산
  private BigDecimal calculateTotalPrice(List<PurchaseProduct> purchaseProducts) {
    return purchaseProducts.stream()
        .map(p -> p.getPrice().multiply(BigDecimal.valueOf(p.getQuantity())))
        .reduce(BigDecimal.ZERO, BigDecimal::add);        // 모두 합산
  }

}
