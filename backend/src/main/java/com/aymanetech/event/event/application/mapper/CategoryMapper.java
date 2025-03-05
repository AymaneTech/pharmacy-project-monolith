package com.aymanetech.event.event.application.mapper;

import com.aymanetech.event.common.application.mapper.BaseMapper;
import com.aymanetech.event.event.application.dto.request.CategoryRequestDto;
import com.aymanetech.event.event.application.dto.response.CategoryResponseDto;
import com.aymanetech.event.event.domain.entity.Category;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface CategoryMapper extends BaseMapper<Category, CategoryRequestDto, CategoryResponseDto> {
}