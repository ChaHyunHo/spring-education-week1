package com.tutorial.springeducationweek1.domain.product.controller;

import com.tutorial.springeducationweek1.common.response.ApiResponse;
import com.tutorial.springeducationweek1.domain.product.dto.ProductRequest;
import com.tutorial.springeducationweek1.domain.product.dto.ProductSearchResponse;
import com.tutorial.springeducationweek1.domain.product.dto.ProductUpdateRequest;
import com.tutorial.springeducationweek1.domain.product.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public ApiResponse<List<ProductSearchResponse>> findAll() {
    return ApiResponse.success(productService.searchProducts());
  }

  @GetMapping("/{productId}")
  public ApiResponse<ProductSearchResponse> findById(@PathVariable Long productId) {
    return ApiResponse.success(productService.getProductById(productId));
  }

  // 상품 생성
  @PostMapping
  public ApiResponse<Void> create(@Valid @RequestBody ProductRequest request) {
    productService.create(request);
    return ApiResponse.success();
  }

  @PutMapping("/{productId}")
  public ApiResponse<Void> update(@PathVariable Long productId,
      @RequestBody ProductUpdateRequest request) {
    productService.update(productId, request);
    return ApiResponse.success();
  }

  @DeleteMapping("/{productId}")
  public ApiResponse<Void> delete(@PathVariable Long productId) {
    productService.delete(productId);
    return ApiResponse.success();
  }
}
