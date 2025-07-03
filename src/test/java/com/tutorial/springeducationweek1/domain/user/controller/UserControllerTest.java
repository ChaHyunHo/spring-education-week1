package com.tutorial.springeducationweek1.domain.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.springeducationweek1.domain.user.dto.UserRequestTest;
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
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void create() throws Exception {  // 정상적인 회원가입 (성공 케이스)

    // given
    UserRequestTest requestTest = new UserRequestTest("차현호", "fawfewf@naver.com",
        "testPassword");

    String requestBody = objectMapper.writeValueAsString(requestTest);

    // when
    mockMvc.perform(MockMvcRequestBuilders.post(
                "/api/users")
            .contentType("application/json")
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON.toString()))
        .andExpect(MockMvcResultMatchers.status().isOk())
        // then
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(true));

  }

  @Test
  void create_validate() throws Exception {  // 필수 필드 누락 (유효성 검증 실패 케이스)

    // given
    UserRequestTest requestTest = new UserRequestTest("차현호", null,
        "testPassword");

    String requestBody = objectMapper.writeValueAsString(requestTest);

    // when
    mockMvc.perform(MockMvcRequestBuilders.post(
                "/api/users")
            .contentType("application/json")
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON.toString()))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        // then
        .andExpect(MockMvcResultMatchers.jsonPath("$.error.errorCode").value("VALIDATE_ERROR"));

  }


}