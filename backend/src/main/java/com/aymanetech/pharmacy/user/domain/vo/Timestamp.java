package com.aymanetech.pharmacy.user.domain.vo;

import java.time.Instant;
import java.time.LocalDateTime;

public record Timestamp(
        Instant createdAt,
        Instant updatedAt
) {
}
