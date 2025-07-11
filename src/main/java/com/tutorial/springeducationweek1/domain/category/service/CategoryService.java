package com.tutorial.springeducationweek1.domain.category.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.springeducationweek1.common.annotation.ExecutionTime;
import com.tutorial.springeducationweek1.common.exception.ServiceException;
import com.tutorial.springeducationweek1.common.exception.ServiceExceptionCode;
import com.tutorial.springeducationweek1.common.utils.JedisUtil;
import com.tutorial.springeducationweek1.domain.category.dto.CategoryRequest;
import com.tutorial.springeducationweek1.domain.category.dto.CategorySearchResponse;
import com.tutorial.springeducationweek1.domain.category.entity.Category;
import com.tutorial.springeducationweek1.domain.category.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;
  //private final CategoryProductQueryRepository categoryProductQueryRepository;
  private final JedisUtil jedisUtil;

  private static final String CACHE_KEY_CARTEGORY_STRUCT = "category:structure";
  private final ObjectMapper objectMapper;

  @Transactional
  public void create(CategoryRequest request) {
    saveWriteThrough(request);
  }

  @ExecutionTime
  @Transactional
  public List<CategorySearchResponse> getCategoryHierarchy() {
    List<Category> categories = categoryRepository.findAll();

    long mapStart = System.nanoTime();
    List<CategorySearchResponse> topNode = new ArrayList<>();
    Map<Long, CategorySearchResponse> treeMap = new HashMap<>();

    for (Category flat : categories) {
      CategorySearchResponse categoryTreeDto = new CategorySearchResponse();
      categoryTreeDto.setId(flat.getId());
      categoryTreeDto.setName(flat.getName());
      treeMap.put(flat.getId(), categoryTreeDto);
    }

    for (Category flat : categories) {
      CategorySearchResponse node = treeMap.get(flat.getId());

      if (flat.getParent() == null) {
        topNode.add(node);
      } else {
        CategorySearchResponse parent = treeMap.get(flat.getParent().getId());
        parent.getChildren().add(node);
      }
    }

    return topNode;
  }

  @ExecutionTime
  @Transactional(readOnly = true)
  public List<CategorySearchResponse> findCategoryStructureCacheAside() {
    String cachedCategories = jedisUtil.getValue(CACHE_KEY_CARTEGORY_STRUCT);

    try {
      if (StringUtils.hasText(cachedCategories)) {
        return objectMapper.readValue(cachedCategories, new TypeReference<>() {
        });
      }

      List<CategorySearchResponse> categorySearchResponses = getCategoryHierarchy();
      jedisUtil.saveObject(CACHE_KEY_CARTEGORY_STRUCT, categorySearchResponses, 3600);

      return categorySearchResponses;
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      throw new RuntimeException("JSON 파싱 오류");

    }
  }

  @Transactional
  public void saveWriteThrough(CategoryRequest request) {

    createCategory(request);

    try {
      List<CategorySearchResponse> categorySearchResponses = getCategoryHierarchy();

      if (!ObjectUtils.isEmpty(categorySearchResponses)) {
        jedisUtil.saveObject(CACHE_KEY_CARTEGORY_STRUCT, categorySearchResponses);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Transactional
  public void saveWriteBack(CategoryRequest request) {
    try {
      String cachedCategory = jedisUtil.getValue(CACHE_KEY_CARTEGORY_STRUCT);
      List<CategorySearchResponse> categorySearchResponses = new ArrayList<>();

      if (!ObjectUtils.isEmpty(categorySearchResponses)) {
        categorySearchResponses = objectMapper.readValue(cachedCategory, new TypeReference<>() {
        });
      }

      CategorySearchResponse newCategory = CategorySearchResponse.builder()
          .name(request.getName())
          .build();

      categorySearchResponses.add(newCategory);
      
      jedisUtil.saveObject(CACHE_KEY_CARTEGORY_STRUCT, categorySearchResponses);

      saveToDatabaseAsync(request);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Async
  public void saveToDatabaseAsync(CategoryRequest request) {
    createCategory(request);
  }

  private void createCategory(CategoryRequest request) {
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
