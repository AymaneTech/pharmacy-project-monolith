package com.aymanetech.event.user.application.dto.request;

import com.aymanetech.event.common.application.validation.UniqueField;
import com.aymanetech.event.user.domain.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRegistrationRequestDto(
        @NotBlank @UniqueField(fieldName = "email", entityClass = User.class, message = "Email already taken") String email,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String password,
        @NotNull Long roleId
) {
}
