package com.aymanetech.event.user.application.dto.request;


import jakarta.validation.constraints.NotBlank;

/**
 * Request DTO for {@link com.aymanetech.event.user.domain.entity.Role}
 */
public record RoleRequestDto(@NotBlank String name) {
}
