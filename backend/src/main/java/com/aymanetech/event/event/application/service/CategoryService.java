package com.aymanetech.event.event.application.service;

import com.aymanetech.event.event.application.dto.request.CategoryRequestDto;
import com.aymanetech.event.event.application.dto.response.CategoryResponseDto;
import com.aymanetech.event.event.domain.entity.Category;
import com.aymanetech.event.event.domain.vo.CategoryId;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> findAllCategories();

    CategoryResponseDto findCategoryById(CategoryId id);

    CategoryResponseDto createCategory(CategoryRequestDto request);

    CategoryResponseDto updateCategory(CategoryId id, CategoryRequestDto request);

    void deleteCategory(CategoryId id);

    Category findCategoryEntityById(CategoryId id);
}
