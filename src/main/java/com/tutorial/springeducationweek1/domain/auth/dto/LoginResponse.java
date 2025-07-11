package com.tutorial.springeducationweek1.domain.auth.dto;

import java.time.LocalDateTime;
import java.util.List;
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
  List<String> authorities;
  boolean isAuthenticated;
  LocalDateTime timestamp;

}
