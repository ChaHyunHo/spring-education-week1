package com.tutorial.springeducationweek1.domain.auth.service;

import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.domain.auth.dto.LoginRequest;
import com.tutorial.springeducationweek1.domain.auth.dto.LoginResponse;
import com.tutorial.springeducationweek1.domain.user.entity.User;
import com.tutorial.springeducationweek1.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  @Transactional
  public LoginResponse login(LoginRequest request) {
    User user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(() -> new ServiceException(ServiceExceptionCode.NOT_FOUNT_USER));

    if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
      throw new ServiceException(ServiceExceptionCode.NOT_FOUNT_USER);
    }

    UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

    Authentication authentication = authenticationManager.authenticate(authenticationToken);

    SecurityContextHolder.getContext().setAuthentication(authentication);

    return LoginResponse.builder()
        .userId(user.getId())
        .email(request.getEmail())
        .build();
  }

  public LoginResponse getLoginResponse(Long userId, String email) {

    if (ObjectUtils.isEmpty(userId) && ObjectUtils.isEmpty(email)) {
      throw new ServiceException(ServiceExceptionCode.NOT_FOUNT_USER);
    }

    return LoginResponse.builder()
        .userId(userId)
        .email(email)
        .build();
  }

  public void logout() {
    SecurityContextHolder.clearContext();
  }

}
