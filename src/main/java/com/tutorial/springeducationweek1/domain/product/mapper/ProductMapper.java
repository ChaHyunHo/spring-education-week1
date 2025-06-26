package com.tutorial.springeducationweek1.domain.product.mapper;

import com.tutorial.springeducationweek1.domain.product.dto.ProductRequest;
import com.tutorial.springeducationweek1.domain.product.dto.ProductSearchResponse;
import com.tutorial.springeducationweek1.domain.product.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  ProductSearchResponse toSearch(Product product);

  Product toEntity(ProductRequest request);
}
