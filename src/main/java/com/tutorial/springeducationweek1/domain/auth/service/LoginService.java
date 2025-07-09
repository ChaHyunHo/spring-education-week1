package com.tutorial.springeducationweek1.domain.auth.service;

import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.domain.auth.dto.LoginRequest;
import com.tutorial.springeducationweek1.domain.auth.dto.LoginResponse;
import com.tutorial.springeducationweek1.domain.user.entity.User;
import com.tutorial.springeducationweek1.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class LoginService {

  private final UserRepository userRepository;

  @Transactional
  public LoginResponse login(LoginRequest request) {
    User user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(() -> new ServiceException(ServiceExceptionCode.NOT_FOUNT_USER));

    return LoginResponse.builder()
        .userId(user.getId())
        .email(request.getEmail())
        .name(user.getName())
        .build();
  }

  public LoginResponse getLoginResponse(Long userId, String email, String name) {

    if (ObjectUtils.isEmpty(userId) && ObjectUtils.isEmpty(email) && ObjectUtils.isEmpty(name)) {
      throw new ServiceException(ServiceExceptionCode.NOT_FOUNT_USER);
    }

    return LoginResponse.builder()
        .userId(userId)
        .email(email)
        .name(name)
        .build();
  }

}
