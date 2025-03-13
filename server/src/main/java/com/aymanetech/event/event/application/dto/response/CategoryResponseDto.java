package com.aymanetech.event.event.application.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryResponseDto(@NotNull Long id,
                                  @NotBlank String name,
                                  @NotBlank String slug) {
}
// todo: why not to add here list of nested events
