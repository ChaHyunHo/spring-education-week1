package com.tutorial.springeducationweek1.domain.refunds.repository;

import com.tutorial.springeducationweek1.domain.refunds.entity.Refunds;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundsRepository extends JpaRepository<Refunds, Long> {

  @Query("SELECT r FROM Refunds r JOIN FETCH r.purchase p JOIN FETCH p.user")
  List<Refunds> findAllWithPurchaseAndUser();

}
