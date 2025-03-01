package com.aymanetech.event.user.application.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Request DTO for {@link com.aymanetech.event.user.domain.entity.User}
 */
public record UserRequestDto(@NotBlank String firstName,
                             @NotBlank String lastName,
                             @NotBlank String email,
                             @NotBlank String password,
                             @NotNull Long roleId
) {
}
