package com.tutorial.springeducationweek1.domain.user.service;

import com.tutorial.springeducationweek1.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public void save() {

  }
}
