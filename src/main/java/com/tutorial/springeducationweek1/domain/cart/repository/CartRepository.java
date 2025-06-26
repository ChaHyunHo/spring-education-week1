package com.tutorial.springeducationweek1.domain.cart.repository;

import com.tutorial.springeducationweek1.domain.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
