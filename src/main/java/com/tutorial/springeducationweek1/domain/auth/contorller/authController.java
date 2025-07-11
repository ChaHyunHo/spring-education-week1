package com.tutorial.springeducationweek1.domain.auth.contorller;

import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.common.response.ApiResponse;
import com.tutorial.springeducationweek1.domain.auth.dto.CustomUserDetails;
import com.tutorial.springeducationweek1.domain.auth.dto.LoginRequest;
import com.tutorial.springeducationweek1.domain.auth.dto.LoginResponse;
import com.tutorial.springeducationweek1.domain.auth.service.AuthService;
import com.tutorial.springeducationweek1.domain.user.entity.User;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class authController {

  private final AuthService loginService;
  private final AuthService authService;

  @PostMapping("/login")
  public ApiResponse<LoginResponse> login(HttpSession httpSession,
      @Valid @RequestBody LoginRequest request) {

    LoginResponse loginResponse = loginService.login(request);

    httpSession.setAttribute("userId", loginResponse.getUserId());
    httpSession.setAttribute("email", loginResponse.getEmail());

    return ApiResponse.success(loginResponse);
  }


  @GetMapping("/status")
  public ApiResponse<LoginResponse> getStatus(HttpSession httpSession,
      @AuthenticationPrincipal CustomUserDetails customUserDetails) {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (null == customUserDetails) {
      throw new ServiceException(ServiceExceptionCode.NOT_FOUNT_USER);
    }

    User user = customUserDetails.getUser();
    return ApiResponse.success(LoginResponse.builder()
        .userId(user.getId())
        .email(user.getEmail())
        .isAuthenticated(authentication.isAuthenticated())
        .authorities(customUserDetails.getAuthorities().stream().map(
            GrantedAuthority::getAuthority).toList())
        .timestamp(LocalDateTime.now())
        .build());
  }

  @PostMapping("/logout")
  public ApiResponse<Void> logout(HttpSession httpSession) {
    loginService.logout();
    httpSession.invalidate();
    return ApiResponse.success();
  }
}
