package com.tutorial.springeducationweek1.domain.purchase.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.springeducationweek1.domain.purchase.dto.PurchaseProductRequestTest;
import com.tutorial.springeducationweek1.domain.purchase.dto.PurchaseRequestTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class PurchaseControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void create() throws Exception {
    // given
    List<PurchaseProductRequestTest> purchaseProductRequestTests = new ArrayList<>();
    purchaseProductRequestTests.add(new PurchaseProductRequestTest(4L, 2));

    PurchaseRequestTest requestTest = new PurchaseRequestTest(1L, 3L, 2, "신림동",
        purchaseProductRequestTests);

    String requestBody = new ObjectMapper().writeValueAsString(requestTest);

    // when
    mockMvc.perform(MockMvcRequestBuilders.post(
                "/api/purchases")
            .contentType("application/json")
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON.toString()))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(true));
  }

  @Test
  void 유저_없음_체크() throws Exception {
    // given
    List<PurchaseProductRequestTest> purchaseProductRequestTests = new ArrayList<>();
    purchaseProductRequestTests.add(new PurchaseProductRequestTest(3L, 2));

    PurchaseRequestTest requestTest = new PurchaseRequestTest(null, 3L, 2, "신림동",
        purchaseProductRequestTests);

    String requestBody = new ObjectMapper().writeValueAsString(requestTest);

    // when
    mockMvc.perform(MockMvcRequestBuilders.post(
                "/api/purchases")
            .contentType("application/json")
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON.toString()))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.jsonPath("$.error.errorCode").value("VALIDATE_ERROR"));


  }

  @Test
  void 수량_체크() throws Exception {
    // given
    List<PurchaseProductRequestTest> purchaseProductRequestTests = new ArrayList<>();
    purchaseProductRequestTests.add(new PurchaseProductRequestTest(3L, 10000000));

    PurchaseRequestTest requestTest = new PurchaseRequestTest(1L, 3L, 2, "신림동",
        purchaseProductRequestTests);

    String requestBody = new ObjectMapper().writeValueAsString(requestTest);

    // when
    mockMvc.perform(MockMvcRequestBuilders.post(
                "/api/purchases")
            .contentType("application/json")
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON.toString()))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.error.errorCode").value("INSUFFICIENT_STOCK"));


  }
}