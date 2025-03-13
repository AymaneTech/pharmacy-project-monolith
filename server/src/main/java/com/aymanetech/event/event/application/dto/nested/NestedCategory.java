package com.aymanetech.event.event.application.dto.nested;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NestedCategory(@NotNull Long id,
                             @NotBlank String name,
                             @NotBlank String slug
) {
}
