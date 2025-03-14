package com.aymanetech.event.user.application.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Response DTO for {@link com.aymanetech.event.user.domain.entity.Role}
 */
public record RoleResponseDto(@NotNull Long id,
                              @NotBlank String name) {
}
