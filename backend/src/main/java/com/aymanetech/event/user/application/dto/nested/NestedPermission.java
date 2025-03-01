package com.aymanetech.event.user.application.dto.nested;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Request DTO for {@link com.aymanetech.event.user.domain.entity.Permission}
 */
public record NestedPermission(@NotNull Long id,
                               @NotBlank String name) {
}
