package com.aymanetech.pharmacy.user.application.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Response DTO for {@link com.aymanetech.pharmacy.user.domain.entity.Role}
 */
public record RoleResponseDto(@NotNull Long id,
                              @NotBlank String name) {
}
