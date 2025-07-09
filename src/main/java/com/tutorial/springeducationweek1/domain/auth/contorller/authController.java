package com.tutorial.springeducationweek1.domain.auth.contorller;

import com.tutorial.springeducationweek1.common.response.ApiResponse;
import com.tutorial.springeducationweek1.domain.auth.dto.LoginRequest;
import com.tutorial.springeducationweek1.domain.auth.dto.LoginResponse;
import com.tutorial.springeducationweek1.domain.auth.service.LoginService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class authController {

  private final LoginService loginService;

  @PostMapping("/login")
  public ApiResponse<LoginResponse> login(HttpSession httpSession,
      @Valid @RequestBody LoginRequest request) {

    LoginResponse loginResponse = loginService.login(request);

    httpSession.setAttribute("userId", loginResponse.getUserId());
    httpSession.setAttribute("email", loginResponse.getEmail());
    httpSession.setAttribute("name", loginResponse.getName());

    return ApiResponse.success(loginResponse);
  }

  @GetMapping("/status")
  public ApiResponse<LoginResponse> getStatus(HttpSession httpSession) {

    Long userId = (Long) httpSession.getAttribute("userId");
    String email = (String) httpSession.getAttribute("email");
    String name = (String) httpSession.getAttribute("name");

    return ApiResponse.success(loginService.getLoginResponse(userId, email, name));
  }

  @PostMapping("/logout")
  public ApiResponse<Void> logout(HttpSession httpSession) {
    httpSession.invalidate();
    return ApiResponse.success();
  }
}
