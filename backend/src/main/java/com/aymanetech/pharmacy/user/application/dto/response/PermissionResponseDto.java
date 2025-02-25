package com.aymanetech.pharmacy.user.application.dto.response;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * Response DTO for {@link com.aymanetech.pharmacy.user.domain.entity.Permission}
 */
public record PermissionResponseDto(Long id, @NotBlank String name) implements Serializable {
}