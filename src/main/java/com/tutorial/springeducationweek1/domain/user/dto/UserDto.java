package com.tutorial.springeducationweek1.domain.user.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

  Long id;
  String name;
  String email;
  String passwordHash;
}
