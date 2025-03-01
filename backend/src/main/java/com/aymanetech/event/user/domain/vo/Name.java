package com.aymanetech.event.user.domain.vo;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public record Name(
        @NotBlank String firstName,
        @NotBlank String lastName
) {
}
