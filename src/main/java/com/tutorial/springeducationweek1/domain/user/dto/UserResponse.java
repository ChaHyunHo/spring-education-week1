package com.tutorial.springeducationweek1.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

  Long id;

  @NotNull(message = "Name must not be null")
  String name;

  @Email(message = "Email should be valid")
  String email;

  LocalDateTime createdAt;
}
