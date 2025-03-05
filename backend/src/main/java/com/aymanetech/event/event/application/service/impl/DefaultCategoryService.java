package com.aymanetech.event.event.application.service.impl;

import com.aymanetech.event.common.application.service.ApplicationService;
import com.aymanetech.event.common.application.service.SlugService;
import com.aymanetech.event.common.exception.ResourceNotFoundException;
import com.aymanetech.event.event.application.dto.request.CategoryRequestDto;
import com.aymanetech.event.event.application.dto.response.CategoryResponseDto;
import com.aymanetech.event.event.application.mapper.CategoryMapper;
import com.aymanetech.event.event.application.service.CategoryService;
import com.aymanetech.event.event.domain.entity.Category;
import com.aymanetech.event.event.domain.repository.CategoryRepository;
import com.aymanetech.event.event.domain.vo.CategoryId;

import java.util.List;

@ApplicationService
public class DefaultCategoryService implements CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;
    private final SlugService slugService;

    public DefaultCategoryService(CategoryRepository repository, CategoryMapper mapper, SlugService slugService) {
        this.repository = repository;
        this.mapper = mapper;
        this.slugService = slugService;
        this.slugService.setRepository(repository);
    }


    @Override
    public List<CategoryResponseDto> findAllCategories() {
        return repository.findAll().stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @Override
    public CategoryResponseDto findCategoryById(CategoryId id) {
        return repository.findById(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id.value()));
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto request) {
        final var category = mapper.toEntity(request);
        category.setSlug(slugService.generateUniqueSlug(request.name()));
        final var savedCategory = repository.save(category);
        return mapper.toResponseDto(savedCategory);
    }

    @Override
    public CategoryResponseDto updateCategory(CategoryId id, CategoryRequestDto request) {
        final var category = findCategoryEntityById(id);
        mapper.updateEntity(category, request);
        category.setSlug(slugService.generateUniqueSlug(request.name()));
        return mapper.toResponseDto(category);
    }

    @Override
    public void deleteCategory(CategoryId id) {
        if (!repository.existsById(id))
            throw new ResourceNotFoundException("Category", id.value());
        repository.deleteById(id);
    }

    @Override
    public Category findCategoryEntityById(CategoryId id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id.value()));
    }
}
