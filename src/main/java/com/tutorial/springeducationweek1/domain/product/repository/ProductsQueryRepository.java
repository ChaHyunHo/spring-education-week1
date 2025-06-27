package com.tutorial.springeducationweek1.domain.product.repository;

import static com.tutorial.springeducationweek1.domain.product.entity.QProduct.product;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tutorial.springeducationweek1.domain.product.entity.Product;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductsQueryRepository {

  private final JPAQueryFactory queryFactory;

  public Page<Product> findProducts(String name, Double minPrice, Double maxPrice,
      Pageable pageable) {
    List<Product> products = queryFactory
        .select(product)
        .from(product)
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .fetch();

    Long totalCount = queryFactory
        .select(product.count())
        .from(product)
        .fetchOne();

    return new PageImpl<>(products, pageable, totalCount);
  }

}
