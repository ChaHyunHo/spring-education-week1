package com.tutorial.springeducationweek1.domain.product.controller;

import com.tutorial.springeducationweek1.common.response.ApiResponse;
import com.tutorial.springeducationweek1.domain.product.dto.ProductCreateRequest;
import com.tutorial.springeducationweek1.domain.product.dto.ProductCreateResponse;
import com.tutorial.springeducationweek1.domain.product.dto.ProductRequest;
import com.tutorial.springeducationweek1.domain.product.dto.ProductSearchResponse;
import com.tutorial.springeducationweek1.domain.product.dto.ProductUpdateRequest;
import com.tutorial.springeducationweek1.domain.product.dto.ProductUpdateResponse;
import com.tutorial.springeducationweek1.domain.product.service.ProductService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public ApiResponse<List<ProductSearchResponse>> findAll() {
    return ApiResponse.success(new ArrayList<ProductSearchResponse>());
  }

  @PostMapping("/userId")
  public ApiResponse<ProductCreateResponse> save(
      @RequestBody ProductCreateRequest productCreateRequest) {
    return ApiResponse.success(new ProductCreateResponse());
  }

  @PutMapping("/userId")
  public ApiResponse<ProductUpdateResponse> update(
      @RequestBody ProductUpdateRequest productUpdateRequest) {
    return ApiResponse.success(new ProductUpdateResponse());
  }

  @PatchMapping("/userId")
  public ApiResponse<ProductUpdateResponse> updateStatus(
      @RequestBody ProductUpdateRequest productUpdateRequest) {
    return ApiResponse.success(new ProductUpdateResponse());
  }

  @DeleteMapping("/userId")
  public ApiResponse<ProductRequest> delete() {
    return ApiResponse.success();
  }
}
