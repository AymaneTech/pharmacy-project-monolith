package com.aymanetech.event.user.domain.vo;

import java.time.Instant;

public record Timestamp(
        Instant createdAt,
        Instant updatedAt
) {
}
