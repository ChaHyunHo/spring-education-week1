package com.tutorial.springeducationweek1.domain.category.controller;

import com.tutorial.springeducationweek1.common.response.ApiResponse;
import com.tutorial.springeducationweek1.domain.category.dto.CategoryRequest;
import com.tutorial.springeducationweek1.domain.category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

  private final CategoryService categoryService;

  @PostMapping
  public ApiResponse<Void> create(@Valid @RequestBody CategoryRequest request) {
    categoryService.create(request);
    return ApiResponse.success();
  }
}
