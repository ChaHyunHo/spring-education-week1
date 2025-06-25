package com.tutorial.springeducationweek1.domain.product.repository;

import com.tutorial.springeducationweek1.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
