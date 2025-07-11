package com.tutorial.springeducationweek1.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordEncodingTest {

  @Autowired
  private PasswordEncoder encoder;


  @Test
  void setEncoder() {

    String password = "dddddd";
    System.out.println(encoder.encode(password));
  }
}
