package com.aymanetech.event.user.domain.vo;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.Instant;

@Embeddable
public record Timestamp(
        Instant createdAt,
        Instant updatedAt
) implements Serializable {
}
