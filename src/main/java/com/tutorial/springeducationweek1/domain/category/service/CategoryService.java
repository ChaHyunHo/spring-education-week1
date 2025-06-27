package com.tutorial.springeducationweek1.domain.category.service;

import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.domain.category.dto.CategoryRequest;
import com.tutorial.springeducationweek1.domain.category.entity.Category;
import com.tutorial.springeducationweek1.domain.category.repository.CategoryRepository;
import com.tutorial.springeducationweek1.domain.product.repository.CategoryProductQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryProductQueryRepository categoryProductQueryRepository;

  public void create(CategoryRequest request) {
    Category parent = null;
    if (request.getParentId() != null) {
      parent = categoryRepository.findById(request.getParentId())
          .orElseThrow(() -> new ServiceException(ServiceExceptionCode.NOT_FOUNT_CATEGORY_PARENT));
    }

    Category category = Category.builder()
        .name(request.getName())
        .parent(parent)
        .build();

    categoryRepository.save(category);
  }
}
