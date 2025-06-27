package com.tutorial.springeducationweek1.domain.product.repository;

import static com.tutorial.springeducationweek1.domain.category.entity.QCategory.category;
import static com.tutorial.springeducationweek1.domain.product.entity.QProduct.product;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tutorial.springeducationweek1.domain.product.dto.CategoryProductDTO;
import com.tutorial.springeducationweek1.domain.product.dto.QCategoryProductDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
@RequiredArgsConstructor
public class CategoryProductQueryRepository {

  private final JPAQueryFactory queryFactory;

  public List<CategoryProductDTO> findCategoryProducts(String categoryName) {
    return queryFactory.select(new QCategoryProductDTO(
            category.name.as("categoryName"),
            product.name.as("productName"),
            product.price,
            product.stock
        ))
        .from(category)
        .join(product).on(product.category.id.eq(category.id), categoryNameContains(categoryName))
        .fetch();
  }

  private BooleanExpression categoryNameContains(String categoryName) {
    return StringUtils.hasText(categoryName) ? category.name.contains(categoryName) : null;
  }
}
