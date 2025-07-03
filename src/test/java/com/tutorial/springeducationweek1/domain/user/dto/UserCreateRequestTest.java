package com.tutorial.springeducationweek1.domain.user.dto;

public class UserCreateRequestTest {

  public UserCreateRequestTest(String name, String email, String passwordHash) {
    this.name = name;
    this.email = email;
    this.passwordHash = passwordHash;
  }

  String name;
  String email;
  String passwordHash;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return passwordHash;
  }

  public void setPassword(String passwordHash) {
    this.passwordHash = passwordHash;
  }
}