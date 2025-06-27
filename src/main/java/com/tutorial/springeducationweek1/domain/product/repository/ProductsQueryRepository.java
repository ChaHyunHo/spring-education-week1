package com.tutorial.springeducationweek1.domain.product.repository;

import static com.tutorial.springeducationweek1.domain.category.entity.QCategory.category;
import static com.tutorial.springeducationweek1.domain.product.entity.QProduct.product;
import static com.tutorial.springeducationweek1.domain.purchase.entity.QPurchaseProduct.purchaseProduct;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tutorial.springeducationweek1.domain.product.dto.CategoryOrderCountDTO;
import com.tutorial.springeducationweek1.domain.product.dto.ProductSearchResponse;
import com.tutorial.springeducationweek1.domain.product.dto.QCategoryOrderCountDTO;
import com.tutorial.springeducationweek1.domain.product.dto.QProductSearchResponse;
import com.tutorial.springeducationweek1.domain.product.entity.Product;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

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

  public List<ProductSearchResponse> searchProducts(String name, BigDecimal minPrice,
      BigDecimal maxPrice) {
    return queryFactory.select(new QProductSearchResponse(
            product.id,
            product.name,
            product.description,
            product.price,
            product.stock,
            product.createdAt
        ))
        .from(product)
        .where(
            nameContains(name),
            priceGoe(minPrice),
            priceLoe(maxPrice)
        ).fetch();
  }

  private BooleanExpression nameContains(String name) {
    return StringUtils.hasText(name) ? product.name.contains(name) : null;
  }

  private BooleanExpression priceGoe(BigDecimal minPrice) {
    return minPrice != null ? product.price.goe(minPrice) : null;
  }

  private BooleanExpression priceLoe(BigDecimal maxPrice) {
    return maxPrice != null ? product.price.loe(maxPrice) : null;
  }


  public List<CategoryOrderCountDTO> findCategoryOrderCounts() {
    return queryFactory.select(new QCategoryOrderCountDTO(
            category.name.as("categoryName"),
            purchaseProduct.countDistinct().as("orderCount")
        ))
        .from(purchaseProduct)
        .join(product).on(purchaseProduct.product.eq(product))
        .join(category).on(purchaseProduct.product.category.eq(category))
        .groupBy(category.name)
        .fetch();
  }
}
