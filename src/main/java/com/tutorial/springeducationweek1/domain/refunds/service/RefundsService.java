package com.tutorial.springeducationweek1.domain.refunds.service;

import com.tutorial.springeducationweek1.common.enums.PurchaseStatus;
import com.tutorial.springeducationweek1.common.enums.RefundStatus;
import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.domain.purchase.entity.Purchase;
import com.tutorial.springeducationweek1.domain.purchase.repository.PurchaseRepository;
import com.tutorial.springeducationweek1.domain.refunds.dto.RefundRequest;
import com.tutorial.springeducationweek1.domain.refunds.entity.Refunds;
import com.tutorial.springeducationweek1.domain.refunds.mapper.RefundsMapper;
import com.tutorial.springeducationweek1.domain.refunds.repository.RefundsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RefundsService {

  private final PurchaseRepository purchaseRepository;
  private final RefundsRepository refundsRepository;
  private final RefundsMapper refundsMapper;

//  구현 가이드 (RefundService.java):
//
//
//  @Transactional 적용: 환불 로직을 처리할 processRefund 메서드를 생성하고, @Transactional 어노테이션을 붙입니다.
//
//  데이터 조회 및 사전 검증: 환불할 purchaseId로 구매 내역을 조회합니다.
//
//  비즈니스 규칙 검증: 조회된 Purchase 객체의 상태가 COMPLETED(구매 완료)가 맞는지 확인합니다. 만약 다른 상태라면 환불을 진행할 수 없으므로, 적절한 예외를 발생시킵니다.
//
//  연관 데이터 상태 변경:
//
//  해당 Purchase에 연결된 모든 PurchaseItem들을 순회하며, 각 상품(Product)의 재고(stock)를 다시 늘려줍니다.
//
//  Purchase 엔티티의 상태를 REFUNDED(환불 완료)로 변경합니다.
//
//      (핵심) 여기서도 **'변경 감지'**가 동작하므로, product와 purchase 객체를 다시 save()할 필요가 없습니다.
//
//
//
//  신규 데이터 생성: 환불 내역을 기록할 Refund 엔티티를 생성하고 저장합니다.

  @Transactional
  public void processRefund(Long purchaseId, RefundRequest request) {

    // 주문내역 조회
    Purchase purchase = purchaseRepository.findById(purchaseId)
        .orElseThrow(() -> new ServiceException(ServiceExceptionCode.NOT_FOUNT_DATA));

    // 구매 완료 상태 검증
    if (purchase.getStatus() != PurchaseStatus.COMPLETION) {
      throw new ServiceException(ServiceExceptionCode.INVALID_OPERATION);
    }

    // 순회하면서 주문수량만큼 상품 재고 증가
    purchase.getPurchaseProducts().forEach((p) -> {
      p.getProduct().setStock(p.getProduct().getStock() + p.getQuantity());
    });

    purchase.setStatus(PurchaseStatus.REFUNDED);

    // 환불 내역 생성
    refundsRepository.save(Refunds.builder()
        .purchase(purchase)
        .refundAmount(purchase.getTotalPrice())
        .reason(request.getReason())
        .status(RefundStatus.APPROVED)
        .method(request.getMethod())
        .bankAccount(request.getBankAccount())
        .isPartial(request.getIsPartial())
        .note(request.getNote())
        .build());

  }

}
