package com.tutorial.springeducationweek1.domain.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateStatusRequest {

  String name;
  String email;
}
