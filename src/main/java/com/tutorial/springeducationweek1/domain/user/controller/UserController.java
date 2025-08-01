package com.tutorial.springeducationweek1.domain.user.controller;

import com.tutorial.springeducationweek1.common.response.ApiResponse;
import com.tutorial.springeducationweek1.domain.auth.dto.CustomUserDetails;
import com.tutorial.springeducationweek1.domain.user.dto.UserCreateRequest;
import com.tutorial.springeducationweek1.domain.user.dto.UserResponse;
import com.tutorial.springeducationweek1.domain.user.dto.UserSearchResponse;
import com.tutorial.springeducationweek1.domain.user.dto.UserUpdateRequest;
import com.tutorial.springeducationweek1.domain.user.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  @GetMapping
  public ApiResponse<List<UserSearchResponse>> findAll(
      @AuthenticationPrincipal CustomUserDetails userDetails) {

    return ApiResponse.success(userService.searchUser());
  }

  @GetMapping("/{userId}")
  public ApiResponse<UserResponse> findById(
      @PathVariable Long userId) {
    return ApiResponse.success(userService.getUserById(userId));
  }

  @PostMapping
  public ApiResponse<Void> create(@Valid @RequestBody
  UserCreateRequest request) {
    userService.create(request);
    return ApiResponse.success();
  }

  @PutMapping("/{userId}")
  public ApiResponse<Void> update(@PathVariable Long userId,
      @Valid @RequestBody UserUpdateRequest request) {
    userService.update(userId, request);
    return ApiResponse.success();
  }

  @DeleteMapping("/{userId}")
  public ApiResponse<Void> delete(@PathVariable Long userId) {
    userService.delete(userId);
    return ApiResponse.success();
  }

}
