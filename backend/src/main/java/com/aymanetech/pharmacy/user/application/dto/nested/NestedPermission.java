package com.aymanetech.pharmacy.user.application.dto.nested;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Request DTO for {@link com.aymanetech.pharmacy.user.domain.entity.Permission}
 */
public record NestedPermission(@NotNull Long id,
                               @NotBlank String name) {
}
