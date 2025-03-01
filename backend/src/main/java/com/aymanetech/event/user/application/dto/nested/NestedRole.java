package com.aymanetech.event.user.application.dto.nested;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NestedRole(@NotNull Long id,
                         @NotBlank String name) {
}
