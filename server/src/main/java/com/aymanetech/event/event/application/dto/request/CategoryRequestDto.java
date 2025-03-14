package com.aymanetech.event.event.application.dto.request;

import com.aymanetech.event.common.application.validation.UniqueField;
import com.aymanetech.event.event.domain.entity.Category;
import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDto(
        @UniqueField(fieldName = "name", entityClass = Category.class, message = "category name already taken") @NotBlank String name,
        @NotBlank String description) {
}
