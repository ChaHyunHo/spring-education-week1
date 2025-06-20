package com.tutorial.springeducationweek1.domain.purchase.repository;

import com.tutorial.springeducationweek1.common.enums.PurchaseStatus;
import com.tutorial.springeducationweek1.domain.purchase.entity.Purchase;
import com.tutorial.springeducationweek1.domain.user.entity.User;
import com.tutorial.springeducationweek1.domain.user.repository.UserRepository;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


// @Transactional // 실제 DB에 값을 쌓지 않기위해 선언함.
@SpringBootTest
class PurchaseRepositoryTest {

  @Autowired
  private PurchaseRepository purchaseRepository;

  @Autowired
  private UserRepository userRepository;

  @Test
  void 저장() {
    User user = userRepository.save(User.builder()
        .email("a2131cvx23a@naver.com")
        .name("chamym")
        .passwordHash("ddddddd")
        .build());

    Purchase purchase = Purchase.builder()
        .user(user)
        .status(PurchaseStatus.COMPLETION)
        .totalPrice(BigDecimal.valueOf(100000))
        .build();

    purchaseRepository.save(purchase);

//    List<Purchase> purchases = new ArrayList<>();
//    purchaseRepository.save(purchase);

  }

  @Test
  void 수정() {

//    User user = userRepository.save(User.builder()
//        .email("aa@naver.com")
//        .name("chamym")
//        .passwordHash("ddddddd")
//        .build());

    User user = userRepository.findFirstByName("chamym").orElseThrow();

    Purchase purchase = Purchase.builder()
        .user(user)
        .status(PurchaseStatus.PENDING)
        .totalPrice(BigDecimal.valueOf(100000))
        .build();

    Purchase savePurchase = purchaseRepository.save(purchase);

    savePurchase.setStatus(PurchaseStatus.CANCELLED);
    purchaseRepository.save(savePurchase);

  }

  @Test
  void 삭제() {
    User user = userRepository.save(User.builder()
        .email("aa3dd12@naver.com")
        .name("chamym")
        .passwordHash("ddddddd")
        .build());

    Purchase purchase = Purchase.builder()
        .user(user)
        .status(PurchaseStatus.PENDING)
        .totalPrice(BigDecimal.valueOf(100000))
        .build();

    Purchase savePurchase = purchaseRepository.save(purchase);

    purchaseRepository.delete(savePurchase);


  }


  @Test
  void 조회() {
    List<Purchase> purchases = purchaseRepository.findAll();

    System.out.println("purchases length:" + purchases.size());

    Purchase purchase = purchaseRepository.findById(1L)
        .orElseThrow(() -> new RuntimeException("주문내역이 없습니다."));

    System.out.println("purchase id:" + purchase.getTotalPrice());
  }
}