package com.tutorial.springeducationweek1.domain.user.repository;

import com.tutorial.springeducationweek1.domain.user.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findFirstByName(String name);

  @Query("SELECT u FROM User u JOIN FETCH u.purchases")
  List<User> findAllWithPurchases();

  Optional<User> findByEmail(String email);

  Optional<User> findUserByEmail(String email);
}
