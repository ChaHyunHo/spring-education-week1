package com.tutorial.springeducationweek1.domain.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {

  @NotNull
  String name;
  @NotNull
  String email;
  @NotNull
  String passwordHash;
}
