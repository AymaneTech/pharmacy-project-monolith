package com.aymanetech.event.user.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateUserRequestDto(@NotBlank String firstName,
                                   @NotBlank String lastName,
                                   @NotBlank String email,
                                   @NotNull Long roleId) {
}
