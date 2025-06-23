package com.tutorial.springeducationweek1.domain.user.controller;

import com.tutorial.springeducationweek1.domain.user.dto.UserRequest;
import com.tutorial.springeducationweek1.domain.user.dto.UserSearchResponse;
import com.tutorial.springeducationweek1.domain.user.dto.UserUpdateStatusRequest;
import com.tutorial.springeducationweek1.domain.user.service.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  @GetMapping("/{userId}")
  public ResponseEntity<List<UserSearchResponse>> findAll(
      @RequestParam(name = "email") String name) {

    List<UserSearchResponse> userSearchResponseList = new ArrayList<>();
    return ResponseEntity.ok().body(userSearchResponseList);
  }

  @PostMapping
  public ResponseEntity<Void> save(@RequestBody
  UserRequest request) {
    userService.save();
    return ResponseEntity.ok().build();
  }

  @PutMapping("/{userId}")
  public ResponseEntity<Void> update(@PathVariable Long userId, @RequestBody UserRequest request) {
    userService.save();
    return ResponseEntity.ok().build();
  }

  @PatchMapping("/{userId}")
  public ResponseEntity<Void> updateStatus(@PathVariable Long userId,
      @RequestBody UserUpdateStatusRequest request) {
    userService.save();
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<Void> delete(@PathVariable Long userId) {
    userService.save();
    return ResponseEntity.ok().build();
  }

}
