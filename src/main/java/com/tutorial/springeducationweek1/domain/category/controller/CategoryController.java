package com.tutorial.springeducationweek1.domain.category.controller;

import com.tutorial.springeducationweek1.common.response.ApiResponse;
import com.tutorial.springeducationweek1.domain.category.dto.CategoryRequest;
import com.tutorial.springeducationweek1.domain.category.dto.CategorySearchResponse;
import com.tutorial.springeducationweek1.domain.category.service.CategoryService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping("/hierarchy")
  public ApiResponse<List<CategorySearchResponse>> getCategoryHierarchy() {
    return ApiResponse.success(categoryService.findCategoryStructureCacheAside());
  }

  @PostMapping
  public ApiResponse<Void> create(@Valid @RequestBody CategoryRequest request) {
    categoryService.create(request);
    return ApiResponse.success();
  }
}
