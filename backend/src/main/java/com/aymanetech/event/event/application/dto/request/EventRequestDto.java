package com.aymanetech.event.event.application.dto.request;

import com.aymanetech.event.event.domain.vo.BookingType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventRequestDto(@NotBlank String title,
                              @NotBlank String description,
                              @NotNull Integer numberOfSeats,
                              @NotNull BigDecimal price,
                              @NotNull LocalDateTime date,
                              @NotBlank String location,
                              BookingType bookingType,
                              @NotNull Long categoryId,
                              @NotNull Long userId
) {
}
