package com.tutorial.springeducationweek1.domain.auth.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequest {

  String email;
  String password;

}
