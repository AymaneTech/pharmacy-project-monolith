package com.aymanetech.pharmacy.user.application.dto.request;

import com.aymanetech.pharmacy.common.application.validation.UniqueField;
import com.aymanetech.pharmacy.user.domain.entity.Permission;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * Request DTO for {@link com.aymanetech.pharmacy.user.domain.entity.Permission}
 */
public record PermissionRequestDto(
        @NotBlank @UniqueField(fieldName = "name", entityClass = Permission.class, message = "Permission name already exists")
        String name
) implements Serializable {
}