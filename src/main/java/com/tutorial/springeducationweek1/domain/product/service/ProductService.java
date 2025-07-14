package com.tutorial.springeducationweek1.domain.product.service;

import com.tutorial.springeducationweek1.common.annotation.ExecutionTime;
import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.domain.product.dto.CategoryOrderCountDTO;
import com.tutorial.springeducationweek1.domain.product.dto.CategoryProductDTO;
import com.tutorial.springeducationweek1.domain.product.dto.ProductRequest;
import com.tutorial.springeducationweek1.domain.product.dto.ProductSearchResponse;
import com.tutorial.springeducationweek1.domain.product.dto.ProductUpdateRequest;
import com.tutorial.springeducationweek1.domain.product.entity.Product;
import com.tutorial.springeducationweek1.domain.product.mapper.ProductMapper;
import com.tutorial.springeducationweek1.domain.product.repository.CategoryProductQueryRepository;
import com.tutorial.springeducationweek1.domain.product.repository.ProductRepository;
import com.tutorial.springeducationweek1.domain.product.repository.ProductsQueryRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductMapper productMapper;
  private final ProductRepository productRepository;
  private final ProductsQueryRepository productsQueryRepository;
  private final CategoryProductQueryRepository categoryProductQueryRepository;

  @Transactional(readOnly = true)
  public List<ProductSearchResponse> searchProducts(LocalDateTime lastCreatedAt, Long lastId,
      int size) {
    List<Product> products = productRepository.findByCursor(lastCreatedAt, lastId,
        Pageable.ofSize(size));
    return products.stream()
        .map(productMapper::toSearch)
        .toList();
  }

  @Transactional
  public ProductSearchResponse getProductById(Long productId) {
    return productMapper.toSearch(
        productRepository.findById(productId).orElseThrow(() -> new ServiceException(
            ServiceExceptionCode.NOT_FOUNT_DATA)));
  }

  @Transactional
  public void create(ProductRequest request) {
    productRepository.save(productMapper.toEntity(request));
  }

  @Transactional
  public void update(Long productId, ProductUpdateRequest request) {
    Product product = productRepository.findById(productId).orElseThrow(() -> new ServiceException(
        ServiceExceptionCode.NOT_FOUNT_DATA));

    product.setName(request.getName());
    product.setDescription(request.getDescription());
    product.setPrice(request.getPrice());
    product.setStock(request.getStock());

    productRepository.save(product);
  }

  @Transactional
  public void delete(Long productId) {
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new ServiceException(ServiceExceptionCode.NOT_FOUNT_PRODUCT));
    productRepository.delete(product);
  }

  @Transactional
  public List<CategoryOrderCountDTO> findCategoryOrderCounts() {
    return productsQueryRepository.findCategoryOrderCounts();
  }

  @Transactional
  public List<CategoryProductDTO> findCategoryProducts(String categoryName) {
    return categoryProductQueryRepository.findCategoryProducts(categoryName);
  }

  @ExecutionTime
  @Transactional
  public List<ProductSearchResponse> searchProduct(String name, BigDecimal minPrice,
      BigDecimal maxPrice) {
    return productsQueryRepository.searchProducts(name, minPrice, maxPrice);
  }
}
