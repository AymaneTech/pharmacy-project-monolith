package com.aymanetech.pharmacy.user.domain.vo;

import jakarta.persistence.Embeddable;

@Embeddable
public record UserId(Long value) {
}
