package com.aymanetech.pharmacy.user.application.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * Request DTO for {@link com.aymanetech.pharmacy.user.domain.entity.Permission}
 */
public record PermissionRequestDto(@NotBlank String name) implements Serializable { }