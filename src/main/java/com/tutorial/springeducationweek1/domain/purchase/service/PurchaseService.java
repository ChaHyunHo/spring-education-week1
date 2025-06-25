package com.tutorial.springeducationweek1.domain.purchase.service;

import com.tutorial.springeducationweek1.domain.purchase.repository.PurchaseRepository;
import com.tutorial.springeducationweek1.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseService {

  private final UserRepository userRepository;
  private final PurchaseRepository purchaseRepository;
}
