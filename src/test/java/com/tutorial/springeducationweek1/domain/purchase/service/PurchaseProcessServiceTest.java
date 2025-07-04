package com.tutorial.springeducationweek1.domain.purchase.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.tutorial.springeducationweek1.common.enums.PurchaseStatus;
import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.domain.product.entity.Product;
import com.tutorial.springeducationweek1.domain.product.repository.ProductRepository;
import com.tutorial.springeducationweek1.domain.purchase.dto.PurchaseProductRequest;
import com.tutorial.springeducationweek1.domain.purchase.entity.Purchase;
import com.tutorial.springeducationweek1.domain.purchase.mapper.PurchaseMapper;
import com.tutorial.springeducationweek1.domain.purchase.repository.PurchaseProductRepository;
import com.tutorial.springeducationweek1.domain.purchase.repository.PurchaseRepository;
import com.tutorial.springeducationweek1.domain.user.entity.User;
import com.tutorial.springeducationweek1.domain.user.repository.UserRepository;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.flywaydb.core.internal.util.JsonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
class PurchaseProcessServiceTest {

  // 테스트 대상 (Service)
  @InjectMocks // mock object 주입
  private PurchaseProcessService purchaseProcessService;

  // Mock 객체 주입
  @Mock
  private PurchaseRepository purchaseRepository;

  @Mock
  private ProductRepository productRepository;

  @Mock
  private PurchaseProductRepository purchaseProductRepository;

  @Mock
  private UserRepository userRepository;

  @Mock
  private PurchaseMapper purchaseMapper;

  private User testUser;
  private Purchase testPurchase;
  private Product testProduct;

  @BeforeEach
  void setUp() {
    testUser = User.builder()
        .name("TestUser")
        .email("chamym@naver.com")
        .passwordHash("password")
        .build();

    ReflectionTestUtils.setField(testUser, "id", 1L);

    testProduct = Product.builder()
        .name("노트북")
        .price(new BigDecimal(1000000))
        .stock(10)
        .build();

    ReflectionTestUtils.setField(testProduct, "id", 1L);

    testPurchase = Purchase.builder()
        .user(testUser)
        .totalPrice(BigDecimal.ZERO)
        .status(PurchaseStatus.PENDING)
        .build();

    ReflectionTestUtils.setField(testPurchase, "id", 1L);
  }

  @Test
  @DisplayName("재고가 충분한 상품을 구매하면 재고가 감소하고 구매가 성공한다.")
  void process_should_decreaseStockAndSucceed_when_productInStock() {
    // Given
    PurchaseProductRequest item = new PurchaseProductRequest();
    ReflectionTestUtils.setField(item, "productId", 1L);
    ReflectionTestUtils.setField(item, "quantity", 1);

    List<PurchaseProductRequest> purchaseItems = List.of(item);

    when(productRepository.findById(1L)).thenReturn(Optional.of(testProduct));
    when(purchaseRepository.save(any(Purchase.class))).thenReturn(testPurchase);
    when(purchaseProductRepository.saveAll(anyList())).thenReturn(Collections.emptyList());

    // when
    Purchase purchase = purchaseProcessService.process(testUser, "신림동", purchaseItems);

    System.out.println(JsonUtils.toJson(purchase));

    // then
    assertThat(purchase).isNotNull(); // null값 검증
    assertThat(purchase.getTotalPrice()).isEqualTo(new BigDecimal(1000000)); // 총금액 검증
    assertThat(testProduct.getStock()).isEqualTo(9); // 상품 수량 감소 체크

    verify(productRepository).findById(1L);
    verify(purchaseProductRepository).saveAll(anyList());
    verify(purchaseRepository).save(any(Purchase.class));
  }

  @Test
  @DisplayName("재고가 부족한 상품을 구매하면 예외가 발생한다.")
  void process_shouldServiceException_when_productOutOfStock() {
    // Given
    PurchaseProductRequest item = new PurchaseProductRequest();
    ReflectionTestUtils.setField(item, "productId", 1L);
    ReflectionTestUtils.setField(item, "quantity", 99);

    List<PurchaseProductRequest> purchaseItems = List.of(item);

    when(productRepository.findById(1L)).thenReturn(Optional.of(testProduct));
    when(purchaseRepository.save(any(Purchase.class))).thenReturn(testPurchase);
    //when(purchaseProductRepository.saveAll(anyList())).thenReturn(Collections.emptyList());

    // when
    ServiceException exception = assertThrows(ServiceException.class,
        () -> purchaseProcessService.process(testUser, "<UNK>", purchaseItems));

    // then
    assertThat(exception.getCode()).isEqualTo("INSUFFICIENT_STOCK"); // 재고 부족 오류 코드 검증

    verify(productRepository).findById(1L);
    verify(purchaseProductRepository, never()).saveAll(anyList());
    verify(purchaseRepository).save(any(Purchase.class));
  }

  @Test
  @DisplayName("존재하지 않는 상품을 구매하려고 하면 예외가 발생한다")
  void processPartialRefund_shouldThrowException_whenInputIsInvalid() {
    // Given
    PurchaseProductRequest item = new PurchaseProductRequest();
    ReflectionTestUtils.setField(item, "productId", 9999L); // 없는 상품 설정
    ReflectionTestUtils.setField(item, "quantity", 1);

    List<PurchaseProductRequest> purchaseItems = List.of(item);

    when(productRepository.findById(9999L)).thenReturn(Optional.empty());
    when(purchaseRepository.save(any(Purchase.class))).thenReturn(testPurchase);
    //when(purchaseProductRepository.saveAll(anyList())).thenReturn(Collections.emptyList());

    // when & then
    ServiceException exception = assertThrows(ServiceException.class,
        () -> purchaseProcessService.process(testUser, "신림동", purchaseItems));

    assertThat(exception.getCode()).isEqualTo("NOT_FOUNT_DATA");

    verify(productRepository).findById(9999L);

    verify(purchaseRepository).save(any(Purchase.class));
    verify(purchaseProductRepository, never()).saveAll(anyList());
  }

}
