package com.tutorial.springeducationweek1.domain.product.mapper;

import com.tutorial.springeducationweek1.domain.product.dto.ProductCreateRequest;
import com.tutorial.springeducationweek1.domain.product.dto.ProductSearchResponse;
import com.tutorial.springeducationweek1.domain.product.entity.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

  ProductSearchResponse toSearch(Product product);

  Product toEntity(ProductCreateRequest request);
}
