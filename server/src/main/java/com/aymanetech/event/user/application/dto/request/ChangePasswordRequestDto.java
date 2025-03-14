package com.aymanetech.event.user.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ChangePasswordRequestDto(@NotBlank String oldPassword, @NotBlank String newPassword) {
}
