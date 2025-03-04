package com.aymanetech.event.user.application.dto.nested;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NestedUser(@NotNull Long id,
                         @NotBlank String firstName,
                         @NotBlank String lastName,
                         @NotBlank String email) {
}
