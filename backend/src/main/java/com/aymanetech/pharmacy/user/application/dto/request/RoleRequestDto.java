package com.aymanetech.pharmacy.user.application.dto.request;


import jakarta.validation.constraints.NotBlank;

/**
 * Request DTO for {@link com.aymanetech.pharmacy.user.domain.entity.Role}
 */
public record RoleRequestDto(@NotBlank String name) {
}
