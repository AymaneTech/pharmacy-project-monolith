package com.aymanetech.pharmacy.user.application.dto.response;


import com.aymanetech.pharmacy.user.application.dto.nested.NestedRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Response DTO for {@link com.aymanetech.pharmacy.user.domain.entity.User}
 */
public record UserResponseDto(@NotBlank String firstName,
                              @NotBlank String lastName,
                              @NotBlank String email,
                              @NotBlank String password,
                              @NotNull NestedRole role
                              ) {
}
