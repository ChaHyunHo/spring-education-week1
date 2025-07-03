package com.tutorial.springeducationweek1.domain.purchase.service;


import com.tutorial.springeducationweek1.common.constants.Constants;
import com.tutorial.springeducationweek1.common.enums.PurchaseStatus;
import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.domain.product.entity.Product;
import com.tutorial.springeducationweek1.domain.purchase.dto.PurchaseCancelResponse;
import com.tutorial.springeducationweek1.domain.purchase.dto.PurchaseProductCancelResponse;
import com.tutorial.springeducationweek1.domain.purchase.entity.Purchase;
import com.tutorial.springeducationweek1.domain.purchase.entity.PurchaseProduct;
import com.tutorial.springeducationweek1.domain.purchase.repository.PurchaseProductRepository;
import com.tutorial.springeducationweek1.domain.purchase.repository.PurchaseRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PurchaseCancelService {

  private final PurchaseProductRepository purchaseProductRepository;
  private final PurchaseRepository purchaseRepository;

  @Transactional
  public PurchaseCancelResponse process(Long purchaseId, Long userId) {

    Purchase purchase = purchaseRepository.findByIdAndUser_Id(purchaseId,
            userId)
        .orElseThrow(() -> new ServiceException(ServiceExceptionCode.NOT_FOUNT_DATA));

    validatePurchaseStatus(purchase);
    purchase.setStatus(PurchaseStatus.CANCELLED);

    List<PurchaseProduct> purchaseProducts = purchaseProductRepository.findByPurchase_Id(
        purchaseId);

    restoreProductStock(purchaseProducts);

    List<PurchaseProductCancelResponse> purchaseProductCancelResponses = getPurchaseProductCancelResponses(
        purchaseProducts);

    return PurchaseCancelResponse.builder()
        .message(Constants.PURCHASE_CANCEL_MESSAGE)
        .cancelledAt(LocalDateTime.now())
        .status(PurchaseStatus.CANCELLED)
        .purchaseId(purchaseId)
        .purchaseProductCancelResponses(purchaseProductCancelResponses)
        .build();
  }

  private List<PurchaseProductCancelResponse> getPurchaseProductCancelResponses(
      List<PurchaseProduct> purchaseProducts) {

    return purchaseProducts.stream()
        .map((purchaseProduct) -> {
          Product product = purchaseProduct.getProduct();
          BigDecimal totalPrice = product.getPrice()
              .multiply(new BigDecimal(purchaseProduct.getQuantity()));

          return PurchaseProductCancelResponse.builder()
              .productId(product.getId())
              .name(product.getName())
              .quantity(purchaseProduct.getQuantity())
              .price(product.getPrice())
              .totalPrice(totalPrice)
              .build();
        }).toList();
  }

  private void validatePurchaseStatus(Purchase purchase) {
    if (purchase.getStatus() != PurchaseStatus.PENDING) {
      throw new ServiceException(ServiceExceptionCode.NOT_FOUNT_DATA);
    }
  }

  private void restoreProductStock(List<PurchaseProduct> purchaseProducts) {
    for (PurchaseProduct purchaseProduct : purchaseProducts) {
      Product product = purchaseProduct.getProduct();
      product.increaseStock(purchaseProduct.getQuantity());
    }
  }

}
