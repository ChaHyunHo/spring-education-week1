package com.tutorial.springeducationweek1.domain.purchase.repository;

import com.tutorial.springeducationweek1.domain.purchase.entity.Purchase;
import com.tutorial.springeducationweek1.domain.user.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

  //@Query("SELECT DISTINCT p FROM Purchase p JOIN FETCH p.user")
  //  @EntityGraph(attributePaths = {"user"})
  //  @Query("SELECT p FROM Purchase p")
  @Query("SELECT p FROM Purchase p JOIN FETCH p.user")
  List<Purchase> findAllWithUsers();

  Optional<Purchase> findByIdAndUser_Id(Long id, Long userId);

  Long user(User user);
}
