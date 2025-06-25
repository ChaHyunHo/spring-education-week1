package com.tutorial.springeducationweek1.domain.user.service;

import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.domain.user.dto.UserRequest;
import com.tutorial.springeducationweek1.domain.user.dto.UserResponse;
import com.tutorial.springeducationweek1.domain.user.dto.UserSearchResponse;
import com.tutorial.springeducationweek1.domain.user.dto.UserUpdateRequest;
import com.tutorial.springeducationweek1.domain.user.entity.User;
import com.tutorial.springeducationweek1.domain.user.mapper.UserMapper;
import com.tutorial.springeducationweek1.domain.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

  private final UserMapper userMapper;
  private final UserRepository userRepository;

  @Transactional
  public List<UserSearchResponse> searchUser() {
    return userRepository.findAll().stream()
        .map(userMapper::toSearch)
        .toList();
  }

  @Transactional
  public UserResponse getUserById(Long userId) {
    User user = getUser(userId);
    return userMapper.toResponse(user);
  }

  @Transactional
  public void create(UserRequest request) {
    userRepository.save(userMapper.toEntity(request));
  }

  @Transactional
  public void update(Long userId, UserUpdateRequest userUpdateRequest) {
    User user = getUser(userId);

    user.setName(userUpdateRequest.getName());
    user.setEmail(userUpdateRequest.getEmail());

    userRepository.save(user);
  }

  @Transactional
  public void delete(Long userId) {
    userRepository.delete(getUser(userId));
  }

  public User getUser(Long userId) {
    return userRepository.findById(userId)
        .orElseThrow(() -> new ServiceException(ServiceExceptionCode.NOT_FOUNT_USER));
  }
}
