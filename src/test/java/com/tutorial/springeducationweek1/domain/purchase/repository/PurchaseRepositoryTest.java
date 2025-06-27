package com.tutorial.springeducationweek1.domain.purchase.repository;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@Transactional // 실제 DB에 값을 쌓지 않기위해 선언함.
@SpringBootTest
class PurchaseRepositoryTest {

//  @Autowired
//  private PurchaseRepository purchaseRepository;
//
//  @Autowired
//  private UserRepository userRepository;
//
//  @Test
//  void 저장() {
//    User user = userRepository.save(User.builder()
//        .email("a2131cvx23a@naver.com")
//        .name("chamym")
//        .passwordHash("ddddddd")
//        .build());
//
//    Purchase purchase = Purchase.builder()
//        .user(user)
//        .status(PurchaseStatus.COMPLETION)
//        .totalPrice(BigDecimal.valueOf(100000))
//        .build();
//
//    purchaseRepository.save(purchase);

//    List<Purchase> purchases = new ArrayList<>();
//    purchaseRepository.save(purchase);

//  }

//  @Test
//  void 수정() {

//    User user = userRepository.save(User.builder()
//        .email("aa@naver.com")
//        .name("chamym")
//        .passwordHash("ddddddd")
//        .build());

//    User user = userRepository.findFirstByName("chamym").orElseThrow();
//
//    Purchase purchase = Purchase.builder()
//        .user(user)
//        .status(PurchaseStatus.PENDING)
//        .totalPrice(BigDecimal.valueOf(100000))
//        .build();
//
//    Purchase savePurchase = purchaseRepository.save(purchase);
//
//    savePurchase.setStatus(PurchaseStatus.CANCELLED);
//    purchaseRepository.save(savePurchase);
//
//  }

//  @Test
//  void 삭제() {
//    User user = userRepository.save(User.builder()
//        .email("aa3dd12@naver.com")
//        .name("chamym")
//        .passwordHash("ddddddd")
//        .build());
//
//    Purchase purchase = Purchase.builder()
//        .user(user)
//        .status(PurchaseStatus.PENDING)
//        .totalPrice(BigDecimal.valueOf(100000))
//        .build();
//
//    Purchase savePurchase = purchaseRepository.save(purchase);
//
//    purchaseRepository.delete(savePurchase);
//
//
//  }

//  @Test
//  void 조회() {
//    List<Purchase> purchases = purchaseRepository.findAllWithUsers();
//
//    for (Purchase p : purchases) {
//      System.out.println(p.getUser().getName()); // ← 여기서 N+1 방지 되어야 함
//    }

  //System.out.println("purchases 0st id:" + purchases.get(0).getId());

//    Purchase purchase = purchaseRepository.findById(1L)
//        .orElseThrow(() -> new RuntimeException("주문내역이 없습니다."));
//
//    System.out.println("purchase id:" + purchase.getTotalPrice());

//    System.out.println("=============================================");
//    System.out.println("=============================================");
//    System.out.println("=============================================");

//    List<User> user = userRepository.findAll();
  //.orElseThrow(() -> new RuntimeException("사용자가 없습니다."));

//    System.out.println("=============================================");
//    System.out.println("=============================================");
//    System.out.println("n + 1 문제 해결을 위한 방법 [JPQL에서 join fetch 사용\n]");

//    List<User> user2 = userRepository.findAllWithPurchases();
//
//    for (User user : user2) {
//      // user.getOrders()를 호출하는 순간, 각 User마다 쿼리 N번 발생
//      System.out.println("주문 이메일: " + user.getEmail());
//    }
//
//    System.out.println("=============================================");
//    System.out.println("=============================================");
//    System.out.println("=============================================");
//
//    purchaseRepository.findAll();
//  }
}