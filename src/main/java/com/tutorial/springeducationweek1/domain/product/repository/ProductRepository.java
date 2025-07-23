package com.tutorial.springeducationweek1.domain.product.repository;

import com.tutorial.springeducationweek1.domain.product.entity.Product;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("SELECT p FROM Product p ORDER BY p.id")
  List<Product> findContentOnly(Pageable pageable);

  @Query("""
          SELECT p FROM Product p
          WHERE (:lastCreatedAt IS NULL OR
                (p.createdAt < :lastCreatedAt) OR
                (p.createdAt = :lastCreatedAt AND p.id < :lastId))
          ORDER BY p.createdAt DESC, p.id DESC
      """)
  List<Product> findByCursor(
      @Param("lastCreatedAt") LocalDateTime lastCreatedAt,
      @Param("lastId") Long lastId,
      Pageable pageable
  );

  List<Product> findAllByStockGreaterThan(Integer stock);
}
