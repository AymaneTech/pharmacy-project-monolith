package com.aymanetech.event.user.application.dto.response;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * Response DTO for {@link com.aymanetech.event.user.domain.entity.Permission}
 */
public record PermissionResponseDto(Long id, @NotBlank String name) implements Serializable {
}