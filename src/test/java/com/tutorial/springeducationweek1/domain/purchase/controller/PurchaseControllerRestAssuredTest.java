package com.tutorial.springeducationweek1.domain.purchase.controller;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PurchaseControllerRestAssuredTest {

//  @LocalServerPort
//  private int port; // 실행된 서버의 포트 번호를 주입받음
//
//  @BeforeEach
//  void setUp() {
//    // 모든 테스트 실행 전, Rest Assured가 요청을 보낼 포트를 설정
//    RestAssured.port = port;
//  }
//
//  @Test
//  void create() throws Exception {
//    // given
//    String requestBody = """
//        {
//          "userId": 1,
//          "shippingAddress": "신림동",
//          "productRequests": [
//            {
//              "productId": 3,
//              "quantity": 2
//            }
//          ]
//        }
//        """;
//
//    // when & then
//    RestAssured.given().log().all()
//        .contentType(ContentType.JSON)
//        .body(requestBody)
//        .when()
//        .post("/api/purchases")
//        .then().log().all()
//        .statusCode(200)
//        .body("result", IsEqual.equalTo(true));
//  }
//
//  @Test
//  void 유저_없음_체크() throws Exception {
//    // given
//
//    // when
//
//  }
//
//  @Test
//  void 수량_체크() throws Exception {
//    // given
//
//    // when
//
//  }
}