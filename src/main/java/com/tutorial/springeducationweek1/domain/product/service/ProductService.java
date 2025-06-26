package com.tutorial.springeducationweek1.domain.product.service;

import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.domain.product.dto.ProductRequest;
import com.tutorial.springeducationweek1.domain.product.dto.ProductSearchResponse;
import com.tutorial.springeducationweek1.domain.product.dto.ProductUpdateRequest;
import com.tutorial.springeducationweek1.domain.product.entity.Product;
import com.tutorial.springeducationweek1.domain.product.mapper.ProductMapper;
import com.tutorial.springeducationweek1.domain.product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductMapper productMapper;
  private final ProductRepository productRepository;

  @Transactional
  public List<ProductSearchResponse> searchProducts() {
    return productRepository.findAll().stream().map(productMapper::toSearch).toList();
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
    productRepository.deleteById(productId);
  }
}
