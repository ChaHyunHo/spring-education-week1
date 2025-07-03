package com.tutorial.springeducationweek1.domain.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void delete() throws Exception {  // 정상적인 상품 삭제 (성공 케이스)

    // given
    String productId = "3";

    // when
    mockMvc.perform(MockMvcRequestBuilders.delete(
                "/api/products/{productId}", productId)
            .contentType("application/json")
            .accept(MediaType.APPLICATION_JSON.toString()))
        .andExpect(MockMvcResultMatchers.status().isOk())
        // then
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(true));
  }


  @Test
  void delete_exception() throws Exception {  // 존재하지 않는 상품 삭제 (비즈니스 예외 케이스)

    // given
    String productId = "1312312";

    // when
    mockMvc.perform(MockMvcRequestBuilders.delete(
                "/api/products/{productId}", productId)
            .contentType("application/json")
            .accept(MediaType.APPLICATION_JSON.toString()))
        .andExpect(MockMvcResultMatchers.status().isOk())
        // then
        .andExpect(MockMvcResultMatchers.jsonPath("$.error.errorCode").value("NOT_FOUNT_PRODUCT"));
  }
}