package com.tutorial.springeducationweek1.domain.category.repository;

import com.tutorial.springeducationweek1.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
