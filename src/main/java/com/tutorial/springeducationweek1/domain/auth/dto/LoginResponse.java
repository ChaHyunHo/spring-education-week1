package com.tutorial.springeducationweek1.domain.auth.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginResponse {

  Long userId;
  String email;
  String name;

}
