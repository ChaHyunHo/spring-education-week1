package com.tutorial.springeducationweek1.domain.purchase.repository;

import com.tutorial.springeducationweek1.domain.purchase.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
